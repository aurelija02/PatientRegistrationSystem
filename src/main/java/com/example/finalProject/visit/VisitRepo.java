package com.example.finalProject.visit;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VisitRepo extends CrudRepository <Visit, Long> {

  public List<Visit> findAllByPatient_Id (Long patientId);

   public List<Visit> findAllByDoctor_Id (Long doctorId);




}
