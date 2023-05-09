package com.tata.desafio.tipocambio.service.impl;

import com.tata.desafio.tipocambio.model.Cliente;
import com.tata.desafio.tipocambio.model.TipoCambio;
import com.tata.desafio.tipocambio.model.Transaccion;
import com.tata.desafio.tipocambio.model.dto.TransaccionDto;
import com.tata.desafio.tipocambio.repositories.ITransaccionRepository;
import com.tata.desafio.tipocambio.service.IClienteService;
import com.tata.desafio.tipocambio.service.ITipoCambioService;
import com.tata.desafio.tipocambio.service.ITransaccionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.crypto.Data;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

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
        //Long idCliente = JWTUtil.Decode(token);
        Cliente cliente = iClienteService.ValidateToken(token);
        TipoCambio tipoCambio = iTipoCambioService.getTipoCambio(transaccionDto.getTipoCambio());
        Transaccion transaccion = new Transaccion();
        transaccion.setCliente(cliente);
        transaccion.setTipoCambio(tipoCambio);
        transaccion.setMonto(transaccionDto.getMonto());
        double montocambio=transaccionDto.getMonto()*tipoCambio.getValorCambio();
        transaccion.setMontoCambio(montocambio);
        transaccion.setFecha(new Date().toString());
        Transaccion transaccionRspt = iTransaccionRepository.save(transaccion);
        transaccionRspt.getCliente().setContrasena(null);
        return transaccionRspt;

    }
    @Override
    public List<Transaccion> GetTransaccionCliente(String token) {
        Cliente cliente = iClienteService.ValidateToken(token);
        List<Transaccion> transaccionList = iTransaccionRepository.findTransaccionByCliente_Id(cliente.getId());
        return transaccionList.stream().map((element)->{
           element.getCliente().setContrasena(null);
           return element;
        }).collect(Collectors.toList());

    }

}
