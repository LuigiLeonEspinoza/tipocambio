package com.tata.desafio.tipocambio.model.dto;

import com.tata.desafio.tipocambio.model.Cliente;
import com.tata.desafio.tipocambio.model.TipoCambio;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TransaccionDto implements Serializable {

    private static final long serialVersionUID = 1L;
    private Long tipoCambio;
    private double monto;

}
