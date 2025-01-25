package kodlama.io.rentACar.business.responses.payment;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentRecordsResponse {
    private int id;             // Ödeme kaydının ID'si
    private String userId;    // Kullanıcının adı
    private String paymentDate; // Ödeme tarihi
    private int carId;          // Araç ID'si
    private String userMetamask;// Kullanıcının Metamask ID'si
    private double amount;      // Ödeme miktarı
}
