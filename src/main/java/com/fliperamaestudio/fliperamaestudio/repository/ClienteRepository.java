package com.fliperamaestudio.fliperamaestudio.repository;

import com.fliperamaestudio.fliperamaestudio.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

    @Override
    Optional<Cliente> findById(Integer integer);

}
