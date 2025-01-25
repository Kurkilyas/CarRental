package kodlama.io.rentACar.webApi.controllers;

import kodlama.io.rentACar.business.payment.EthereumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/payment")
public class PaymentController {
    @Autowired
    private EthereumService ethereumService;

    @PostMapping("/verify")
    public String verifyPayment(@RequestBody String transactionHash) {
        try {
            boolean isVerified = ethereumService.verifyTransaction(transactionHash);
            return isVerified ? "Payment Successful!" : "Payment Failed!";
        } catch (Exception e) {
            return "Error during verification: " + e.getMessage();
        }
    }
}