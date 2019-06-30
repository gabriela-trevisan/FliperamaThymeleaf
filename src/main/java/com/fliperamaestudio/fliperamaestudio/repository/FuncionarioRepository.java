package com.fliperamaestudio.fliperamaestudio.repository;

import com.fliperamaestudio.fliperamaestudio.model.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Integer> {
    Optional<Funcionario> findById(Integer integer);
}
