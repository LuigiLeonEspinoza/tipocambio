package com.tata.desafio.tipocambio.repositories;

import com.tata.desafio.tipocambio.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface IClienteRespository extends JpaRepository<Cliente,Long> {
    @Query("SELECT u FROM Cliente u WHERE u.correo = ?1 and u.contrasena = ?2")
    List<Cliente> findUserByEmail(String email, String password);
}
