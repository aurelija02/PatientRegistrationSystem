package com.example.finalProject.user;

import com.example.finalProject.role.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "user_table2")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column (name = "name")
    @NotBlank(message = "Name cannot be blank")
    private String name;

    @Column (name = "surname")
    @NotBlank (message = "Surname cannot be blank")
    private String surname;

    @Column (name = "personal_code")
    @NotBlank (message = "Personal code cannot be blank")
    private String personalCode;

    @Column (name = "email")
    @Email(message = "Wrong email format")
    @NotBlank (message = "Email cannot be blank")
    private String email;

    @NotBlank (message = "Password cannot be blank")
    // @Size(min = 6, max = 20)
    private String password;

    @ManyToMany (fetch = FetchType.LAZY)
    @JoinTable(name = "user_roles2",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private List<Role> roles = new ArrayList<>();
}
