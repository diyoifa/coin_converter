import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner lectura = new Scanner(System.in);
        ConsultarMoneda consulta = new ConsultarMoneda();
        int opcion;
        System.out.println("************************************************************************");
        System.out.println("Sea bienvenido al Conversor de Moneda =]\n");
        while(true){
            System.out.println("1) Dolar =>> Peso argentino");
            System.out.println("2) Peso argentino =>> Dolar ");
            System.out.println("3) Dolar =>> Real brasileño");
            System.out.println("4) Real brasileño =>> Dolar ");
            System.out.println("5) Dolar =>> Peso colombiano");
            System.out.println("6) Peso colombiano =>> Dolar ");
            System.out.println("7) Dolar =>> Peso Mexicano");
            System.out.println("8) Peso Mexicano =>> Dolar ");
            System.out.println("9) SALIR");
            System.out.println("Elija una opcion valida.");
            System.out.println("********************************");
            opcion = lectura.nextInt();
            switch (opcion) {
                case 1, 2, 3, 4, 5, 6, 7, 8:
                    try {
                        String monedaOrigen = obtenerMonedaOrigen(opcion);
                        String monedaDestino = obtenerMonedaDestino(opcion);
                        Moneda moneda = consulta.buscaMoneda(monedaOrigen);
                        System.out.println("Ingrese el valor de "+monedaOrigen+" que deseas convertir a "+monedaDestino);
                        double cantidad = lectura.nextDouble();
                        System.out.println("CONVERSION: ");
                        System.out.println("El valor " + cantidad + " [" + monedaOrigen + "] corresponde al valor final de =>>> " +
                                (moneda.obtenerTasaDeConversion(monedaDestino) * cantidad) + "[" + monedaDestino + "]\n");
                    } catch (RuntimeException e) {
                        System.out.println(e.getMessage());
                        System.out.println("Finalizando la aplicacion.");
                        System.exit(0);
                    }
                    break;
                case 9:
                    lectura.close();
                    System.exit(0);
                default:
                    System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
            }
        }
    }
    private static String obtenerMonedaOrigen(int opcion) {
        switch (opcion) {
            case 1,3,5,7: return "USD";
            case 2: return "ARS";
            case 4: return "BRL";
            case 6: return "COP";
            case 8: return "MXN";

            default:
                throw new IllegalArgumentException("Opción de conversión no válida.");
        }
    }
    private static String obtenerMonedaDestino(int opcion) {
        switch (opcion) {
            case 2,4,6,8: return "USD";
            case 1: return "ARS";
            case 3: return "BRL";
            case 5: return "COP";
            case 7: return "MXN";
            default:
                throw new IllegalArgumentException("Opción de conversión no válida.");
        }
    }
}
