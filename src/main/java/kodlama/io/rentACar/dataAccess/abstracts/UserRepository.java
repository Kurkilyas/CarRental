package kodlama.io.rentACar.dataAccess.abstracts;



import kodlama.io.rentACar.entities.concretes.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@EnableJpaRepositories
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findOneByEmailAndPassword(String email, String password);
    User findByEmail(String email);


}

