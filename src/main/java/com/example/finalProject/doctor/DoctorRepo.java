package com.example.finalProject.doctor;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DoctorRepo extends CrudRepository<Doctor, Long> {

//find by specialty reik

    List<Doctor> findAllBySpecialty (String specialty);
}
