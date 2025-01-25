package kodlama.io.rentACar.business.responses.carImage;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CarImageResponse {

    private Long id;
    private String imageUrl;
    private Long carId;

    // Getter ve Setter metotları

}
