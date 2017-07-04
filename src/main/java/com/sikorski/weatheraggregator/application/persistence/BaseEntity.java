package com.sikorski.weatheraggregator.application.persistence;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Getter
@NoArgsConstructor
public abstract class BaseEntity {

    @PrePersist
    public void prePersist() {
        updateForeignKeysBeforePersist();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "entity_seq_gen")
    @SequenceGenerator(name = "entity_seq_gen", sequenceName = "entity_seq", allocationSize = 1, initialValue = 1)
    protected Long id;

    /**
     * Aktualizuje przed zapisem klucze obce w obiektach zależnych.
     * W przypadku chęci skorzystania należy zaimplementować ją w obiektach podrzędnych.
     */
    protected void updateForeignKeysBeforePersist() {}

}