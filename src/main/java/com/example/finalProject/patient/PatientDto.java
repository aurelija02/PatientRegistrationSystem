package com.example.finalProject.patient;

import com.example.finalProject.allergy.AllergyDto;
import com.example.finalProject.disease.DiseaseDto;
import com.example.finalProject.visit.VisitDto;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PatientDto {

    private Long id;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date dateOfBirth;

    private String biologicalSex;

    private Long userId;

    private List<AllergyDto> allergies = new ArrayList<>();

    private List<DiseaseDto> diseases = new ArrayList<>();

    private List<VisitDto> visits = new ArrayList<>();

}
