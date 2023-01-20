package com.example.finalProject.availableTimes;

import com.example.finalProject.visit.Visit;
import com.example.finalProject.visit.VisitDto;
import com.example.finalProject.visit.VisitMapper;
import com.example.finalProject.visit.VisitRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AvailableTimesService {

    @Autowired
    AvailableTimesRepo availableTimesRepo;

    @Autowired
    AvailableTimesMapper availableTimesMapper;

    public List<AvailableTimesDto> findAllDoctorsTimeBy_Id (Long doctorId){
        List <AvailableTimes> times = availableTimesRepo.findAllByDoctor_Id(doctorId);
        return availableTimesMapper.toDtoList(times);
    }
    public AvailableTimesDto findById (Long id){
        AvailableTimes time = availableTimesRepo.findById(id).orElse(null);
        return availableTimesMapper.toDto(time);
    }
    public List<AvailableTimesDto> findAll(){
        List <AvailableTimes> times = (List<AvailableTimes>) availableTimesRepo.findAll();
        return availableTimesMapper.toDtoList(times);
    }

    public AvailableTimesDto createTime (AvailableTimesDto dto){
        AvailableTimes time = availableTimesMapper.fromDto(dto);
        availableTimesRepo.save(time);
        return availableTimesMapper.toDto(time);
    }
    public AvailableTimesDto updateTime (AvailableTimesDto dto){
        AvailableTimes time = availableTimesMapper.fromDto(dto);

        return availableTimesMapper.toDto(availableTimesRepo.save(time));
    }
    public void deleteTime (Long id){
        availableTimesRepo.deleteById(id);
    }


}
