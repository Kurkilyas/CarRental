/*
package kodlama.io.rentACar.webApi.controllers;

import kodlama.io.rentACar.business.requests.login.LoginRequest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.RestTemplate;

@Controller
public class LoginController {

    @PostMapping("login")
    public String loginUser(@RequestBody LoginRequest loginRequest) {
        // Express uygulamasına HTTP isteği yapacak URL
        String expressApiUrl = "localhost:3000/api/login";

        // RestTemplate kullanarak HTTP isteği yapma
        RestTemplate restTemplate = new RestTemplate();

        // Headers oluşturma
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        // Request body oluşturma
        HttpEntity<LoginRequest> request = new HttpEntity<>(loginRequest, headers);

        // Express uygulamasına POST isteği yapma
        String result = restTemplate.postForObject(expressApiUrl, request, String.class);

        // Express uygulamasından alınan sonuca göre bir yönlendirme veya HTML sayfası döndürme
        // Örneğin, Express uygulamasından dönen bir başarı durumuna göre bir sayfaya yönlendirme yapabilirsiniz.
        if ("success".equals(result)) {
            return "login";
        } else {
            // Başarısız durumu ele almak
            return "index";
        }
    }
}
*/
