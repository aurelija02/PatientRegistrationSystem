package com.example.finalProject.medicines;

import com.example.finalProject.labTests.LabTestDto;
import com.example.finalProject.labTests.LabTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"http://localhost:3000","http://127.0.0.1:3002", "http://127.0.0.1:5500", "http://127.0.0.1:3000"})
@RestController
@RequestMapping("/medicines")
public class MedicinesController {

    @Autowired
    MedicinesService service;

    @GetMapping("")
    public List<MedicinesDto> findAll (){
        return service.findAll();
    }
    @GetMapping("/{id}")
    public MedicinesDto findById (@PathVariable(name = "id") Long id){
        return service.findById(id);
    }
    @PostMapping("")
    public MedicinesDto createMed (@RequestBody MedicinesDto dto) {
        return service.createMed(dto);
    }

    @PutMapping("/{id}")
    public MedicinesDto updateMed (@RequestBody MedicinesDto dto, @PathVariable (name = "id") Long id){
        return service.updateMed(dto);
    }
    @DeleteMapping("{id}")
    public void deleteMed (@PathVariable (name = "id") Long id){
        service.deleteMed(id);
    }
}
