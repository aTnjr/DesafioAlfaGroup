package com.desafioalfagroup.taskManager.controller;

import java.util.Optional;

import com.desafioalfagroup.taskManager.model.UsuarioModel;
import com.desafioalfagroup.taskManager.repository.UsuarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    @Autowired
    private UsuarioRepository repository;
    @Autowired
    private final PasswordEncoder encoder;

    public LoginController(UsuarioRepository repository, PasswordEncoder encoder) {
        this.repository = repository;
        this.encoder = encoder;
    }

    
    @GetMapping("/login")
    public ResponseEntity<Boolean> validarSenha(@RequestParam String login, @RequestParam String password){

        Optional<UsuarioModel> optUsuario = repository.findByLogin(login);
        if(optUsuario.isEmpty()){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(false);
        }
        
        UsuarioModel usuario = optUsuario.get();
        boolean valid = encoder.matches(password, usuario.getPassword());

        HttpStatus status = (valid) ? HttpStatus.OK : HttpStatus.UNAUTHORIZED;
        return ResponseEntity.status(status).body(valid);
    }
    
}
