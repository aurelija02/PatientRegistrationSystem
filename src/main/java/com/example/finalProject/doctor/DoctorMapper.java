package com.example.finalProject.doctor;

import com.example.finalProject.availableTimes.AvailableTimesMapper;
import com.example.finalProject.availableTimes.AvailableTimesService;
import com.example.finalProject.user.User;
import com.example.finalProject.visit.VisitMapper;
import com.example.finalProject.visit.VisitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DoctorMapper {

    @Autowired
    VisitService visitService;

    @Autowired
    VisitMapper visitMapper;

    @Autowired
    AvailableTimesMapper timesMapper;

    @Autowired
    AvailableTimesService timesService;

    public DoctorDto toDto (Doctor doctor){
        if (doctor == null) {
            return null;
        }

        DoctorDto dto = new DoctorDto();
        dto.setId(doctor.getId());
        dto.setSpecialty(doctor.getSpecialty());
        dto.setExperience(doctor.getExperience());
        dto.setUserId(doctor.getUser().getId());
        dto.setVisits(visitService.findAllVisitsByDoctor_Id(doctor.getId()));
        dto.setAvailableVisits(timesService.findAllDoctorsTimeBy_Id(doctor.getId()));

        return dto;
    }
    public Doctor fromDto (DoctorDto doctorDto){
        if (doctorDto == null) {
            return null;
        }

        Doctor doctor = new Doctor();
        doctor.setId(doctorDto.getId());
        doctor.setSpecialty(doctorDto.getSpecialty());
        doctor.setExperience(doctorDto.getExperience());

        User user = new User();
        user.setId(doctorDto.getUserId());
        doctor.setUser(user);
        doctor.setVisits(visitMapper.fromDtoList(doctorDto.getVisits()));
        doctor.setAvailableVisits(timesMapper.fromDtoList(doctorDto.getAvailableVisits()));

        return doctor;
    }
    public List<DoctorDto> toDtoList (List<Doctor> entities){
        List<DoctorDto> dtos = new ArrayList<>();

        for (Doctor entity : entities){
            dtos.add(toDto(entity));
        }
        return dtos;
    }
}
