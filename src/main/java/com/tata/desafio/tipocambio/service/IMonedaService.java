package com.tata.desafio.tipocambio.service;

import com.tata.desafio.tipocambio.model.Moneda;

import java.util.List;

public interface IMonedaService {
    Moneda saveMoneda(Moneda moneda);


    List<Moneda> getMonedaAll();

    Moneda getMoneda(Long id);


    Moneda putMoneda(Long id, Moneda monedaUpd);
}
