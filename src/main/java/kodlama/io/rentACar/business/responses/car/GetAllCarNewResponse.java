package kodlama.io.rentACar.business.responses.car;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllCarNewResponse {
   private  String brandName;
    private String modelName;
    private String colorName;
    private double dailyPrice;
    private String gearName;
 private String carPhotoBase64;

    private int Id;

}
