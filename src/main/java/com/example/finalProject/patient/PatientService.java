package com.example.finalProject.patient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PatientService {

    @Autowired
    PatientMapper patientMapper;

    @Autowired
    PatientRepo patientRepo;

    public PatientDto findById (Long id){
        Patient patient = patientRepo.findById(id).orElse(null);
        return patientMapper.toDto(patient);
    }
    public List<PatientDto> findAllPatients(){
        List<Patient> patients = (ArrayList<Patient>) patientRepo.findAll();
        return patientMapper.toDtoList(patients);
    }
    public PatientDto createPatient (PatientDto patientDto){
        Patient patient = patientMapper.fromDto(patientDto);
        patientRepo.save(patient);
        return patientMapper.toDto(patient);
    }
    public PatientDto updatePatient (PatientDto patientDto){
        Patient patient = patientMapper.fromDto(patientDto);

        return patientMapper.toDto( patientRepo.save(patient));
    }
    public void deletePatient (Long id){
        patientRepo.deleteById(id);
    }

}
