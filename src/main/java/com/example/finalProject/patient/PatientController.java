package com.example.finalProject.patient;

import com.example.finalProject.user.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = {"http://localhost:3000","http://127.0.0.1:3002", "http://127.0.0.1:5500", "http://127.0.0.1:3000"})
@RestController
@RequestMapping("/patient")
public class PatientController {

    @Autowired
    PatientService patientService;

    @GetMapping("/{id}")
    public PatientDto findById (@PathVariable(name = "id") Long id){
        return patientService.findById(id);
    }
    @GetMapping("")
    public List<PatientDto> findAllUsers (){
        return patientService.findAllPatients();
    }

    @PostMapping("")
    public PatientDto createPatient (@Valid @RequestBody PatientDto patientDto) {
        return patientService.createPatient(patientDto);
    }

    @PutMapping("/{id}")
    public PatientDto updatePatient (@Valid @RequestBody PatientDto patientDto, @PathVariable (name = "id") Long id){
        return patientService.updatePatient(patientDto);
    }
    @DeleteMapping("{id}")
    public void deletePatient (@PathVariable (name = "id") Long id){
        patientService.deletePatient(id);
    }

}
