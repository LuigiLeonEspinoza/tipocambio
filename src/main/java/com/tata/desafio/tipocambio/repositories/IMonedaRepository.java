package com.tata.desafio.tipocambio.repositories;

import com.tata.desafio.tipocambio.model.Moneda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IMonedaRepository extends JpaRepository<Moneda,Long> {
}
