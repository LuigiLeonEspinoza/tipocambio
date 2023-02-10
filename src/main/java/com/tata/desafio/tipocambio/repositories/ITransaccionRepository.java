package com.tata.desafio.tipocambio.repositories;

import com.tata.desafio.tipocambio.model.Transaccion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITransaccionRepository extends JpaRepository<Transaccion,Long> {
}
