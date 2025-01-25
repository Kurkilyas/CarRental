package kodlama.io.rentACar.business.concretes;

import jakarta.servlet.http.HttpSession;
import kodlama.io.rentACar.business.abstracts.UserService;

import kodlama.io.rentACar.business.requests.employee.CreateUserRequest;
import kodlama.io.rentACar.business.requests.employee.DeleteUserRequest;
import kodlama.io.rentACar.business.requests.employee.LoginDTO;
import kodlama.io.rentACar.business.requests.employee.UpdateUserRequest;

import kodlama.io.rentACar.business.responses.employee.GetAllUserResponse;
import kodlama.io.rentACar.business.responses.employee.GetByIdUserResponse;
import kodlama.io.rentACar.business.responses.employee.LoginMesage;
import kodlama.io.rentACar.core.utilities.mappers.ModelMapperService;



import kodlama.io.rentACar.dataAccess.abstracts.UserRepository;
import kodlama.io.rentACar.entities.Enums.Role;
import kodlama.io.rentACar.entities.concretes.Gear;
import kodlama.io.rentACar.entities.concretes.User;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
//bellekte "ıoc" denen bir yapı sayesinde gider bellekte onu newler ve onu çağırmak isteyen herkese onun referansını verir.
//bu sayede bellek tasarrufu sağlanmış olur.

@AllArgsConstructor
public class UserManager implements UserService {
    private final UserRepository userRepository;
    private UserRepository employeeRepository;
    private ModelMapperService modelMapperService;
    private PasswordEncoder passwordEncoder;


    @Override
    public List<GetAllUserResponse> getAll() {
        List<User> users =employeeRepository.findAll();
		/*List<GetAllBrandsResponse> brandsResponses=new ArrayList<GetAllBrandsResponse>();

		for(Brand brand:brands)
		{
			GetAllBrandsResponse brandResponse=new GetAllBrandsResponse();
			brandResponse.setId(brand.getId());
			brandResponse.setName(brand.getName());
			brandsResponses.add(brandResponse);
		}
		*/
        List<GetAllUserResponse> employeesResponseMap= users.stream()
                .map(user ->this.modelMapperService.forResponse()
                        .map(user, GetAllUserResponse.class)).collect(Collectors.toList());

        return employeesResponseMap;
    }

    @Override
    public GetByIdUserResponse getById(int id) {
        return null;
    }

    @Override
    public String add(CreateUserRequest createUserRequest) {
        User user =new User(
                createUserRequest.getUserName(),
                createUserRequest.getEmail(),
                this.passwordEncoder.encode(createUserRequest.getPassword()),
                Role.USER


        );
        userRepository.save(user);
        return user.getUserName();
    }

    @Override
    public void update(UpdateUserRequest updateUserRequest) {

    }

    @Override
    public void delete(DeleteUserRequest deleteUserRequest) {

    }

    @Override
    public LoginMesage loginUser(LoginDTO loginDTO, HttpSession session) {
        User employee = userRepository.findByEmail(loginDTO.getEmail());

        if (employee != null) {
            String password = loginDTO.getPassword();
            String encodedPassword = employee.getPassword();
            Boolean isPwdRight = passwordEncoder.matches(password, encodedPassword);

            if (isPwdRight) {
                Optional<User> validEmployee = userRepository.findOneByEmailAndPassword(loginDTO.getEmail(), encodedPassword);
                if (validEmployee.isPresent()) {
                    // Kullanıcının rolünü döndür
                    String role = employee.getRole().name(); // Rolü al ve string olarak döndür
                    session.setAttribute("userId", employee.getId());
                    return new LoginMesage("Login Success", true, role);
                } else {
                    return new LoginMesage("Login Failed", false, null);
                }
            } else {
                return new LoginMesage("Password Not Match", false, null);
            }
        } else {
            return new LoginMesage("Email Not Exists", false, null);
        }
    }


}
