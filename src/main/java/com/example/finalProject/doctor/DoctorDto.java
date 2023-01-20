package com.example.finalProject.doctor;

import com.example.finalProject.availableTimes.AvailableTimes;
import com.example.finalProject.availableTimes.AvailableTimesDto;
import com.example.finalProject.visit.VisitDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class DoctorDto {

    private Long id;

    private String specialty;

    private Integer experience;

    private Long userId;

    private List<VisitDto> visits = new ArrayList<>();

    private List<AvailableTimesDto> availableVisits = new ArrayList<>();

}
