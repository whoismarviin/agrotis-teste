package com.api.agrotis.test.entities;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Amostra {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "dataInicial",nullable = false)
    private Date dataInicial;
    @Column(name = "dataFinal",nullable = false)
    private Date dataFinal;
    @OneToOne
    private InfoPropriedade infoPropriedade;
    @OneToOne
    private Laboratorio laboratorio;
    @Column(name="obsevacoes")
    private String observacoes;

}
