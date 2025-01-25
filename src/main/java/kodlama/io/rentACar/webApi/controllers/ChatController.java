/*
import kodlama.io.rentACar.business.concretes.ChatbotService;
import kodlama.io.rentACar.business.requests.chatbox.ChatRequest;
import kodlama.io.rentACar.business.responses.chatbox.ChatResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/chatbot")
public class ChatController {





    @PostMapping("/query")
    public ResponseEntity<ChatResponse> handleQuery(@RequestBody ChatRequest request) {
        String response = chatbotService.processQuery(request.getQuery());
        return ResponseEntity.ok(new ChatResponse(response));
    }
}
*/
