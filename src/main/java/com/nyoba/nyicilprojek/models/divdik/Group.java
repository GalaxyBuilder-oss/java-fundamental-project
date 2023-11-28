package com.nyoba.nyicilprojek.models.divdik;

import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity
public class Group {
    private Long id;
    private String practiceGroup;
    private int total;
}
