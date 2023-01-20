package com.example.finalProject.visit;

import com.example.finalProject.patient.Patient;
import com.example.finalProject.patient.PatientDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class VisitService {

    @Autowired
    VisitRepo visitRepo;

    @Autowired
    VisitMapper visitMapper;

    public List<VisitDto> findAllVisitsByPatient_Id (Long patentId){
        List <Visit> visits = visitRepo.findAllByPatient_Id(patentId);
        return visitMapper.toDtoList(visits);
    }
    public List<VisitDto> findAllVisitsByDoctor_Id (Long doctorId){
        List <Visit> visits = visitRepo.findAllByDoctor_Id(doctorId);
        return visitMapper.toDtoList(visits);
    }
    public VisitDto findById (Long id){
        Visit visit = visitRepo.findById(id).orElse(null);
        return visitMapper.toDto(visit);
    }
    public List<VisitDto> findAllVisits(){
        List<Visit> visits = (ArrayList<Visit>) visitRepo.findAll();
        return visitMapper.toDtoList(visits);
    }
    public VisitDto createVisit (VisitDto visitDto){
        Visit visit = visitMapper.fromDto(visitDto);
        visitRepo.save(visit);
        return visitMapper.toDto(visit);
    }
    public VisitDto updateVisit (VisitDto visitDto){
        Visit visit = visitMapper.fromDto(visitDto);

        return visitMapper.toDto(visitRepo.save(visit));
    }
    public void deleteVisit (Long id){
        visitRepo.deleteById(id);
    }



}
