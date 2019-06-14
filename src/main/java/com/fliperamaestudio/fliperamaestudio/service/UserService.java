package com.fliperamaestudio.fliperamaestudio.service;


import com.fliperamaestudio.fliperamaestudio.model.Usuario;
import com.fliperamaestudio.fliperamaestudio.repository.UserRepository;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;



    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public Usuario save(Usuario usuario) {
        usuario.setSenha(passwordEncoder.encode(usuario.getSenha()));
        return userRepository.save(usuario);
    }

    public Usuario findEmail(String email){
        return userRepository.findByEmail(email).orElse(null);
    }


    public Usuario find(int id){
        return userRepository.findById(id).orElse(null);
    }

    public List<Usuario> findAll() {
        return userRepository.findAll(Sort.by("id"));
    }
}
