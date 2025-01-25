package kodlama.io.rentACar.business.requests.payment;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class PaymentRecordsRequest {
    private int carId;
    private String userMetamask;
    private double amount;
    private String transactionHash;
}
