package com.example.l6pract.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "eventos")
public class Evento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "eventoId", nullable = false)
    private Integer id;

    @Column(name = "nombre", length = 100)
    @Size(min=3,max=100,message = "El nombre debe tener entre 3 y 100 caracteres")
    @NotBlank(message="El nombre es obligatorio")
    private String nombre;

    @Column(name = "fecha")
    @NotBlank(message="La fecha es obligatoria")
    @Future(message = "La fecha del evento debe ser una fecha futura")
    private LocalDate fecha;

    @Column(name = "asistentesEsperados")
    @NotBlank(message = "El número de asistentes no puede ser nulo")
    @Positive(message = "El número de asistentes debe ser positivo")
    private Integer asistentesEsperados;

}