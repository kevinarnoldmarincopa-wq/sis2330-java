
package modelo;

public class Auto extends Vehiculo {

    private int numPuertas;

    public Auto(String marca, String modelo, double velocidadMax, int numPuertas) {
        super(marca, modelo, velocidadMax);
        this.numPuertas = numPuertas;
    }

    @Override
    public String describir() {
        return "Auto: " + marca + " " + modelo +
               " - Puertas: " + numPuertas;
    }
}

