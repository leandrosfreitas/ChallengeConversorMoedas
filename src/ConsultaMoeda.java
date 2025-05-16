import com.google.gson.Gson;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaMoeda {
    public Rates BuscaMoeda(String codigo) {
        var chave = "f2058d6608c28c253f1ef1d6"; // Substitua por sua chave válida se necessário
        URI endereco = URI.create("https://v6.exchangerate-api.com/v6/" + chave + "/latest/" + codigo);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(endereco)
                .build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(), Rates.class);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao consultar API: " + e.getMessage());
        }
    }
}
