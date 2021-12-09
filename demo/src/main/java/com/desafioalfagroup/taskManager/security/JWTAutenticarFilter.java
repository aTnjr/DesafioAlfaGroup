package com.desafioalfagroup.taskManager.security;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.desafioalfagroup.taskManager.data.DetalheUsuData;
import com.desafioalfagroup.taskManager.model.UsuarioModel;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

public class JWTAutenticarFilter extends UsernamePasswordAuthenticationFilter{


    public static final int TOKEN_EXPIRACAO = 600_000;
    public static final String TOKEN_SENHA = "6b954dab-b5dd-4bc4-9ac8-382aaef8d9c2";

    private final AuthenticationManager authenticationManager;

    public JWTAutenticarFilter(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }


    @Override
    public Authentication attemptAuthentication(HttpServletRequest request,
    HttpServletResponse response) throws AuthenticationException{
        try {
            UsuarioModel usuario = new ObjectMapper().readValue(
                request.getInputStream(), 
                UsuarioModel.class);
                
                return authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                        usuario.getLogin(), 
                        usuario.getPassword(), 
                        new ArrayList<>()));
                    } catch (IOException e) {
                        throw new RuntimeException("Falha ao autenticar usuário", e);
                    }
                }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, 
    HttpServletResponse response, 
    FilterChain chain,
    Authentication authResult) throws IOException, ServletException {
        
        DetalheUsuData usuarioData = (DetalheUsuData) authResult.getPrincipal();
        
        String token = JWT.create().
                withSubject(usuarioData.getUsername()).
                withExpiresAt(new Date(System.currentTimeMillis() + TOKEN_EXPIRACAO)).
                sign(Algorithm.HMAC512(TOKEN_SENHA));
                
        response.getWriter().write(token);
        response.getWriter().flush();

    }   
}



