/*

package kodlama.io.rentACar.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import com.google.cloud.ai.generativelanguage.v1.GenerativeServiceClient;
import com.google.cloud.ai.generativelanguage.v1.GenerativeServiceSettings;
import java.io.IOException;

@Configuration
public class GeminiConfig {

    @Value("${gemini.api.key}")
    private String apiKey;

    @Bean
    public GenerativeServiceClient generativeServiceClient() throws IOException {
        GenerativeServiceSettings settings = GenerativeServiceSettings.newBuilder()
                .setEndpoint("generativelanguage.googleapis.com:443")
                .build();

        return GenerativeServiceClient.create(settings);
    }
}

*/
