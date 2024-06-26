import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaConversorMoneda {
    public ConversionMoneda conversorMoneda(String monedaLocal, String monedaConvertir, double monto){
        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/5d21b26099abaff33066a56d/pair/" + monedaLocal + "/" + monedaConvertir + "/" + monto);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();

        try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            return new Gson().fromJson(response.body(), ConversionMoneda.class);
        } catch (Exception e) {
            throw new RuntimeException("No se realizo la conversion, volver a intentarlo");
        }
    }
}
