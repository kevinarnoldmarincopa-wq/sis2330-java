# Semana 05 - Colecciones

## Sistema de Estudiantes Avanzado

Sistema de gestión de estudiantes desarrollado en Java utilizando el Java Collections Framework.

## Colecciones utilizadas

- HashMap: permite buscar estudiantes por código.
- TreeSet: mantiene el ranking ordenado por promedio descendente.
- ArrayList: permite obtener el ranking y el Top N.

## Funcionalidades

1. Registrar estudiante.
2. Buscar estudiante por código.
3. Actualizar promedio.
4. Mostrar ranking.
5. Mostrar Top N.
6. Eliminar estudiante.

## Compilación

javac -d semana05/out semana05/src/modelo/Estudiante.java semana05/src/servicio/SistemaEstudiantes.java semana05/src/Principal.java

## Ejecución

java -cp semana05/out Principal
