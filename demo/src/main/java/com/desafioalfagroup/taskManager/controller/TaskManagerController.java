package com.desafioalfagroup.taskManager.controller;

import java.util.List;

import com.desafioalfagroup.taskManager.model.Tarefa;
import com.desafioalfagroup.taskManager.repository.TarefaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/api")
public class TaskManagerController {


    @Autowired
    private final TarefaRepository tarefaRepository;
    
    
    public TaskManagerController(TarefaRepository tarefaRepository) {
        this.tarefaRepository = tarefaRepository;
    }

    @GetMapping("/tarefas")
    public List<Tarefa> getTarefas() {
        return tarefaRepository.findAll();
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Tarefa> saveTarefa(@RequestBody Tarefa tarefa) {
        tarefa.setData();
        return new ResponseEntity<Tarefa>(tarefaRepository.save(tarefa), HttpStatus.CREATED);
    }
    

    @GetMapping("/status")
    public List<Tarefa> tarefasPendentes(@RequestParam(value = "status", required = false) String status) {
        if (status == null){
            return this.tarefaRepository.findAll();
        }
        return this.tarefaRepository.findByStatus(status);
    }



    @DeleteMapping("/dell")
    public String deleteTarefa(){
        return "Deleta";
    }
    
    
}
