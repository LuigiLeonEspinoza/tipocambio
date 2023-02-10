package com.tata.desafio.tipocambio.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;

import java.io.Serializable;

@Entity
@Table
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TipoCambio implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ID_MONEDA_ORIGEN")
    private Moneda monedaOrigen;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ID_MONEDA_DESTINO")
    private Moneda monedaDestino;

    private double valorCambio;





}
