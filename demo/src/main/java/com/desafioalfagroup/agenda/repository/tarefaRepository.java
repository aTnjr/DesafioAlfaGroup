package com.desafioalfagroup.agenda.repository;

import com.desafioalfagroup.agenda.model.tarefa;

import org.springframework.data.jpa.repository.JpaRepository;

public interface tarefaRepository extends JpaRepository<tarefa, Long> {
    
}