package com.tata.desafio.tipocambio.service;


import com.tata.desafio.tipocambio.model.Cliente;
import com.tata.desafio.tipocambio.model.Token;

public interface IClienteService {
    Cliente saveClient(Cliente client);
    Token getClient(Cliente client);
    Cliente getClient(Long id);

    Cliente ValidateToken(String token);


}
