package kodlama.io.rentACar.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;


import kodlama.io.rentACar.entities.concretes.Fuel;

public interface FuelRepository extends JpaRepository<Fuel, Integer> {

}
