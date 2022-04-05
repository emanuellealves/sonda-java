package com.example.teste.planalto;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlanaltoRepository extends JpaRepository<Planalto, Integer> {
}
