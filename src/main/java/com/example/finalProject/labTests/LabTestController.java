package com.example.finalProject.labTests;

import com.example.finalProject.availableTimes.AvailableTimesDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"http://localhost:3000","http://127.0.0.1:3002", "http://127.0.0.1:5500", "http://127.0.0.1:3000"})
@RestController
@RequestMapping("/labtest")
public class LabTestController {

    @Autowired
    LabTestService service;

    @GetMapping("")
    public List<LabTestDto> findAll (){
        return service.findAll();
    }
    @GetMapping("/{id}")
    public LabTestDto findById (@PathVariable(name = "id") Long id){
        return service.findById(id);
    }
    @PostMapping("")
    public LabTestDto createTest (@RequestBody LabTestDto dto) {
        return service.createTest(dto);
    }

    @PutMapping("/{id}")
    public LabTestDto updateTest (@RequestBody LabTestDto dto, @PathVariable (name = "id") Long id){
        return service.updateTest(dto);
    }
    @DeleteMapping("{id}")
    public void deleteTest (@PathVariable (name = "id") Long id){
        service.deleteTest(id);
    }



}
