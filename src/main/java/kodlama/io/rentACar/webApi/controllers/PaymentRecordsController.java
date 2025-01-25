package kodlama.io.rentACar.webApi.controllers;

import jakarta.persistence.Id;
import jakarta.servlet.http.HttpSession;
import kodlama.io.rentACar.business.abstracts.PaymentRecordsService;
import kodlama.io.rentACar.business.requests.payment.PaymentRecordsRequest;
import kodlama.io.rentACar.business.responses.payment.PaymentRecordsResponse;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/paymentRecords")

@AllArgsConstructor
@CrossOrigin
public class PaymentRecordsController {

    private PaymentRecordsService paymentRecordsService;


    @PostMapping("/add")
    public ResponseEntity<?> addPaymentRecord(@RequestBody PaymentRecordsRequest request, HttpSession session) {
        try {
            paymentRecordsService.add(request, session);
            return ResponseEntity.status(HttpStatus.CREATED).body("Ödeme kaydedildi.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Hata: " + e.getMessage());
        }
    }

    @GetMapping("/getAll")
    public List<PaymentRecordsResponse> getAllPaymentRecords() {
        return paymentRecordsService.getAll();
    }

    @GetMapping("/{id}")
    public PaymentRecordsResponse getPaymentRecordById(@PathVariable int id) {
        return paymentRecordsService.getById(id);
    }
}
