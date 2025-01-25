package kodlama.io.rentACar.webApi.controllers;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Value;
import com.google.cloud.vertexai.VertexAI;
import com.google.cloud.vertexai.generativeai.ChatSession;
import com.google.cloud.vertexai.generativeai.GenerativeModel;
import com.google.cloud.vertexai.api.GenerateContentResponse;
import com.google.cloud.vertexai.generativeai.ResponseHandler;

@RestController
@CrossOrigin(origins = "http://localhost:8090")
@RequestMapping("/api/chat")
public class GeminiController {

    @Value("${google.cloud.project-id}")
    private String projectId;

    @Value("${google.cloud.location}")
    private String location;

    @Value("${google.cloud.model-name}")
    private String modelName;

    private ChatSession chatSession;

    @PostMapping("/send")
    public String sendMessage(@RequestBody String message) {
        try {
            if (chatSession == null) {
                VertexAI vertexAI = new VertexAI(projectId, location);
                GenerativeModel model = new GenerativeModel(modelName, vertexAI);
                chatSession = new ChatSession(model);
            }

            GenerateContentResponse response = chatSession.sendMessage(message);
            return ResponseHandler.getText(response);
        } catch (Exception e) {
            return "Error: " + e.getMessage();
        }
    }
}

