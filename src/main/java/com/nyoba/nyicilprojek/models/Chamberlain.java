package com.nyoba.nyicilprojek.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Chamberlain {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private long income;
    private long expense;
    private String date;

    @Column(columnDefinition = "TEXT")
    private String description;
}
