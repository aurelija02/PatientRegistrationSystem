package com.example.finalProject.patient;

import com.example.finalProject.allergy.Allergy;
import com.example.finalProject.allergy.AllergyDto;
import com.example.finalProject.disease.Disease;
import com.example.finalProject.disease.DiseaseDto;
import com.example.finalProject.user.User;
import com.example.finalProject.user.UserDto;
import com.example.finalProject.user.UserMapper;
import com.example.finalProject.visit.Visit;
import com.example.finalProject.visit.VisitDto;
import com.example.finalProject.visit.VisitMapper;
import com.example.finalProject.visit.VisitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PatientMapper {

    @Autowired
    VisitService visitService;

    @Autowired
    VisitMapper visitMapper;

    public PatientDto toDto (Patient patient){
        if (patient == null) {
            return null;
        }

        PatientDto dto = new PatientDto();
        dto.setId(patient.getId());
        dto.setDateOfBirth(patient.getDateOfBirth());
        dto.setBiologicalSex(patient.getBiologicalSex());
        dto.setUserId(patient.getUser().getId());
        dto.setAllergies(fromAllergyEntityToDtoList(patient.getAllergies()));
        dto.setDiseases(fromDiseaseEntityToDtoList(patient.getDiseases()));
        dto.setVisits(visitService.findAllVisitsByPatient_Id(patient.getId()));

        return dto;
    }

    public Patient fromDto (PatientDto patientDto){
        if (patientDto == null) {
            return null;
        }

        Patient patient = new Patient();
        patient.setId(patientDto.getId());
        patient.setDateOfBirth(patientDto.getDateOfBirth());
        patient.setBiologicalSex(patientDto.getBiologicalSex());

        User user = new User();
        user.setId(patientDto.getUserId());
        patient.setUser(user);
        patient.setAllergies(fromAllergyDtoToEntityList(patientDto.getAllergies()));
        patient.setDiseases(fromDiseaseDtoToEntityList(patientDto.getDiseases()));
        patient.setVisits(visitMapper.fromDtoList(patientDto.getVisits()));

        return patient;
    }
    public List<PatientDto> toDtoList (List<Patient> entities){
        List<PatientDto> dtos = new ArrayList<>();

        for (Patient entity : entities){
            dtos.add(toDto(entity));
        }
        return dtos;
    }

//////// Allergy list mappers:
    private AllergyDto fromAllergyEntityToDto (Allergy allergy){
        if (allergy == null) {
            return null;
        }
        AllergyDto dto = new AllergyDto();
        dto.setId(allergy.getId());
        dto.setTitle(allergy.getTitle());

        return dto;
    }

    private List <AllergyDto> fromAllergyEntityToDtoList (List<Allergy> allergies){
        List<AllergyDto> dtos = new ArrayList<>();

        for (Allergy allergy : allergies){
            dtos.add(fromAllergyEntityToDto(allergy));
        }
        return dtos;
    }

    private Allergy fromAllergyDtoToEntity (AllergyDto dto){
        if (dto == null) {
            return null;
        }

        Allergy allergy = new Allergy();
        allergy.setId(dto.getId());
        allergy.setTitle(dto.getTitle());

        return allergy;
    }
    private List<Allergy> fromAllergyDtoToEntityList (List <AllergyDto> dtos){
        List<Allergy> allergies = new ArrayList<>();

        for (AllergyDto dto : dtos){
            allergies.add(fromAllergyDtoToEntity(dto));
        }
        return allergies;

    }
//////// Diseases list mappers:
    private DiseaseDto fromDiseaseEntityToDto (Disease disease){
        if (disease == null) {
            return null;
        }
        DiseaseDto dto = new DiseaseDto();
        dto.setId(disease.getId());
        dto.setTitle(disease.getTitle());

        return dto;
    }
    private List <DiseaseDto> fromDiseaseEntityToDtoList (List<Disease> diseases){
        List<DiseaseDto> dtos = new ArrayList<>();

        for (Disease disease : diseases){
            dtos.add(fromDiseaseEntityToDto(disease));
        }
        return dtos;
    }

    private Disease fromDiseaseDtoToEntity (DiseaseDto dto){
        if (dto == null) {
            return null;
        }

        Disease disease = new Disease();
        disease.setId(dto.getId());
        disease.setTitle(dto.getTitle());

        return disease;
    }
    private List<Disease> fromDiseaseDtoToEntityList (List <DiseaseDto> dtos){
        List<Disease> diseases = new ArrayList<>();

        for (DiseaseDto dto : dtos){
            diseases.add(fromDiseaseDtoToEntity(dto));
        }
        return diseases;

    }

    ////////////////visits mappers:

//    private VisitDto fromVisitEntityToDto (Visit visit){
//        if (visit == null) {
//            return null;
//        }
//        VisitDto dto = new VisitDto();
//        dto.setId(visit.getId());
//
//
//        return dto;
//    }
//    private List <DiseaseDto> fromDiseaseEntityToDtoList (List<Disease> diseases){
//        List<DiseaseDto> dtos = new ArrayList<>();
//
//        for (Disease disease : diseases){
//            dtos.add(fromDiseaseEntityToDto(disease));
//        }
//        return dtos;
//    }

}
