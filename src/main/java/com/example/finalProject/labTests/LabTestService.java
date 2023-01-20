package com.example.finalProject.labTests;

import com.example.finalProject.availableTimes.AvailableTimes;
import com.example.finalProject.availableTimes.AvailableTimesDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LabTestService {

    @Autowired
    LabTestMapper mapper;

    @Autowired
    LabTestRepo repo;

    public List<LabTestDto> findAll(){
        List <LabTest> tests = (List<LabTest>) repo.findAll();
        return mapper.fromLabTestEntityToDtoList(tests);
    }
    public LabTestDto findById (Long id){
        LabTest test = repo.findById(id).orElse(null);
        return mapper.fromLabTestEntityToDto(test);
    }
    public LabTestDto createTest (LabTestDto dto){
        LabTest test = mapper.fromLabTestDtoToEntity(dto);
        repo.save(test);
        return mapper.fromLabTestEntityToDto(test);
    }
    public LabTestDto updateTest (LabTestDto dto){
        LabTest test = mapper.fromLabTestDtoToEntity(dto);

        return mapper.fromLabTestEntityToDto(repo.save(test));
    }
    public void deleteTest (Long id){
        repo.deleteById(id);
    }


}
