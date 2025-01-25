package kodlama.io.rentACar.business.responses.employee;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginMesage {

    private String message;
   private boolean status;
    private String role;
}
