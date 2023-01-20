package com.example.finalProject.visit;

import com.example.finalProject.doctor.Doctor;
import com.example.finalProject.labTests.LabTest;
import com.example.finalProject.labTests.LabTestDto;
import com.example.finalProject.medicines.Medicines;
import com.example.finalProject.medicines.MedicinesDto;
import com.example.finalProject.patient.Patient;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class VisitMapper {

    public VisitDto toDto(Visit visit) {
        if (visit == null) {
            return null;
        }
        VisitDto dto = new VisitDto();
        dto.setId(visit.getId());
        dto.setVisitDate(visit.getVisitDate());
        dto.setSummary(visit.getSummary());
        dto.setPatientId(visit.getPatient().getId());
        dto.setDoctorId(visit.getDoctor().getId());
        dto.setLabTests(fromLabTestEntityToDtoList(visit.getLabTests()));
        dto.setMedicines(fromMedicinesEntityToDtoList(visit.getMedicines()));

        return dto;
    }

    public Visit fromDto (VisitDto dto){
        if (dto == null) {
            return null;
        }

        Visit visit = new Visit();
        visit.setId(dto.getId());
        visit.setVisitDate(dto.getVisitDate());
        visit.setSummary(dto.getSummary());

        Patient patient = new Patient();
        patient.setId(dto.getPatientId());
        visit.setPatient(patient);

        Doctor doctor = new Doctor();
        doctor.setId(dto.getDoctorId());
        visit.setDoctor(doctor);

        visit.setLabTests(fromLabTestDtoToEntityList(dto.getLabTests()));
        visit.setMedicines(fromMedicinesDtoToEntityList(dto.getMedicines()));

        return visit;
    }
    public List<VisitDto> toDtoList (List<Visit> visits){
        List<VisitDto> dtos = new ArrayList<>();

        for (Visit entity : visits){
            dtos.add(toDto(entity));
        }
        return dtos;
    }
    public List<Visit> fromDtoList (List<VisitDto> dtos){
        List <Visit> visits = new ArrayList<>();

        for (VisitDto dto : dtos){
            visits.add(fromDto(dto));
        }
        return visits;
    }

    ///labtest mappers:

    private LabTestDto fromLabTestEntityToDto (LabTest labTest){
        if (labTest == null) {
            return null;
        }
        LabTestDto dto = new LabTestDto();
        dto.setId(labTest.getId());
        dto.setTitle(labTest.getTitle());
        return dto;
    }

    private List<LabTestDto> fromLabTestEntityToDtoList (List<LabTest> labTests){
        List<LabTestDto> dtos = new ArrayList<>();

        for (LabTest labTest : labTests){
            dtos.add(fromLabTestEntityToDto(labTest));
        }
        return dtos;
    }

    private LabTest fromLabTestDtoToEntity (LabTestDto dto){
        if (dto == null) {
            return null;
        }

        LabTest labTest = new LabTest();
        labTest.setId(dto.getId());
        labTest.setTitle(dto.getTitle());

        return labTest;
    }
    private List<LabTest> fromLabTestDtoToEntityList (List <LabTestDto> dtos){
        List<LabTest> labTests = new ArrayList<>();

        for (LabTestDto dto : dtos){
            labTests.add(fromLabTestDtoToEntity(dto));
        }
        return labTests;

    }

    /// medicines mappers:
    private MedicinesDto fromMedicinesEntityToDto (Medicines medicines){
        if (medicines == null) {
            return null;
        }
        MedicinesDto dto = new MedicinesDto();
        dto.setId(medicines.getId());
        dto.setMedicine(medicines.getMedicine());
        dto.setDosage(medicines.getDosage());

        return dto;
    }

    private List<MedicinesDto> fromMedicinesEntityToDtoList (List<Medicines> medicinesList){
        List<MedicinesDto> dtos = new ArrayList<>();

        for (Medicines medicines : medicinesList){
            dtos.add(fromMedicinesEntityToDto(medicines));
        }
        return dtos;
    }

    private Medicines fromMedicinesDtoToEntity (MedicinesDto dto){
        if (dto == null) {
            return null;
        }

        Medicines medicines = new Medicines();
        medicines.setId(dto.getId());
        medicines.setMedicine(dto.getMedicine());
        medicines.setDosage(dto.getDosage());

        return medicines;
    }
    private List<Medicines> fromMedicinesDtoToEntityList (List <MedicinesDto> dtos){
        List<Medicines> medicinesList = new ArrayList<>();

        for (MedicinesDto dto : dtos){
            medicinesList.add(fromMedicinesDtoToEntity(dto));
        }
        return medicinesList;

    }



}
