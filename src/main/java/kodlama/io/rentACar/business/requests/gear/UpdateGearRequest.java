package kodlama.io.rentACar.business.requests.gear;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateGearRequest {
	@NotNull
	
	private int id;
	@NotBlank
	@NotNull
	private String Name;
	
	

}
