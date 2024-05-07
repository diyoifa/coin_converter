import java.util.Map;

public record Moneda(Map<String, Double> conversion_rates) {
    public Double obtenerTasaDeConversion(String moneda) {
        return conversion_rates.get(moneda);
    }
}
