public class AutoElectrico extends Auto implements Electrico {

    public AutoElectrico(String marca, String modelo, double velocidadMax, int numPuertas) {
        super(marca, modelo, velocidadMax, numPuertas);
    }

    @Override
    public void cargarBateria() {
        System.out.println("Cargando bateria del auto electrico.");
    }

    @Override
    public String describir() {
        return "Soy un auto electrico " + marca + " " + modelo;
    }
}
