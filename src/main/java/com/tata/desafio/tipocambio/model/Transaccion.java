package com.tata.desafio.tipocambio.model;

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

public class Transaccion implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ID_TIPO_CAMBIO")
    private TipoCambio tipoCambio;
    private double monto;
    private double montoCambio;
    private String fecha;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ID_CLIENT")
    private Cliente cliente;


}
