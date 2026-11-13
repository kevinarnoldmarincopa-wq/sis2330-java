
package app;

import modelo.Vehiculo;
import modelo.Auto;
import modelo.Moto;
import modelo.Camion;
import modelo.AutoElectrico;
import modelo.Electrico;

import java.util.ArrayList;

public class GestionVehiculos {

    public static void main(String[] args) {

        ArrayList<Vehiculo> vehiculos = new ArrayList<>();

        vehiculos.add(new Auto("Toyota", "Corolla", 180, 4));
        vehiculos.add(new Moto("Honda", "CBR", 200, "Deportiva"));
        vehiculos.add(new Camion("Volvo", "FH", 120, 20));
        vehiculos.add(new AutoElectrico("Tesla", "Model 3", 250, 4));

        System.out.println("=== GESTION DE VEHICULOS ===");

        for (Vehiculo v : vehiculos) {
            System.out.println(v.describir());

            if (v instanceof Electrico e) {
                e.cargarBateria();
            }
        }
    }
}

