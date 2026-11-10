public class Metodos {

    static double promedio(double a, double b) {
        return (a + b) / 2;
    }

    static void imprimirLinea() {
        System.out.println("----------------");
    }

    public static void main(String[] args) {
        double resultado = promedio(80, 90);

        System.out.println("Promedio: " + resultado);

        imprimirLinea();
    }
}
