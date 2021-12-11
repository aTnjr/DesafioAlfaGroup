package com.desafioalfagroup.taskManager.repository;

import java.time.LocalDate;
import java.util.List;

import com.desafioalfagroup.taskManager.model.Tarefa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TarefaRepository extends JpaRepository<Tarefa, Long> {

    List<Tarefa> findByStatus(String status);

    @Query(value = "SELECT * FROM tb_tarefa ORDER BY (entrega_date - data)", nativeQuery = true)
    List<Tarefa> findAllByPrioridade();

    List<Tarefa> findByEntregaDate(LocalDate entregaDate);

}