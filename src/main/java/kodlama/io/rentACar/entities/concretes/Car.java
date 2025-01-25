package kodlama.io.rentACar.entities.concretes;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Table(name="cars",
indexes = {
		@Index(name = "idx_plate", columnList = "plate", unique = true),
		@Index(name = "idx_km", columnList = "km"),
		@Index(name = "idx_model_id", columnList = "model_id")
}
)
//veri tabanında tablo oluşturur.
@Getter //değişkenlerin getter fonksiyonlarını oluşturur.
@Setter //değişkenlerin setter fonkisyonlarını oluşturur.
@AllArgsConstructor //değişkenlerin parametreli cunstructor oluşturur
@NoArgsConstructor //değişkenlerin parametresiz cunstructor oluşturur
@Entity //varlık olduğunu belirtir.


public class Car {
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	@Column(name="id") //veri tabanındaki kolon ismi
	private int id;
	
	@Column(name="plate",unique = true)
	@Size(min = 3, max = 20, message = "Alan 3 ila 20 karakter arasında olmalıdır.")
	private String plate;
	
	@Column(name="dailyPrice")
	private double dailyPrice;
	
	@Column(name ="modelYear")
	private int modelYear;
	

	
	@Column(name="km")
	private int km;
	
	@Column(name="dateOfAnnouncement")
	private String dateOfAnnouncement; 
	
	  //ayrı tablo
	
	
	@ManyToOne
	@JoinColumn(name="model_id")
	private Model model;
	@ManyToOne
	@JoinColumn(name = "colorId")
	private Color color;
	@ManyToOne
	@JoinColumn(name="stateId")
	private State state;
	@ManyToOne 
	@JoinColumn(name = "fuelId")
	private Fuel fuel;
	@ManyToOne 
	@JoinColumn(name = "gearId")
	private Gear gear;
	@ManyToOne 
	@JoinColumn(name = "statusId")
	private Status status;

	@Column(name = "carPhoto")
	@Lob
	private byte[] carPhoto;










}