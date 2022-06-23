package com.api.agrotis.test.entities;


import javax.persistence.*;
@Entity
@Table(name = "infoPropriedades")
public class InfoPropriedade {
    @Id
    private long id;
    @Column(name = "nome")
    private String name;

    @Deprecated
    public InfoPropriedade() {
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
