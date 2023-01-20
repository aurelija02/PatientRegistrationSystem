package com.example.finalProject.availableTimes;

import com.example.finalProject.doctor.Doctor;
import com.example.finalProject.patient.Patient;
import com.example.finalProject.visit.Visit;
import com.example.finalProject.visit.VisitDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AvailableTimesMapper {

    public AvailableTimesDto toDto(AvailableTimes time) {
        if (time == null) {
            return null;
        }
        AvailableTimesDto dto = new AvailableTimesDto();
        dto.setId(time.getId());
        dto.setAvailableDate(time.getAvailableDate());
        dto.setAvailable(time.isAvailable());
        dto.setDoctorId(time.getDoctor().getId());

        return dto;
    }

    public AvailableTimes fromDto (AvailableTimesDto dto){
        if (dto == null) {
            return null;
        }

        AvailableTimes time = new AvailableTimes();
        time.setId(dto.getId());
        time.setAvailableDate(dto.getAvailableDate());
        time.setAvailable(dto.isAvailable());

        Doctor doctor = new Doctor();
        doctor.setId(dto.getDoctorId());
        time.setDoctor(doctor);

        return time;
    }

    public List<AvailableTimesDto> toDtoList (List<AvailableTimes> times){
        List<AvailableTimesDto> dtos = new ArrayList<>();

        for (AvailableTimes entity : times){
            dtos.add(toDto(entity));
        }
        return dtos;
    }

    public List<AvailableTimes> fromDtoList (List<AvailableTimesDto> dtos){
        List <AvailableTimes> times = new ArrayList<>();

        for (AvailableTimesDto dto : dtos){
            times.add(fromDto(dto));
        }
        return times;
    }
}
