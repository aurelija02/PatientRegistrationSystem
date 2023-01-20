package com.example.finalProject.labTests;

import com.example.finalProject.disease.Disease;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LabTestRepo extends CrudRepository<LabTest, Long> {

    Optional<LabTest> findByTitle (String labTitle);

}
