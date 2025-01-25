package kodlama.io.rentACar.entities.concretes;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "paymentRecords")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentRecords {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;


    @Column(name = "user_id", nullable = false) // User ile ilişki
    private long userId;

    @Column(name = "date")
    private String paymentDate;

    @Column(name = "car_id")
    private int carId;

    @Column(name = "metamask_id")
    private String userMetamask;

    @Column(name = "amount")
    private double amount;
}
