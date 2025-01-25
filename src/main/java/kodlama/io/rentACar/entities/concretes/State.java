package kodlama.io.rentACar.entities.concretes;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name="states") //veri tabanında tablo oluşturur.
@Getter //değişkenlerin getter fonksiyonlarını oluşturur.
@Setter //değişkenlerin setter fonkisyonlarını oluşturur.
@AllArgsConstructor //değişkenlerin parametreli cunstructor oluşturur
@NoArgsConstructor //değişkenlerin parametresiz cunstructor oluşturur
@Entity //varlık olduğunu belirtir.
public class State {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	@Column(name="name",unique = true)
	private String name;
	@OneToMany(mappedBy = "state")
	private List<Car> cars;
	
	
	

}
