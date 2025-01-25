package kodlama.io.rentACar.business.requests.employee;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateUserRequest {

    @NotNull
    private Long id;
    @NotNull
    private String userName;

    @NotNull
    private String email;
    @NotNull
    private String password;
}
