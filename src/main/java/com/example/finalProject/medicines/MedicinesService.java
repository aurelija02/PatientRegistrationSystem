package com.example.finalProject.medicines;

import com.example.finalProject.labTests.LabTest;
import com.example.finalProject.labTests.LabTestDto;
import com.example.finalProject.labTests.LabTestMapper;
import com.example.finalProject.labTests.LabTestRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicinesService {

    @Autowired
    MedicinesMapper mapper;

    @Autowired
    MedicinesRepo repo;

    public List<MedicinesDto> findAll(){
        List <Medicines> meds = (List<Medicines>) repo.findAll();
        return mapper.fromMedicinesEntityToDtoList(meds);
    }
    public MedicinesDto findById (Long id){
        Medicines meds = repo.findById(id).orElse(null);
        return mapper.fromMedicinesEntityToDto(meds);
    }
    public MedicinesDto createMed (MedicinesDto dto){
        Medicines meds = mapper.fromMedicinesDtoToEntity(dto);
        repo.save(meds);
        return mapper.fromMedicinesEntityToDto(meds);
    }
    public MedicinesDto updateMed (MedicinesDto dto){
        Medicines meds = mapper.fromMedicinesDtoToEntity(dto);

        return mapper.fromMedicinesEntityToDto(repo.save(meds));
    }
    public void deleteMed (Long id){
        repo.deleteById(id);
    }
}
