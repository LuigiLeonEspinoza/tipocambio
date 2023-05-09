package com.tata.desafio.tipocambio.model.dto;

import com.tata.desafio.tipocambio.model.Moneda;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class TipoCambioDto implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long idMonedaOrigen;
    private Long idMonedaDestino;
    private double valorCambio;
}
