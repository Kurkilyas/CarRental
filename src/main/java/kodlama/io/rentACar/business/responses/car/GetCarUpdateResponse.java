package kodlama.io.rentACar.business.responses.car;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetCarUpdateResponse {

    private String plate;

    private double dailyPrice;

    private int modelYear;


    private String stateId; // müsait , kiralık , bakımda

    private int km;

    private String dateOfAnnouncement;

    private String statusId;

    private String colorId;

    private String fuelId;

    private String gearId;

    private String modelId;

    private String brandId;
}
