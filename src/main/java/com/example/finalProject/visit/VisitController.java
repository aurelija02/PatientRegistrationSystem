package com.example.finalProject.visit;

import com.example.finalProject.patient.PatientDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = {"http://localhost:3000","http://127.0.0.1:3002", "http://127.0.0.1:5500", "http://127.0.0.1:3000"})
@RestController
@RequestMapping("/visit")
public class VisitController {

    @Autowired
    VisitService visitService;

    @GetMapping("/{id}")
    public VisitDto findById (@PathVariable(name = "id") Long id){
        return visitService.findById(id);
    }
    @GetMapping("")
    public List<VisitDto> findAllVisits (){
        return visitService.findAllVisits();
    }

    @GetMapping("/all-visits-by-patient/{id}")
    public List<VisitDto> findAllVisitsByPatientId (@PathVariable(name = "id") Long id){
        return visitService.findAllVisitsByPatient_Id(id);
    }
    @GetMapping("/all-visits-by-doctor/{id}")
    public List<VisitDto> findAllVisitsByDoctorId (@PathVariable(name = "id") Long id){
        return visitService.findAllVisitsByDoctor_Id(id);
    }


    @PostMapping("")
    public VisitDto createVisit (@Valid @RequestBody VisitDto visitDto) {
        return visitService.createVisit(visitDto);
    }

    @PutMapping("/{id}")
    public VisitDto updateVisit (@Valid @RequestBody VisitDto visitDto, @PathVariable (name = "id") Long id){
        return visitService.updateVisit(visitDto);
    }
    @DeleteMapping("{id}")
    public void deleteVisit (@PathVariable (name = "id") Long id){
        visitService.deleteVisit(id);
    }


}
