package com.example.teste.sonda;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SondaRepository extends JpaRepository<Sonda, Integer> {

    @Query("SELECT s FROM Sonda s WHERE s.planalto = planaltoId AND s.posicaoX = posicaoX AND s.posicaoY = posicaoY")
    List<Sonda> buscaSondaEmPontoEspecifico(Integer planaltoId, Integer posicaoX, Integer posicaoY);
}
