package com.example.finalProject.visit;

import com.example.finalProject.labTests.LabTest;
import com.example.finalProject.labTests.LabTestDto;
import com.example.finalProject.medicines.Medicines;
import com.example.finalProject.medicines.MedicinesDto;
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
public class VisitDto {

    private Long id;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm", timezone="Europe/Vilnius")
    private Date visitDate;

    private String summary;

    private Long patientId;

    private Long doctorId;

    private List<LabTestDto> labTests = new ArrayList<>();

    private List <MedicinesDto> medicines = new ArrayList<>();

}
