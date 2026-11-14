package modelo;

import java.util.Objects;

public class Estudiante implements Comparable<Estudiante> {
    private final String codigo;
    private final String nombre;
    private double promedio;

    public Estudiante(String codigo, String nombre, double promedio) {
        if (codigo == null || codigo.isBlank()) {
            throw new IllegalArgumentException("Codigo invalido");
        }
        if (promedio < 0 || promedio > 100) {
            throw new IllegalArgumentException("Promedio fuera de rango");
        }
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
        if (promedio < 0 || promedio > 100) {
            throw new IllegalArgumentException("Promedio fuera de rango");
        }
        this.promedio = promedio;
    }

    @Override
    public int compareTo(Estudiante otro) {
        int resultado = Double.compare(otro.promedio, this.promedio);
        if (resultado == 0) {
            return this.codigo.compareTo(otro.codigo);
        }
        return resultado;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Estudiante)) return false;
        Estudiante otro = (Estudiante) obj;
        return codigo.equals(otro.codigo);
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
