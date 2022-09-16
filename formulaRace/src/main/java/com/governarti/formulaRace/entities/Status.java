package com.governarti.formulaRace.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "status")
@Getter
@Setter
public class Status {
    public Status() {}

    public Status(int statusId, String status) {
        this.statusId = statusId;
        this.status = status;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int statusId;
    @Column(name = "STATUS")
    private String status;
}
