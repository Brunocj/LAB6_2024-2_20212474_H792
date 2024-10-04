package com.example.l6pract.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.Hibernate;

import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@Embeddable
public class EventosArtistaId implements Serializable {
    private static final long serialVersionUID = 3585358035461845792L;
    @Column(name = "eventoId", nullable = false)
    private Integer eventoId;

    @Column(name = "artistaId", nullable = false)
    private Integer artistaId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        EventosArtistaId entity = (EventosArtistaId) o;
        return Objects.equals(this.eventoId, entity.eventoId) &&
                Objects.equals(this.artistaId, entity.artistaId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(eventoId, artistaId);
    }

}