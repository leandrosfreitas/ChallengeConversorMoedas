import java.util.Map;

/**
 * Record que representa a resposta da API com a moeda base e suas taxas
 * @param base_code Código da moeda base (ex: USD, BRL)
 * @param conversion_rates Mapa com as taxas de conversão (moeda -> valor)
 */
public record Rates(String base_code, Map<String, Double> conversion_rates) {
}
