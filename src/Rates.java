import java.util.Map;

public record Rates(String base_code, Map<String, Double> conversion_rates) {
}
