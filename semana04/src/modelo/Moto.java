
package modelo;

public class Moto extends Vehiculo {

    private String tipo;

    public Moto(String marca, String modelo, double velocidadMax, String tipo) {
        super(marca, modelo, velocidadMax);
        this.tipo = tipo;
    }

    @Override
    public String describir() {
        return "Moto: " + marca + " " + modelo +
               " - Tipo: " + tipo;
    }
}

