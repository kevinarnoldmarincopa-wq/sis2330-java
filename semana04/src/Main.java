
public class Main {

    public static void main(String[] args) {

        Vehiculo v1 = new Auto("Toyota", "Corolla", 180, 4);
        Vehiculo v2 = new Moto("Honda", "CBR", 200);
        Vehiculo v3 = new AutoElectrico("Tesla", "Model 3", 250, 4);

        System.out.println(v1.describir());
        System.out.println(v2.describir());
        System.out.println(v3.describir());

        if (v3 instanceof Electrico e) {
            e.cargarBateria();
        }

        System.out.println("----- toString -----");
        System.out.println(v1);
        System.out.println(v2);
        System.out.println(v3);

        System.out.println("----- equals -----");
        System.out.println(v1.equals(v2));
    }
}

