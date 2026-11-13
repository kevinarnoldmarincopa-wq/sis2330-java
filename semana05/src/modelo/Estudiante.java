package modelo;

import java.util.Objects;

public class Estudiante implements Comparable<Estudiante> {

    private String codigo;
    private String nombre;
    private double promedio;

    public Estudiante(String codigo, String nombre, double promedio) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.promedio = promedio;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPromedio() {
        return promedio;
    }

    public void setPromedio(double promedio) {
        this.promedio = promedio;
    }

    @Override
    public int compareTo(Estudiante otro) {
        int resultado = Double.compare(otro.promedio, this.promedio);

        if (resultado != 0) {
            return resultado;
        }

        return this.codigo.compareTo(otro.codigo);
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

    @Override
    public String toString() {
        return String.format("#%s %s (%.1f)", codigo, nombre, promedio);
    }
}
