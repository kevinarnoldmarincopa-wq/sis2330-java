
import java.util.Scanner;
import java.util.InputMismatchException;

public class SistemaCalificaciones {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] nombres = new String[5];
        double[][] notas = new double[5][3];

        // Registrar estudiantes
        for (int i = 0; i < 5; i++) {
            System.out.println("\nEstudiante " + (i + 1));

            System.out.print("Nombre: ");
            nombres[i] = sc.nextLine();

            // Registrar notas con validacion
            for (int j = 0; j < 3; j++) {
                boolean valido = false;

                while (!valido) {
                    try {
                        System.out.print("Nota " + (j + 1) + ": ");
                        notas[i][j] = sc.nextDouble();

                        if (notas[i][j] >= 0 && notas[i][j] <= 100) {
                            valido = true;
                        } else {
                            System.out.println("Error: nota entre 0 y 100.");
                        }

                    } catch (InputMismatchException e) {
                        System.out.println("Error: ingrese un numero.");
                        sc.next();
                    }
                }
            }

            sc.nextLine();
        }

        // Reporte final
        System.out.println("\n=== REPORTE FINAL ===");

        for (int i = 0; i < 5; i++) {
            double prom = promedio(notas[i]);
            double max = maximo(notas[i]);
            double min = minimo(notas[i]);
            String resultado = estado(prom);

            System.out.println("\nEstudiante: " + nombres[i]);
            System.out.println("Promedio: " + prom);
            System.out.println("Nota maxima: " + max);
            System.out.println("Nota minima: " + min);
            System.out.println("Estado: " + resultado);
        }

        sc.close();
    }

    static double promedio(double[] notas) {
        double suma = 0;

        for (int i = 0; i < notas.length; i++) {
            suma += notas[i];
        }

        return suma / notas.length;
    }

    static double maximo(double[] notas) {
        double mayor = notas[0];

        for (int i = 1; i < notas.length; i++) {
            if (notas[i] > mayor) {
                mayor = notas[i];
            }
        }

        return mayor;
    }

    static double minimo(double[] notas) {
        double menor = notas[0];

        for (int i = 1; i < notas.length; i++) {
            if (notas[i] < menor) {
                menor = notas[i];
            }
        }

        return menor;
    }

    static String estado(double promedio) {
        if (promedio >= 51) {
            return "APROBADO";
        } else {
            return "REPROBADO";
        }
    }
}

