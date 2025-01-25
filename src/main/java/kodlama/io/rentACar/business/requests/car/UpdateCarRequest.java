package kodlama.io.rentACar.business.requests.car;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateCarRequest {
	
	@NotNull
	private int Id;
	@NotNull 
	@NotBlank
	private String plate;
	@NotNull  
    private double dailyPrice;
	@NotNull  
	private int modelYear;
	@NotNull  
	
	private int stateId; // müsait , kiralık , bakımda 
	@NotNull 

	private int km;
	@NotNull 
	@NotBlank
	private String dateOfAnnouncement;
	@NotNull 
	@NotBlank
	private String statusId;
	@NotNull 
	
	private int colorId;
	@NotNull 
	
	private String fuelId;
	@NotNull 
	
	private int gearId;
	@NotNull  
	private int modelId;
}