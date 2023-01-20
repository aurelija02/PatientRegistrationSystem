package com.example.finalProject.doctor;

import com.example.finalProject.patient.PatientDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = {"http://localhost:3000","http://127.0.0.1:3002", "http://127.0.0.1:5500", "http://127.0.0.1:3000"})
@RestController
@RequestMapping("/doctor")
public class DoctorController {

    @Autowired
    DoctorService doctorService;

    @GetMapping("/{id}")
    public DoctorDto findById (@PathVariable(name = "id") Long id){
        return doctorService.findById(id);
    }
    @GetMapping("")
    public List<DoctorDto> findAllDoctors (){
        return doctorService.findAllDoctors();
    }

    @GetMapping("/find-by-specialty/{specialty}")
    public List <DoctorDto> findBySpecialty (@PathVariable String specialty){
        return doctorService.findAllBySpecialty(specialty);
    }

    @PostMapping("")
    public DoctorDto createDoctor (@Valid @RequestBody DoctorDto doctorDto) {
        return doctorService.createDoctor(doctorDto);
    }

    @PutMapping("/{id}")
    public DoctorDto updateDoctor (@Valid @RequestBody DoctorDto doctorDto, @PathVariable (name = "id") Long id){
        return doctorService.updateDoctor(doctorDto);
    }
    @DeleteMapping("{id}")
    public void deletePatient (@PathVariable (name = "id") Long id){
        doctorService.deletePatient(id);
    }
}
