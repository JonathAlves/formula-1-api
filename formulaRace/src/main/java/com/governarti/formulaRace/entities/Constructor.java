package com.governarti.formulaRace.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "constructor")
@Getter
@Setter
public class Constructor {
    public Constructor(){}

    public Constructor(int constructorId, String constructorRef, String name, String nacionality, String url) {
        this.constructorId = constructorId;
        this.constructorRef = constructorRef;
        this.name = name;
        this.nacionality = nacionality;
        this.url = url;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CONSTRUCTOR_ID", nullable = false)
    private int constructorId;
    @Column(name = "CONSTRUCTOR_REF", nullable = false)
    private String constructorRef;
    @Column(name = "NAME", nullable = false)
    private String name;
    @Column(name = "NACIONALITY", nullable = false)
    private String nacionality;
    @Column(name = "URL", nullable = false)
    private String url;
}
