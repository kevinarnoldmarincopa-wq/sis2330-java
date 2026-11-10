
import java.util.Scanner;

public class SistemaCalificaciones {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("=== SISTEMA DE CALIFICACIONES ===");

        System.out.print("Ingrese nombre del estudiante: ");
        String nombre = sc.nextLine();

        double[] notas = new double[3];

        for (int i = 0; i < 3; i++) {
            System.out.print("Ingrese nota " + (i + 1) + ": ");
            notas[i] = sc.nextDouble();
        }

        System.out.println("\nEstudiante: " + nombre);
        System.out.println("Notas registradas:");
double maxima = notas[0];
double minima = notas[0];

for (int i = 1; i < 3; i++) {
    if (notas[i] > maxima) {
        maxima = notas[i];
    }

    if (notas[i] < minima) {
        minima = notas[i];
    }
}

System.out.println("Nota maxima: " + maxima);
System.out.println("Nota minima: " + minima);
double suma = 0;

for (int i = 0; i < 3; i++) {
    suma += notas[i];
}

double promedio = suma / 3;
System.out.println("Promedio: " + promedio);
if (promedio >= 51) {
    System.out.println("Estado: APROBADO");
} else {
    System.out.println("Estado: REPROBADO");
}  		
for (int i = 0; i < 3; i++) {
            System.out.println(notas[i]);
        }

        sc.close();
    }
}
