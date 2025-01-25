package kodlama.io.rentACar.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import kodlama.io.rentACar.entities.concretes.Status;

import java.util.Optional;


public interface StatusRepository extends JpaRepository<Status, Integer>
{
    Optional<Status> findByName(String name); // Status ismine göre sorgulama

}
