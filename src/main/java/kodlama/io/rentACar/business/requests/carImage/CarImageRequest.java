package kodlama.io.rentACar.business.requests.carImage;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CarImageRequest {

    private Long carId;
    private MultipartFile imageFile;



}

