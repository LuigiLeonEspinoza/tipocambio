package com.tata.desafio.tipocambio.service;

import com.tata.desafio.tipocambio.model.TipoCambio;
import com.tata.desafio.tipocambio.model.dto.TipoCambioDto;
import com.tata.desafio.tipocambio.model.dto.TipoCambioUpd;

public interface ITipoCambioService {
    TipoCambio saveTipoCambio(TipoCambioDto tipoCambio);
    TipoCambio getTipoCambio(Long id);
    TipoCambio UpdateTipoCambio(Long id,TipoCambioUpd tipoCambioUpd);
}
