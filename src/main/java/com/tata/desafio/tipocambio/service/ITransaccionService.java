package com.tata.desafio.tipocambio.service;

import com.tata.desafio.tipocambio.model.Transaccion;
import com.tata.desafio.tipocambio.model.dto.TransaccionDto;

public interface ITransaccionService {
    Transaccion saveTransaccion(String token , TransaccionDto transaccion);
}
