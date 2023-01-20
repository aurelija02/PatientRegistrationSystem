package com.example.finalProject.medicines;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MedicinesMapper {

    public MedicinesDto fromMedicinesEntityToDto (Medicines medicines){
        if (medicines == null) {
            return null;
        }
        MedicinesDto dto = new MedicinesDto();
        dto.setId(medicines.getId());
        dto.setMedicine(medicines.getMedicine());
        dto.setDosage(medicines.getDosage());

        return dto;
    }

    public List<MedicinesDto> fromMedicinesEntityToDtoList (List<Medicines> medicinesList){
        List<MedicinesDto> dtos = new ArrayList<>();

        for (Medicines medicines : medicinesList){
            dtos.add(fromMedicinesEntityToDto(medicines));
        }
        return dtos;
    }

    public Medicines fromMedicinesDtoToEntity (MedicinesDto dto){
        if (dto == null) {
            return null;
        }

        Medicines medicines = new Medicines();
        medicines.setId(dto.getId());
        medicines.setMedicine(dto.getMedicine());
        medicines.setDosage(dto.getDosage());

        return medicines;
    }
    public List<Medicines> fromMedicinesDtoToEntityList (List <MedicinesDto> dtos){
        List<Medicines> medicinesList = new ArrayList<>();

        for (MedicinesDto dto : dtos){
            medicinesList.add(fromMedicinesDtoToEntity(dto));
        }
        return medicinesList;

    }
}
