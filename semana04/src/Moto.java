public class Moto extends Vehiculo {

    public Moto(String marca, String modelo, double velocidadMax) {
        super(marca, modelo, velocidadMax);
    }

    @Override
    public String describir() {
        return "Soy una moto " + marca + " " + modelo;
    }
}
