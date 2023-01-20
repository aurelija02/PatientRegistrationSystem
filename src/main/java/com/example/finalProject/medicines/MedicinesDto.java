package com.example.finalProject.medicines;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class MedicinesDto {

    private Long id;

    private String medicine;

    private Double dosage;

}
