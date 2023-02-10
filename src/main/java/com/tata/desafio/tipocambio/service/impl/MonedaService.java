package com.tata.desafio.tipocambio.service.impl;

import com.tata.desafio.tipocambio.model.Moneda;
import com.tata.desafio.tipocambio.repositories.IMonedaRepository;
import com.tata.desafio.tipocambio.service.IMonedaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MonedaService implements IMonedaService {
    @Autowired
    IMonedaRepository iMonedaRepository;

    @Override
    public Moneda saveMoneda(Moneda moneda) {
        return iMonedaRepository.save(moneda);
    }

    @Override
    public Moneda getMoneda(Long id) {
        return Optional.ofNullable(iMonedaRepository.findById(id).get()).orElseThrow(()-> new RuntimeException("LA MONEDA NO EXISTE"));
    }
}
