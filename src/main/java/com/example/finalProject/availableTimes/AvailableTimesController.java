package com.example.finalProject.availableTimes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"http://localhost:3000","http://127.0.0.1:3002", "http://127.0.0.1:5500", "http://127.0.0.1:3000"})
@RestController
@RequestMapping("/available/times")
public class AvailableTimesController {

    @Autowired
    AvailableTimesService service;

    @GetMapping("/{id}")
    public AvailableTimesDto findById (@PathVariable(name = "id") Long id){
        return service.findById(id);
    }
    @GetMapping("doc/times/{id}")
    public List<AvailableTimesDto> findDoctorTimes (@PathVariable(name = "id") Long id){
        return service.findAllDoctorsTimeBy_Id(id);
    }

    @GetMapping("")
    public List<AvailableTimesDto> findAllById (){
        return service.findAll();
    }

    @PostMapping("")
    public AvailableTimesDto createTime (@RequestBody AvailableTimesDto dto) {
        return service.createTime(dto);
    }

    @PutMapping("/{id}")
    public AvailableTimesDto updateTime (@RequestBody AvailableTimesDto dto, @PathVariable (name = "id") Long id){
        return service.updateTime(dto);
    }
    @DeleteMapping("{id}")
    public void deleteTime (@PathVariable (name = "id") Long id){
        service.deleteTime(id);
    }



}
