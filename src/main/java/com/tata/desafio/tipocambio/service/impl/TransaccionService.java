package com.tata.desafio.tipocambio.service.impl;

import com.tata.desafio.tipocambio.model.Cliente;
import com.tata.desafio.tipocambio.model.TipoCambio;
import com.tata.desafio.tipocambio.model.Transaccion;
import com.tata.desafio.tipocambio.model.dto.TransaccionDto;
import com.tata.desafio.tipocambio.repositories.ITransaccionRepository;
import com.tata.desafio.tipocambio.service.IClienteService;
import com.tata.desafio.tipocambio.service.ITipoCambioService;
import com.tata.desafio.tipocambio.service.ITransaccionService;
import com.tata.desafio.tipocambio.service.util.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransaccionService implements ITransaccionService {
    @Autowired
    ITransaccionRepository iTransaccionRepository;
    @Autowired
    IClienteService iClienteService;
    @Autowired
    ITipoCambioService iTipoCambioService;
    @Override
    public Transaccion saveTransaccion(String token,TransaccionDto transaccionDto) {
        Long idCliente = JWTUtil.Decode(token);
        Cliente cliente = iClienteService.getClient(idCliente);
        TipoCambio tipoCambio = iTipoCambioService.getTipoCambio(transaccionDto.getTipoCambio());
        Transaccion transaccion = new Transaccion();
        transaccion.setCliente(cliente);
        transaccion.setTipoCambio(tipoCambio);
        transaccion.setMonto(transaccionDto.getMonto());
        double montocambio=transaccionDto.getMonto()*tipoCambio.getValorCambio();
        transaccion.setMontoCambio(montocambio);
        return iTransaccionRepository.save(transaccion);

    }

}
