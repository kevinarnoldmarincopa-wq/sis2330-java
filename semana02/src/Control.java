public class Control {
    public static void main(String[] args) {
        int nota = 65;

        if (nota >= 51) {
            System.out.println("Aprobado");
        } else {
            System.out.println("Reprobado");
        }

        System.out.println("\nSwitch:");
        int opcion = 2;

        switch (opcion) {
            case 1:
                System.out.println("Opcion 1");
                break;
            case 2:
                System.out.println("Opcion 2");
                break;
            case 3:
                System.out.println("Opcion 3");
                break;
            default:
                System.out.println("Opcion no valida");
        }

        System.out.println("\nBucle for:");
        for (int i = 1; i <= 5; i++) {
            System.out.println(i);
        }

        System.out.println("\nBucle while:");
        int contador = 1;
        while (contador <= 3) {
            System.out.println(contador);
            contador++;
        }
    }
}
