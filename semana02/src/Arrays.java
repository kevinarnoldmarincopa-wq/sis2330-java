public class Arrays {
    public static void main(String[] args) {
        int[] notas = {85, 90, 78, 95, 60};

        System.out.println("Notas de estudiantes:");

        for (int i = 0; i < notas.length; i++) {
            System.out.println("Nota " + (i + 1) + ": " + notas[i]);
        }

        int suma = 0;

        for (int nota : notas) {
            suma += nota;
        }

        double promedio = (double) suma / notas.length;

        System.out.println("Promedio: " + promedio);
    }
}
