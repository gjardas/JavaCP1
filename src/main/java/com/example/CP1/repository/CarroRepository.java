package com.example.CP1.repository;

import com.example.CP1.model.Carro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarroRepository extends JpaRepository<Carro, Long> {
    List<Carro> findTop10ByOrderByPotenciaDesc();
    List<Carro> findTop10ByOrderByEconomiaDesc();
    List<Carro> findByTipoIgnoreCase(String tipo);
}
