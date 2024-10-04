package com.example.l6pract.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Range;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "peliculas")
public class Pelicula {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "peliculaId", nullable = false)
    private Integer id;

    @Size(min = 3,max = 100)
    @NotBlank
    @Column(name = "titulo", length = 100)
    private String titulo;


    @Column(name = "fechaEstreno")
    private LocalDate fechaEstreno;

    @Range(min = 0)
    @Column(name = "duracionMinutos")
    private Integer duracionMinutos;

}