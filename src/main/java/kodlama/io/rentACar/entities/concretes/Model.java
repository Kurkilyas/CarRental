package kodlama.io.rentACar.entities.concretes;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name="models") //veri tabanında tablo oluşturur.
@Getter //değişkenlerin getter fonksiyonlarını oluşturur.
@Setter //değişkenlerin setter fonkisyonlarını oluşturur.
@AllArgsConstructor //değişkenlerin parametreli cunstructor oluşturur
@NoArgsConstructor //değişkenlerin parametresiz cunstructor oluşturur
@Entity //varlık olduğunu belirtir.
public class Model {
	
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	@Column(name="id") //veri tabanındaki kolon ismi
	private int id;
	@Column(name="name",unique = true)
	private String name;

	@ManyToOne
	@JoinColumn(name="brand_id")
	private Brand brand;
	
	@OneToMany(mappedBy="model") // buradaki model car classı içindeki private Model model 'in modelidir. 
	private List<Car> cars;     //Bir modelden bir sürü olabilir (bmw 320i , bmw 520i)
	
	

}
