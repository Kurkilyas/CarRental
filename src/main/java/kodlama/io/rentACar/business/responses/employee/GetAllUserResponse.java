package kodlama.io.rentACar.business.responses.employee;


import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllUserResponse {

    private long id;


    private String userName;


    private String email;

    private String password;
}
