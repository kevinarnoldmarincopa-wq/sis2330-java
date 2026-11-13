
import java.util.Objects;

public class Estudiante {
    private String codigo;
    private String nombre;

    public Estudiante(String codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Estudiante)) return false;

        Estudiante otro = (Estudiante) obj;
        return Objects.equals(codigo, otro.codigo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo);
    }

}

