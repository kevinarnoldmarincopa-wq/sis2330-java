package servicio;

import modelo.Estudiante;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeSet;
import java.util.Map;

public class SistemaEstudiantes {

    private Map<String, Estudiante> estudiantes = new HashMap<>();
    private TreeSet<Estudiante> ranking = new TreeSet<>();

    public boolean registrar(Estudiante e) {
        if (estudiantes.containsKey(e.getCodigo())) {
            return false;
        }

        estudiantes.put(e.getCodigo(), e);
        ranking.add(e);
        return true;
    }

    public Estudiante buscar(String codigo) {
        return estudiantes.get(codigo);
    }

    public boolean actualizar(String codigo, double promedio) {
        Estudiante e = estudiantes.get(codigo);

        if (e == null) {
            return false;
        }

        ranking.remove(e);
        e.setPromedio(promedio);
        ranking.add(e);
        return true;
    }

    public ArrayList<Estudiante> listarRanking() {
        return new ArrayList<>(ranking);
    }

    public ArrayList<Estudiante> topN(int n) {
        ArrayList<Estudiante> resultado = new ArrayList<>();

        for (Estudiante e : ranking) {
            if (resultado.size() >= n) {
                break;
            }
            resultado.add(e);
        }

        return resultado;
    }

    public boolean eliminar(String codigo) {
        Estudiante e = estudiantes.remove(codigo);

        if (e == null) {
            return false;
        }

        ranking.remove(e);
        return true;
    }
}
