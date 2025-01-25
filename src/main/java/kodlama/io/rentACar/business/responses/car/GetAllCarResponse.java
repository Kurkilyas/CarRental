package kodlama.io.rentACar.business.responses.car;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllCarResponse {
	
	private int Id;
	
	private String plate;
	 
    private double dailyPrice;
	 
	private int modelYear;
  
	
	private String stateName; // müsait , kiralık , bakımda 
	
	private int km;
	
	private String dateOfAnnouncement;
	
	private String statusName;
	
	private String colorName;
	
	private String fuelName;
	
	private String gearName;
	  
	private String modelName;

	private String brandName;
}
