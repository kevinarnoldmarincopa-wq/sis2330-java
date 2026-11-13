
package modelo;

public class Camion extends Vehiculo {

    private double capacidadCarga;

    public Camion(String marca, String modelo, double velocidadMax, double capacidadCarga) {
        super(marca, modelo, velocidadMax);
        this.capacidadCarga = capacidadCarga;
    }

    @Override
    public String describir() {
        return "Camion: " + marca + " " + modelo +
               " - Capacidad de carga: " + capacidadCarga + " toneladas";
    }
}

