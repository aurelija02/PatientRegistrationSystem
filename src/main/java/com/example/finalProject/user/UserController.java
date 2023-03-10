package com.example.finalProject.user;

import com.example.finalProject.security.service.UserDetailsImpl;
import com.example.finalProject.security.jwt.JwtUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = {"http://localhost:3000","http://127.0.0.1:3002", "http://127.0.0.1:5500", "http://127.0.0.1:3000"})
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    JwtUtils jwtUtils;

    @GetMapping("/{id}")
    public UserDto findById (@PathVariable(name = "id") Long id){
        return userService.findById(id);
    }
    @GetMapping("")
    public List<UserDto> findAllUsers (){
        return userService.getAllUsers();
    }

    @PostMapping("/signup/patient")
    public UserDto signUpP (@Valid @RequestBody UserDto userDto) throws Exception {
        return userService.createUserPatient(userDto);
    }
    @PostMapping("/signup/doctor")
    public UserDto signUpD (@Valid @RequestBody UserDto userDto) throws Exception {
        return userService.createUserDoctor(userDto);
    }

    @PostMapping ("/login")
    public ResponseEntity<?> login (@Valid @RequestBody LoginDto loginDto){
        Authentication authentication = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(loginDto.getEmail(), loginDto.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();

        String jwtToken = jwtUtils.generateJwtToken(userDetails);

        UserDto userDto = new UserDto();
        userDto.setId(userDetails.getId());

        return ResponseEntity.ok()
                .header(HttpHeaders.AUTHORIZATION, jwtToken)
                .header("Access-Control-Expose-Headers", "Authorization")
                .body(userDto);
    }

    @PutMapping("/patient/{id}")
    public UserDto updateUserP (@Valid @RequestBody UserDto userDto, @PathVariable (name = "id") Long id){
        return userService.updateUserPatient(userDto);
    }
    @PutMapping("/doctor/{id}")
    public UserDto updateUserD (@Valid @RequestBody UserDto userDto, @PathVariable (name = "id") Long id){
        return userService.updateUserDoctor(userDto);
    }
    @DeleteMapping("{id}")
    public void deleteUser (@PathVariable (name = "id") Long id){
        userService.deleteUser(id);
    }

}
