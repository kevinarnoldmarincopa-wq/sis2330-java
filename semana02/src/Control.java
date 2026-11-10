public class Control {
    public static void main(String[] args) {
        int nota = 65;

        if (nota >= 51) {
            System.out.println("Aprobado");
        } else {
            System.out.println("Reprobado");
        }

        System.out.println("Bucle for:");
        for (int i = 1; i <= 5; i++) {
            System.out.println(i);
        }

        System.out.println("Bucle while:");
        int contador = 1;
        while (contador <= 3) {
            System.out.println(contador);
            contador++;
        }
    }
}
