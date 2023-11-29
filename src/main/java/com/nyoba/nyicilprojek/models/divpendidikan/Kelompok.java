package com.nyoba.nyicilprojek.models.divpendidikan;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Kelompok {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String practiceGroup;
    private int total;
}