package com.tata.desafio.tipocambio.repositories;

import com.tata.desafio.tipocambio.model.Cliente;
import com.tata.desafio.tipocambio.model.Transaccion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ITransaccionRepository extends JpaRepository<Transaccion,Long> {
    //@Query("SELECT u FROM Cliente u WHERE u.correo = ?1 and u.contrasena = ?2")
    List<Transaccion> findTransaccionByCliente_Id(long id);
}
