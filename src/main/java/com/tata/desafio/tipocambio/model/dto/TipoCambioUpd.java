package com.tata.desafio.tipocambio.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TipoCambioUpd implements Serializable {

    private static final long serialVersionUID = 1L;

    private double valorCambio;
}
