package com.example.l6pract.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "directores")
public class Director {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "directorId", nullable = false)
    private Integer id;

    @NotBlank
    @Size(min = 2, max = 100)
    @Column(name = "nombre", length = 100)
    private String nombre;

    @Size(min = 9,max = 9)
    @Column(name = "telefono", length = 9)
    private String telefono;

    @Size(max = 50)
    @Column(name = "nacionalidad", length = 50)
    private String nacionalidad;

}