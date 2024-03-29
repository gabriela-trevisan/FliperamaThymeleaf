package com.fliperamaestudio.fliperamaestudio.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;


@Controller
public class LoginLogoutController {


    @GetMapping("/login")
    public String redirecionaLogin(){

        return "login";
    }

    @GetMapping("/logout")
    public String deslogar(HttpSession session){

        session.invalidate();

        return "redirect:/";
    }

}
