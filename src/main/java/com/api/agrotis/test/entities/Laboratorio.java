package com.api.agrotis.test.entities;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "laboratorio")
public class Laboratorio {
    @Id
    private long id;
    @Column(name = "nome")
    private String name;
}
