package com.tata.desafio.tipocambio.service.impl;

import com.tata.desafio.tipocambio.model.Moneda;
import com.tata.desafio.tipocambio.model.TipoCambio;
import com.tata.desafio.tipocambio.model.dto.TipoCambioDto;
import com.tata.desafio.tipocambio.model.dto.TipoCambioUpd;
import com.tata.desafio.tipocambio.repositories.IMonedaRepository;
import com.tata.desafio.tipocambio.repositories.ITipoCambioRepository;
import com.tata.desafio.tipocambio.service.IMonedaService;
import com.tata.desafio.tipocambio.service.ITipoCambioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TipoCambioService implements ITipoCambioService {
    @Autowired
    ITipoCambioRepository iTipoCambioRepository;
    @Autowired
    IMonedaService iMonedaService;
    @Override
    public TipoCambio saveTipoCambio(TipoCambioDto tipoCambioDto) {
        Moneda monedaOrigen =iMonedaService.getMoneda(tipoCambioDto.getIdMonedaOrigen());
        Moneda monedaDestino =iMonedaService.getMoneda(tipoCambioDto.getIdMonedaDestino());
        TipoCambio tipoCambio = new TipoCambio();
        tipoCambio.setValorCambio(tipoCambioDto.getValorCambio());
        tipoCambio.setMonedaOrigen(monedaOrigen);
        tipoCambio.setMonedaDestino(monedaDestino);
        return iTipoCambioRepository.save(tipoCambio);
    }

    @Override
    public TipoCambio getTipoCambio(Long id) {
        return Optional.ofNullable(iTipoCambioRepository.findById(id).get()).orElseThrow(()->new RuntimeException());
    }

    @Override
    public TipoCambio UpdateTipoCambio(Long id, TipoCambioUpd tipoCambioUpd) {
        TipoCambio tipoCambio = Optional.ofNullable(iTipoCambioRepository.findById(id).get()).orElseThrow(()->new RuntimeException());
        Moneda monedaOrigen =iMonedaService.getMoneda(tipoCambioUpd.getIdMonedaOrigen());
        Moneda monedaDestino =iMonedaService.getMoneda(tipoCambioUpd.getIdMonedaDestino());
        tipoCambio.setMonedaOrigen(monedaOrigen);
        tipoCambio.setMonedaDestino(monedaDestino);
        tipoCambio.setValorCambio(tipoCambioUpd.getValorCambio());
        return iTipoCambioRepository.save(tipoCambio);
    }

}
