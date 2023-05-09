package com.tata.desafio.tipocambio.service.impl;

import com.tata.desafio.tipocambio.model.Cliente;
import com.tata.desafio.tipocambio.model.Token;
import com.tata.desafio.tipocambio.repositories.IClienteRespository;
import com.tata.desafio.tipocambio.service.IClienteService;
import com.tata.desafio.tipocambio.service.util.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService implements IClienteService {
    @Autowired
    IClienteRespository iClienteRespository;
    @Override
    public Cliente saveClient(Cliente client) {
        Cliente cliente = iClienteRespository.save(client);
        cliente.setContrasena(null);
        return cliente;
    }

    @Override
    public Token getClient(Cliente client) {
        List<Cliente>clientes = iClienteRespository.findUserByEmail(client.getCorreo(),client.getContrasena());
        Optional.ofNullable(clientes.get(0)).orElseThrow(()-> new RuntimeException());
        String jwttoken = JWTUtil.gereratedJWT(clientes.get(0));
        Token token = new Token();
        token.setToken(jwttoken);
        return token;
    }

    @Override
    public Cliente getClient(Long id) {
        Cliente cliente =Optional.ofNullable(iClienteRespository.findById(id).get()).orElseThrow(()-> new NullPointerException());
        cliente.setContrasena(null);
        return  cliente;
    }

    @Override
    public Cliente ValidateToken(String token) {
        Long idCliente = JWTUtil.Decode(token);
        return Optional.ofNullable(iClienteRespository.findById(idCliente).get()).orElseThrow(()-> new NullPointerException("El Token no tiene datos validos"));
    }
}
