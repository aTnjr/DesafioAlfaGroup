package com.desafioalfagroup.taskManager.repository;

import java.sql.Time;
import java.time.LocalDateTime;
import java.util.List;

import com.desafioalfagroup.taskManager.model.Tarefa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TarefaRepository extends JpaRepository<Tarefa, Long> {

    List<Tarefa> findByStatus(String status);

    List<Tarefa> findByPrioridade(String prioridade);

    @Query(value = "SELECT * FROM tb_tarefa ORDER BY (entrega_date - data)", nativeQuery = true)
    List<Tarefa> findAllByPrioridadeEntrega();

    @Query(value ="SELECT * FROM tb_tarefa WHERE status = 'Pendente' AND duracao <= '02:00:00'", nativeQuery = true)
    List<Tarefa> findByEntregaDate();

    List<Tarefa> findByData(LocalDateTime data);

}