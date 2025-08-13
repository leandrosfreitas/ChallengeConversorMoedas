// Importa a biblioteca Gson para converter JSON em objetos Java
import com.google.gson.Gson;
// Importa classes para manipulação de URLs e requisições HTTP
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

/**
 * Classe responsável por consultar a API de câmbio
 */
public class ConsultaMoeda {

    /**
     * Busca as taxas de conversão para uma moeda base
     * @param codigo Código da moeda base (ex: "USD", "BRL", "EUR")
     * @return Objeto Rates contendo as taxas de conversão
     */
    public Rates BuscaMoeda(String codigo) {
        // Chave da API (troque pela sua se necessário)
        var chave = "f2058d6608c28c253f1ef1d6"; 
        // Monta a URL para consulta
        URI endereco = URI.create("https://v6.exchangerate-api.com/v6/" + chave + "/latest/" + codigo);

        // Cria um cliente HTTP para enviar a requisição
        HttpClient client = HttpClient.newHttpClient();
        // Cria a requisição HTTP
        HttpRequest request = HttpRequest.newBuilder()
                .uri(endereco)
                .build();

        try {
            // Envia a requisição e obtém a resposta como String
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            // Converte o JSON retornado para o objeto Rates usando Gson
            return new Gson().fromJson(response.body(), Rates.class);
        } catch (Exception e) {
            // Em caso de erro, lança uma exceção
            throw new RuntimeException("Erro ao consultar API: " + e.getMessage());
        }
    }
}
