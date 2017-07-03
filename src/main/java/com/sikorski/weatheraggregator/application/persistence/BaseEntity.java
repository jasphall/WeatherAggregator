package com.sikorski.weatheraggregator.application.persistence;

import lombok.Getter;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Getter
public abstract class BaseEntity {

    @Id
    @GeneratedValue
    private Long id;

}