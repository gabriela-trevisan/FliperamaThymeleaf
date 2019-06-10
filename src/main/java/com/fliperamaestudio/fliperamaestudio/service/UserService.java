package com.fliperamaestudio.fliperamaestudio.service;


import com.fliperamaestudio.fliperamaestudio.dao.UsuarioDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    public UsuarioDAO
}
