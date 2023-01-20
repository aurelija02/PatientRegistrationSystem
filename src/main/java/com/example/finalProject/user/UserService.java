package com.example.finalProject.user;

import com.example.finalProject.role.RoleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserMapper mapper;

    @Autowired
    UserRepo repo;

    @Autowired
    RoleRepo roleRepo;

    @Autowired
    PasswordEncoder passwordEncoder;

    public UserDto findById (Long id){
        User user = repo.findById(id).orElse(null);
        return mapper.toDto(user);
    }
    public List<UserDto> getAllUsers (){
        List<User> users = (List<User>) repo.findAll();
        return mapper.toDtoList(users);
    }
    public UserDto createUserPatient (UserDto userDto) throws Exception {
        if (repo.findByEmail(userDto.getEmail()).isPresent()){
            throw new Exception("Email "+userDto.getEmail()+" is already in use");
        }
        if (!userDto.getPassword().equals(userDto.getRepeatPassword())){
            throw new Exception("Passwords do not match");
        }
        User user = mapper.fromDtoPatient(userDto);
        repo.save(user);
        return mapper.toDto(user);
    }
    public UserDto createUserDoctor (UserDto userDto) throws Exception {
        if (repo.findByEmail(userDto.getEmail()).isPresent()){
            throw new Exception("Email "+userDto.getEmail()+" is already in use");
        }
        if (!userDto.getPassword().equals(userDto.getRepeatPassword())){
            throw new Exception("Passwords do not match");
        }
        User user = mapper.fromDtoDoctor(userDto);
        repo.save(user);
        return mapper.toDto(user);
    }
//    public UserDto loginUser (UserDto userDto){
//        if (repo.findByEmail(userDto.getEmail()).isPresent()){
//            throw new Exception("Email "+userDto.getEmail()+" is already in use");
//        }
  //  }
    public UserDto updateUserPatient (UserDto userDto){
        User user = mapper.fromDtoPatient(userDto);

        return mapper.toDto(repo.save(user));
    }
    public UserDto updateUserDoctor (UserDto userDto){
        User user = mapper.fromDtoDoctor(userDto);

        return mapper.toDto(repo.save(user));
    }
    public void deleteUser (Long id){
        repo.deleteById(id);
    }
}
