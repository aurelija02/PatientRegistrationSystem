package com.example.finalProject.labTests;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LabTestMapper {

    public LabTestDto fromLabTestEntityToDto (LabTest labTest){
        if (labTest == null) {
            return null;
        }
        LabTestDto dto = new LabTestDto();
        dto.setId(labTest.getId());
        dto.setTitle(labTest.getTitle());
        return dto;
    }

    public List<LabTestDto> fromLabTestEntityToDtoList (List<LabTest> labTests){
        List<LabTestDto> dtos = new ArrayList<>();

        for (LabTest labTest : labTests){
            dtos.add(fromLabTestEntityToDto(labTest));
        }
        return dtos;
    }

    public LabTest fromLabTestDtoToEntity (LabTestDto dto){
        if (dto == null) {
            return null;
        }

        LabTest labTest = new LabTest();
        labTest.setId(dto.getId());
        labTest.setTitle(dto.getTitle());

        return labTest;
    }
    public List<LabTest> fromLabTestDtoToEntityList (List <LabTestDto> dtos){
        List<LabTest> labTests = new ArrayList<>();

        for (LabTestDto dto : dtos){
            labTests.add(fromLabTestDtoToEntity(dto));
        }
        return labTests;

    }
}
