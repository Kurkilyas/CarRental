package kodlama.io.rentACar.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlama.io.rentACar.entities.concretes.Model;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ModelRepository extends JpaRepository<Model ,Integer> {

    @Query("SELECT m.brand.name FROM Model m WHERE m.id = :id")
    String findBrandNameById(@Param("id") int id);

}
