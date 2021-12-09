package com.desafioalfagroup.taskManager.services;

import java.util.Optional;

import com.desafioalfagroup.taskManager.data.DetalheUsuData;
import com.desafioalfagroup.taskManager.model.UsuarioModel;
import com.desafioalfagroup.taskManager.repository.UsuarioRepository;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class DetalheUsuarioService implements UserDetailsService{

    private final UsuarioRepository repository;
    
    public DetalheUsuarioService(UsuarioRepository repository){
        this.repository = repository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UsuarioModel> usuario = repository.findByLogin(username);
        if (usuario.isEmpty()){
            throw new UsernameNotFoundException("Usuário ["+ username +"] não encontrado");
        }
        
        return new DetalheUsuData(usuario);
    }
    
}
