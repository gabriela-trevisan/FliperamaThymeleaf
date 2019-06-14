package com.fliperamaestudio.fliperamaestudio.service;


import com.fliperamaestudio.fliperamaestudio.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class SessionService {
    public final UserRepository userRepository;


    public SessionService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }



}
