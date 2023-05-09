package com.tata.desafio.tipocambio.service.impl;

import com.tata.desafio.tipocambio.model.Moneda;
import com.tata.desafio.tipocambio.repositories.IMonedaRepository;
import com.tata.desafio.tipocambio.service.IMonedaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MonedaService implements IMonedaService {
    @Autowired
    IMonedaRepository iMonedaRepository;

    @Override
    public List<Moneda> getMonedaAll() {
        return iMonedaRepository.findAll();
    }

    @Override
    public Moneda getMoneda(Long id) {
        return Optional.ofNullable(iMonedaRepository.findById(id).get()).orElseThrow(()-> new NullPointerException("LA MONEDA NO EXISTE"));
    }
    @Override
    public Moneda saveMoneda(Moneda moneda) {
        return iMonedaRepository.save(moneda);
    }
    @Override
    public Moneda putMoneda(Long id, Moneda monedaUpd) {
        Moneda monedaActual = iMonedaRepository.findById(id).get();
        monedaActual.setName(monedaUpd.getName());
        monedaActual.setPaisOrigen(monedaUpd.getPaisOrigen());
        return iMonedaRepository.save(monedaActual);
    }
}
