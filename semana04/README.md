
# Semana 04 - POO II

## Objetivo
Aplicar herencia, polimorfismo, clases abstractas e interfaces
en Java.

## Conceptos
- Herencia con extends.
- Uso de super().
- Polimorfismo.
- Clases abstractas.
- Interfaces.
- instanceof.
- Sobrescritura de métodos con @Override.
- toString().
- equals() y hashCode().

## Proyecto: Gestion de Vehiculos

Se implementaron las clases:
- Vehiculo (clase abstracta).
- Auto.
- Moto.
- Camion.
- Electrico (interfaz).
- AutoElectrico.

El programa utiliza ArrayList<Vehiculo> para almacenar
vehículos y recorrerlos mediante polimorfismo.

Los vehículos eléctricos permiten cargar su batería
mediante la interfaz Electrico.

## Compilación

javac -d semana04/out semana04/src/modelo/*.java semana04/src/app/GestionVehiculos.java

## Ejecución

java -cp semana04/out app.GestionVehiculos

