package com.tata.desafio.tipocambio.repositories;

import com.tata.desafio.tipocambio.model.TipoCambio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface ITipoCambioRepository extends JpaRepository<TipoCambio,Long> {
}
