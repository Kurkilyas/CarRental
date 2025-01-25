package kodlama.io.rentACar.business.abstracts;




import jakarta.servlet.http.HttpSession;
import kodlama.io.rentACar.business.requests.employee.CreateUserRequest;
import kodlama.io.rentACar.business.requests.employee.DeleteUserRequest;
import kodlama.io.rentACar.business.requests.employee.LoginDTO;
import kodlama.io.rentACar.business.requests.employee.UpdateUserRequest;


import kodlama.io.rentACar.business.responses.employee.GetAllUserResponse;
import kodlama.io.rentACar.business.responses.employee.GetByIdUserResponse;
import kodlama.io.rentACar.business.responses.employee.LoginMesage;

import java.util.List;


public interface UserService {


    List<GetAllUserResponse> getAll();
    GetByIdUserResponse getById(int id);

    String add(CreateUserRequest createUserRequest);
    void update(UpdateUserRequest updateUserRequest);
    void delete(DeleteUserRequest deleteUserRequest);


    LoginMesage loginUser(LoginDTO loginDTO, HttpSession session);
}
