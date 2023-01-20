package com.example.finalProject.user;

import com.example.finalProject.role.Role;
import com.example.finalProject.role.RoleRepo;
import com.example.finalProject.role.RolesEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserMapper {

    @Autowired
    RoleRepo roleRepo;

    @Autowired
    PasswordEncoder passwordEncoder;

    public UserDto toDto (User user){
        if (user == null) {
            return null;
        }

        UserDto dto = new UserDto();
        dto.setId(user.getId());
        dto.setName(user.getName());
        dto.setSurname(user.getSurname());
        dto.setPersonalCode(user.getPersonalCode());
        dto.setEmail(user.getEmail());
        dto.setPassword("Restricted");
        dto.setRepeatPassword("Restricted");

        return dto;
    }

    public User fromDtoPatient (UserDto userDto){
        if (userDto == null) {
            return null;
        }

        User user = new User();
        user.setId(userDto.getId());
        user.setName(userDto.getName());
        user.setSurname(userDto.getSurname());
        user.setPersonalCode(userDto.getPersonalCode());
        user.setEmail(userDto.getEmail());
       // user.setPassword(userDto.getPassword());
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
//
        Role userRole = roleRepo.findByRole(RolesEnum.ROLE_PATIENT).orElseThrow();
        List<Role> userRoles = new ArrayList<>();
        userRoles.add(userRole);
        user.setRoles(userRoles);

        return user;
    }

    public User fromDtoDoctor (UserDto userDto){
        if (userDto == null) {
            return null;
        }

        User user = new User();
        user.setId(userDto.getId());
        user.setName(userDto.getName());
        user.setSurname(userDto.getSurname());
        user.setPersonalCode(userDto.getPersonalCode());
        user.setEmail(userDto.getEmail());
        //user.setPassword(userDto.getPassword());
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
//
        Role userRole = roleRepo.findByRole(RolesEnum.ROLE_DOCTOR).orElseThrow();
        List<Role> userRoles = new ArrayList<>();
        userRoles.add(userRole);
        user.setRoles(userRoles);

        return user;
    }
    public List<UserDto> toDtoList(List<User> entities){
        List<UserDto> dtos = new ArrayList<>();

        for (User entity : entities){
            dtos.add(toDto(entity));
        }
        return dtos;
    }

}
