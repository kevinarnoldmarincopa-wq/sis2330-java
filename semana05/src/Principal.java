import modelo.Estudiante;
import servicio.SistemaEstudiantes;
import java.util.Scanner;
import java.util.ArrayList;

public class Principal {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        SistemaEstudiantes sistema = new SistemaEstudiantes();

        int opcion;

        do {
            System.out.println("\n=== SISTEMA DE ESTUDIANTES ===");
            System.out.println("1. Registrar estudiante");
            System.out.println("2. Buscar estudiante");
            System.out.println("3. Actualizar promedio");
            System.out.println("4. Ver ranking");
            System.out.println("5. Ver Top N");
            System.out.println("6. Eliminar estudiante");
            System.out.println("7. Salir");
            System.out.print("Opcion: ");

            opcion = Integer.parseInt(sc.nextLine());

            switch (opcion) {

                case 1:
                    System.out.print("Codigo: ");
                    String codigo = sc.nextLine();

                    System.out.print("Nombre: ");
                    String nombre = sc.nextLine();

                    System.out.print("Promedio: ");
                    double promedio = Double.parseDouble(sc.nextLine());

                    Estudiante e = new Estudiante(codigo, nombre, promedio);

                    if (sistema.registrar(e)) {
                        System.out.println("Estudiante registrado.");
                    } else {
                        System.out.println("Codigo duplicado.");
                    }
                    break;

                case 2:
                    System.out.print("Codigo: ");
                    codigo = sc.nextLine();

                    e = sistema.buscar(codigo);

                    System.out.println(e != null ? e : "No encontrado.");
                    break;

                case 3:
                    System.out.print("Codigo: ");
                    codigo = sc.nextLine();

                    System.out.print("Nuevo promedio: ");
                    promedio = Double.parseDouble(sc.nextLine());

                    System.out.println(sistema.actualizar(codigo, promedio)
                            ? "Promedio actualizado."
                            : "No encontrado.");
                    break;

                case 4:
                    System.out.println("\n=== RANKING ===");

                    for (Estudiante est : sistema.listarRanking()) {
                        System.out.println(est);
                    }
                    break;

                case 5:
                    System.out.print("Cantidad: ");
                    int n = Integer.parseInt(sc.nextLine());

                    ArrayList<Estudiante> top = sistema.topN(n);

                    for (Estudiante est : top) {
                        System.out.println(est);
                    }
                    break;

                case 6:
                    System.out.print("Codigo: ");
                    codigo = sc.nextLine();

                    System.out.println(sistema.eliminar(codigo)
                            ? "Estudiante eliminado."
                            : "No encontrado.");
                    break;

                case 7:
                    System.out.println("Hasta luego.");
                    break;

                default:
                    System.out.println("Opcion invalida.");
            }

        } while (opcion != 7);

        sc.close();
    }
}
