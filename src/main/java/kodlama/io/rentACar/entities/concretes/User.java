package kodlama.io.rentACar.entities.concretes;

import jakarta.persistence.*;
import kodlama.io.rentACar.entities.Enums.Role;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "Userssss")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private long id;

    @Column(name = "user_name", nullable = false)
    private String userName;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(name = "role", nullable = false)
    private Role role;



    public User(String userName, String email, String password, Role role) {
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.role = role;
    }
}
