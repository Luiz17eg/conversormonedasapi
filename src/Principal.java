import java.util.InputMismatchException;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        ConsultaConversorMoneda consulta = new ConsultaConversorMoneda();
        Scanner teclado = new Scanner(System.in);
        int opcion = 0;
        String monedaLocal = "";
        String monedaConvertir = "";

        System.out.println("*************************************************");
        System.out.println("¡Bienvenido(a) al Conversor de Moneda! =]");
        System.out.println("*************************************************");

        String menu = """
                \n1) Convertir de Dólar a Peso argentino
                2) Convertir de Peso argentino a Dólar
                3) Convertir de Dólar a Real Brasileño
                4) Convertir de Real Brasileño a Dólar
                5) Convertir de Dólar a Peso colombiano
                6) Convertir de Peso colombiano a Dólar
                7) Convertir de Dólar a Soles peruano
                8) Convertir de Soles peruano a Dólar
                9) Salir
                *************************************************
                >>> Elija una opción válida (1-9):
                """;

        while (opcion != 9) {
            System.out.println(menu);
            opcion = teclado.nextInt();

            switch (opcion) {
                case 1:
                    monedaLocal = "USD";
                    monedaConvertir = "ARS";
                    realizarConversion(consulta, teclado, monedaLocal, monedaConvertir);
                    break;
                case 2:
                    monedaLocal = "ARS";
                    monedaConvertir = "USD";
                    realizarConversion(consulta, teclado, monedaLocal, monedaConvertir);
                    break;
                case 3:
                    monedaLocal = "USD";
                    monedaConvertir = "BRL";
                    realizarConversion(consulta, teclado, monedaLocal, monedaConvertir);
                    break;
                case 4:
                    monedaLocal = "BRL";
                    monedaConvertir = "USD";
                    realizarConversion(consulta, teclado, monedaLocal, monedaConvertir);
                    break;
                case 5:
                    monedaLocal = "USD";
                    monedaConvertir = "COP";
                    realizarConversion(consulta, teclado, monedaLocal, monedaConvertir);
                    break;
                case 6:
                    monedaLocal = "COP";
                    monedaConvertir = "USD";
                    realizarConversion(consulta, teclado, monedaLocal, monedaConvertir);
                    break;
                case 7:
                    monedaLocal = "USD";
                    monedaConvertir = "PEN";
                    realizarConversion(consulta, teclado, monedaLocal, monedaConvertir);
                    break;
                case 8:
                    monedaLocal = "PEN";
                    monedaConvertir = "USD";
                    realizarConversion(consulta, teclado, monedaLocal, monedaConvertir);
                    break;
                case 9:
                    System.out.println("Finalizando el programa. Muchas gracias por usar nuestros servicios");
                    break;
                default:
                    System.out.println("Opción inválida");
                    break;
            }
        }
    }
    private static void realizarConversion(ConsultaConversorMoneda consulta, Scanner teclado, String monedaLocal, String monedaConvertir) {
        System.out.println("Ingrese el valor que desea convertir:");
        if (teclado.hasNextDouble()) {
            double monto = teclado.nextDouble();
            try {
                ConversionMoneda conversionmoneda = consulta.conversorMoneda(monedaLocal, monedaConvertir, monto);
                System.out.println("El valor de " + monto + " [" + monedaLocal
                        + "] corresponde a un valor final de "
                        + conversionmoneda.conversion_result() + " [" + monedaConvertir + "]");
            } catch (RuntimeException e) {
                System.out.println("Hubo un error al realizar la conversión: " + e.getMessage());
                System.out.println("Finalizando el programa. Muchas gracias por usar nuestros servicios");
            }
        } else {
            System.out.println("Por favor ingrese un valor numérico válido.");
            teclado.next();
        }
    }
}
