package kodlama.io.rentACar.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;


import kodlama.io.rentACar.entities.concretes.Color;

public interface ColorRepository extends JpaRepository<Color, Integer>{

}
