package kodlama.io.rentACar.business.requests.brand;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateBrandRequest {
	@NotNull  
	private int id;
	@NotNull  
	@NotBlank
	private String name;

}
