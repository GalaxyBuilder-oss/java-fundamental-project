package com.nyoba.nyicilprojek.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity
public class Generation {
    private Long id;
    private String name;
    @Column(columnDefinition = "TEXT")
    private String description;
}
