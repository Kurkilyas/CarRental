package kodlama.io.rentACar.business.requests.fuel;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateFuelRequest {
	
	@NotNull
	@NotBlank
	private String name;
	

}
