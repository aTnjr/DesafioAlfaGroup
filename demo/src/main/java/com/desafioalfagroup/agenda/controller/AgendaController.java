package com.desafioalfagroup.agenda.controller;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

import com.desafioalfagroup.agenda.model.Tarefa;
import com.desafioalfagroup.agenda.repository.TarefaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;




@RestController
@RequestMapping(value = "/api")
public class AgendaController {

    Date entregaDate;
    String titulo;
    String status;
    String prioridade;
    Time entregaTime;

    @Autowired
    TarefaRepository tarefaRepository;
    
    @GetMapping
    public List<Tarefa> allTarefa() {
       return tarefaRepository.findAll();
    }
    
    @GetMapping("/tarefas")
    public List<Tarefa> getTarefas() {
        return tarefaRepository.findAll();
    }

    @PostMapping("/save")
    public ResponseEntity<Tarefa> saveTarefa(@RequestBody Tarefa tarefa) {
        tarefa.setData();
        return new ResponseEntity<Tarefa>(tarefaRepository.save(tarefa), HttpStatus.CREATED);
    }

    @GetMapping("/pendentes")
    public List<Tarefa> tarefasPendentes() {
        //Tarefa tarefa;
        return null;
    }

    @GetMapping("/concluídas")
    public List<Tarefa> tarefasConcluídas() {
        //Tarefa tarefa;
        return null;
    }

    @DeleteMapping("/dell")
    public String deleteTarefa(){
        return "Deleta";
    }
    
    
}
