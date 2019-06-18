package com.fliperamaestudio.fliperamaestudio.security;


import com.fliperamaestudio.fliperamaestudio.model.Usuario;
import com.fliperamaestudio.fliperamaestudio.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;

    public UserDetailsServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;

    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        var usuario = this.userRepository.findByEmail(email)
                .orElseThrow(()-> new UsernameNotFoundException("Email não encontrado"));

        return new UserPrincipal(usuario);
    }
}
