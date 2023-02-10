package com.tata.desafio.tipocambio.service;

import com.tata.desafio.tipocambio.model.Moneda;

public interface IMonedaService {
    Moneda saveMoneda(Moneda moneda);
    Moneda getMoneda(Long id);
}
