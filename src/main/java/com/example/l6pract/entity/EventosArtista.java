package com.example.l6pract.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "eventos_artistas")
public class EventosArtista {
    @EmbeddedId
    private EventosArtistaId id;

    @MapsId("eventoId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "eventoId", nullable = false)
    private Evento evento;

    @MapsId("artistaId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "artistaId", nullable = false)
    private Artista artista;

}