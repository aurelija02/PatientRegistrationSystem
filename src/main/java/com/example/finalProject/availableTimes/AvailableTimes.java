package com.example.finalProject.availableTimes;

import com.example.finalProject.doctor.Doctor;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "available_times")
public class AvailableTimes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "available_date")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm", timezone="Europe/Vilnius")
    private Date availableDate;

    @Column(name = "is_available")
    private boolean isAvailable;

    @ManyToOne
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;
}
