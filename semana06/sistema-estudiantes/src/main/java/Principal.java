import modelo.Estudiante;
import servicio.SistemaEstudiantes;

public class Principal {
    public static void main(String[] args) {
        SistemaEstudiantes sistema = new SistemaEstudiantes();

        sistema.registrar(new Estudiante("A01", "Ana", 92.5));
        sistema.registrar(new Estudiante("A02", "Luis", 85.0));
        sistema.registrar(new Estudiante("A03", "Maria", 97.0));

        System.out.println("=== RANKING DE ESTUDIANTES ===");
        sistema.listarRanking().forEach(System.out::println);
    }
}
