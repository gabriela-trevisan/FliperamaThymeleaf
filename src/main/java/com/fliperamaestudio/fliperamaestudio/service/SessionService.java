package com.fliperamaestudio.fliperamaestudio.service;


import com.fliperamaestudio.fliperamaestudio.model.Usuario;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

@Service
@SessionAttributes("usuario")
public class SessionService {

    @ModelAttribute(name = "usuario")
    public Usuario usuario(){
        return new Usuario();
    }

    public void salvaSession(Usuario usr){
        Usuario usuario = usuario();

        usuario.setNome(usr.getNome());

    }



}
