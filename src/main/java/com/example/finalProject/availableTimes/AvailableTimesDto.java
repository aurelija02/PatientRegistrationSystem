package com.example.finalProject.availableTimes;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AvailableTimesDto {

    private Long id;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm", timezone="Europe/Vilnius")
    private Date availableDate;

    private Long doctorId;

    private boolean isAvailable = true;

}
