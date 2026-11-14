package servicio;

import modelo.Estudiante;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

public class SistemaEstudiantes {
    private final Map<String, Estudiante> porCodigo = new HashMap<>();
    private final TreeSet<Estudiante> ranking = new TreeSet<>();

    public boolean registrar(Estudiante estudiante) {
        if (porCodigo.containsKey(estudiante.getCodigo())) {
            return false;
        }
        porCodigo.put(estudiante.getCodigo(), estudiante);
        ranking.add(estudiante);
        return true;
    }

    public Estudiante buscarPorCodigo(String codigo) {
        return porCodigo.get(codigo);
    }

    public boolean actualizarPromedio(String codigo, double promedio) {
        Estudiante estudiante = porCodigo.get(codigo);
        if (estudiante == null) return false;

        ranking.remove(estudiante);
        estudiante.setPromedio(promedio);
        ranking.add(estudiante);
        return true;
    }

    public List<Estudiante> listarRanking() {
        return new ArrayList<>(ranking);
    }

    public List<Estudiante> topN(int n) {
        List<Estudiante> resultado = new ArrayList<>();
        int limite = Math.min(n, ranking.size());
        int contador = 0;

        for (Estudiante estudiante : ranking) {
            if (contador++ >= limite) break;
            resultado.add(estudiante);
        }
        return resultado;
    }

    public boolean eliminar(String codigo) {
        Estudiante estudiante = porCodigo.remove(codigo);
        if (estudiante == null) return false;
        ranking.remove(estudiante);
        return true;
    }

    public int cantidad() {
        return porCodigo.size();
    }
}
