package com.fliperamaestudio.fliperamaestudio.repository;

import com.fliperamaestudio.fliperamaestudio.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<Usuario, Integer> {
   Optional<Usuario> findByEmail(String email);
}
