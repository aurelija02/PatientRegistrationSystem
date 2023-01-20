package com.example.finalProject.visit;

import com.example.finalProject.disease.Disease;
import com.example.finalProject.doctor.Doctor;
import com.example.finalProject.labTests.LabTest;
import com.example.finalProject.medicines.Medicines;
import com.example.finalProject.patient.Patient;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "visit")
public class Visit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "test_date")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm", timezone="Europe/Vilnius")
    private Date visitDate;

    @Column(name = "visit_summary")
    private String summary;

    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;

    @ManyToOne
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;

    @ManyToMany (fetch = FetchType.LAZY)
    @JoinTable(name = "visit_labs",
            joinColumns = @JoinColumn(name = "visit_id"),
            inverseJoinColumns = @JoinColumn(name = "lab_id"))
    private List <LabTest> labTests = new ArrayList<>();

    @ManyToMany (fetch = FetchType.LAZY)
    @JoinTable(name = "visit_med_prescription",
            joinColumns = @JoinColumn(name = "visit_id"),
            inverseJoinColumns = @JoinColumn(name = "medicine_id"))
    private List <Medicines> medicines = new ArrayList<>();

}
