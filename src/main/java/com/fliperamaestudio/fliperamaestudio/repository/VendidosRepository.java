package com.fliperamaestudio.fliperamaestudio.repository;

import com.fliperamaestudio.fliperamaestudio.model.Vendidos;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface VendidosRepository extends JpaRepository<Vendidos, Integer> {

    List<Vendidos> findVendidosByDataBetween(LocalDateTime inicio, LocalDateTime fim);

}
