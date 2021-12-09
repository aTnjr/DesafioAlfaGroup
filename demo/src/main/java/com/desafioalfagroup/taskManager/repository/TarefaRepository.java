package com.desafioalfagroup.taskManager.repository;

import java.util.List;

import com.desafioalfagroup.taskManager.model.Tarefa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TarefaRepository extends JpaRepository<Tarefa, Long> {

    List<Tarefa> findByStatus(String status);


}