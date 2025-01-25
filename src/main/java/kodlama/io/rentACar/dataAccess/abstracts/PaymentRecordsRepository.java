package kodlama.io.rentACar.dataAccess.abstracts;

import kodlama.io.rentACar.entities.concretes.PaymentRecords;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRecordsRepository extends JpaRepository<PaymentRecords, Integer> {

}
