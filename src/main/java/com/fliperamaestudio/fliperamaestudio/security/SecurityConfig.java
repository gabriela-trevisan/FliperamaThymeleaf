package com.fliperamaestudio.fliperamaestudio.security;


import com.fliperamaestudio.fliperamaestudio.model.Usuario;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.ModelAttribute;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final UserDetailsServiceImpl userDetailsServiceimpl;

    public SecurityConfig(UserDetailsServiceImpl userDetailsServiceimpl) {
        this.userDetailsServiceimpl = userDetailsServiceimpl;
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/usuario/*").hasAnyRole()
                .antMatchers("/agendamento/agendar").hasAnyRole()
                .antMatchers("/**").permitAll()
                .antMatchers("/cadastrar").permitAll()
                .and()
                .formLogin().loginPage("/login").defaultSuccessUrl("/session")
                .failureUrl("/login?error")
                .usernameParameter("email").passwordParameter("senha")
                .and().logout().logoutUrl("/logout").logoutSuccessUrl("/agendamento");
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(this.userDetailsServiceimpl).passwordEncoder(passwordEncoder());
    }

    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }



}
