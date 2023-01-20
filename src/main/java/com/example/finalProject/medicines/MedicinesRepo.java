package com.example.finalProject.medicines;

import com.example.finalProject.disease.Disease;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MedicinesRepo extends CrudRepository<Medicines, Long> {

    Optional<Medicines> findByMedicine (String medicineTitle);

}
