package com.desafioalfagroup.taskManager.repository;

import java.util.Optional;

import com.desafioalfagroup.taskManager.model.UsuarioModel;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<UsuarioModel, Integer> {

    public Optional<UsuarioModel> findByLogin(String login);

}
