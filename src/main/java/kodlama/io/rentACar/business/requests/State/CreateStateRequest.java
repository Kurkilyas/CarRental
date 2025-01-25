package kodlama.io.rentACar.business.requests.State;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateStateRequest {
	
	@NotNull
	@NotBlank
	private String name;
	

}