package kodlama.io.rentACar.webApi.controllers;


import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import kodlama.io.rentACar.business.abstracts.UserService;
import kodlama.io.rentACar.business.requests.employee.CreateUserRequest;
import kodlama.io.rentACar.business.requests.employee.DeleteUserRequest;
import kodlama.io.rentACar.business.requests.employee.LoginDTO;
import kodlama.io.rentACar.business.requests.employee.UpdateUserRequest;
import kodlama.io.rentACar.business.responses.employee.GetAllUserResponse;
import kodlama.io.rentACar.business.responses.employee.GetByIdUserResponse;

import kodlama.io.rentACar.business.responses.employee.LoginMesage;
import kodlama.io.rentACar.dataAccess.abstracts.UserRepository;

import kodlama.io.rentACar.entities.concretes.User;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping
@CrossOrigin
public class EmployeeController {

    private UserService userService;


    @Autowired
    private UserRepository employeeRepository;

    @GetMapping("/employees")
    public List<User> fetchEmployees(){
        return employeeRepository.findAll();
    }

    @GetMapping()
    public List<GetAllUserResponse> getAll()
    {
        return userService.getAll();
    }


    @GetMapping("/{id}")
    public GetByIdUserResponse getById(@PathVariable int id)
    {
        return userService.getById(id);
    }






    @PostMapping("/api/employees")

    public ResponseEntity<String> add(@RequestBody CreateUserRequest createUserRequest) {
        try {
            userService.add(createUserRequest); // Kullanıcıyı ekler
            return ResponseEntity.ok("Registration Successful"); // Kayıt başarılı
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Registration Failed"); // Hata durumunda
        }
    }


    @PutMapping("/update")
    public void update(@RequestBody UpdateUserRequest updateUserRequest)
    {
        this.userService.update(updateUserRequest);
    }

    @DeleteMapping("/delete")
    public void delete(@RequestBody DeleteUserRequest deleteUserRequest)
    {
        this.userService.delete(deleteUserRequest);
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginEmployee(@RequestBody LoginDTO loginDTO, HttpSession session) {
        LoginMesage loginMesage = userService.loginUser(loginDTO,session);

        if (loginMesage.isStatus()) {
            return ResponseEntity.ok(loginMesage);
            // Başarılı login
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(loginMesage); // Hatalı giriş
        }
    }

}