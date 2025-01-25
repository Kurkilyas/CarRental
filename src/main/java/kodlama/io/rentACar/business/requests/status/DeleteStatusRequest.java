package kodlama.io.rentACar.business.requests.status;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DeleteStatusRequest {
	@NotNull
	@Min(1)
	private int id;

}
