package com.desafioalfagroup.agenda.repository;

import com.desafioalfagroup.agenda.model.Tarefa;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TarefaRepository extends JpaRepository<Tarefa, Long> {
    
}