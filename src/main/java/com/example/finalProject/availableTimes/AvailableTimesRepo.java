package com.example.finalProject.availableTimes;

import com.example.finalProject.visit.Visit;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AvailableTimesRepo extends CrudRepository <AvailableTimes, Long> {

    public List<AvailableTimes> findAllByDoctor_Id (Long doctorId);

}
