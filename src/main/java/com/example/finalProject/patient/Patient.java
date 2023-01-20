package com.example.finalProject.patient;

import com.example.finalProject.allergy.Allergy;
import com.example.finalProject.disease.Disease;
import com.example.finalProject.role.Role;
import com.example.finalProject.user.User;
import com.example.finalProject.visit.Visit;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "patient")
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "date_of_birth")
//    @NotBlank(message = "Birth date cannot be blank")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date dateOfBirth;

    @Column (name = "biological_sex")
    private String biologicalSex;

    @OneToOne//(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @ManyToMany (fetch = FetchType.LAZY)
    @JoinTable(name = "patient_allergies",
            joinColumns = @JoinColumn(name = "patient_id"),
            inverseJoinColumns = @JoinColumn(name = "allergy_id"))
    private List<Allergy> allergies = new ArrayList<>();

    @ManyToMany (fetch = FetchType.LAZY)
    @JoinTable(name = "patient_diseases",
            joinColumns = @JoinColumn(name = "patient_id"),
            inverseJoinColumns = @JoinColumn(name = "disease_id"))
    private List<Disease> diseases = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "patient")
    private List<Visit> visits = new ArrayList<>();

}
