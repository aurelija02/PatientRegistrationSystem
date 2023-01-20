package com.example.finalProject.role;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "user_enum_roles")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private RolesEnum role;

}
