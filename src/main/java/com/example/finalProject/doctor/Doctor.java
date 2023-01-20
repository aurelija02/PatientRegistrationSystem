package com.example.finalProject.doctor;

import com.example.finalProject.availableTimes.AvailableTimes;
import com.example.finalProject.user.User;
import com.example.finalProject.visit.Visit;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "doctor")
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "specialty")
    private String specialty;

    @Column(name = "experience")
    private Integer experience;

    @OneToOne//(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "doctor")
    private List<Visit> visits = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "doctor")
    private List<AvailableTimes> availableVisits = new ArrayList<>();

}
