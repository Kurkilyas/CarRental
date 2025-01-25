package kodlama.io.rentACar.business.responses.employee;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetByIdUserResponse {

    private String userName;


    private String email;

    private String password;
}
