package com.example.finalProject.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserDto {

    private Long id;

    @NotBlank(message = "Name cannot be blank")
    private String name;

    @NotBlank (message = "Surname cannot be blank")
    private String surname;

    @NotBlank (message = "Personal code cannot be blank")
    private String personalCode;

    @Email(message = "Wrong email format")
    private String email;

    @NotBlank (message = "Password cannot be blank")
    // @Size(min = 6, max = 20)
    private String password;

    @NotBlank (message = "Please repeat the password")
    @Size(min = 6, max = 20)
    private String repeatPassword;

    //roles nededu

}
