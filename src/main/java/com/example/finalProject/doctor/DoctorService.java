package com.example.finalProject.doctor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DoctorService {

    @Autowired
    DoctorMapper doctorMapper;

    @Autowired
    DoctorRepo doctorRepo;

    public DoctorDto findById (Long id){
        Doctor doctor = doctorRepo.findById(id).orElse(null);
        return doctorMapper.toDto(doctor);
    }
    public List<DoctorDto> findAllDoctors(){
        List<Doctor> doctors = (ArrayList<Doctor>) doctorRepo.findAll();
        return doctorMapper.toDtoList(doctors);
    }
    public List<DoctorDto> findAllBySpecialty (String specialty){
        List<Doctor> doctors = doctorRepo.findAllBySpecialty(specialty);
        return doctorMapper.toDtoList(doctors);
    }
    public DoctorDto createDoctor (DoctorDto doctorDto){
        Doctor doctor = doctorMapper.fromDto(doctorDto);
        doctorRepo.save(doctor);
        return doctorMapper.toDto(doctor);
    }
    public DoctorDto updateDoctor (DoctorDto doctorDto){
        Doctor doctor = doctorMapper.fromDto(doctorDto);

        return doctorMapper.toDto( doctorRepo.save(doctor));
    }
    public void deletePatient (Long id){
        doctorRepo.deleteById(id);
    }
}
