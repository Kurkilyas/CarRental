package kodlama.io.rentACar.business.requests.employee;


import jakarta.validation.constraints.NotNull;
import kodlama.io.rentACar.entities.Enums.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateUserRequest {



    private String userName;

    @NotNull
    private String email;
    @NotNull
    private String password;

}
