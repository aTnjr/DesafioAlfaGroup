package com.desafioalfagroup.agenda.controller;

import java.util.List;

import com.desafioalfagroup.agenda.model.tarefa;
import com.desafioalfagroup.agenda.repository.tarefaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;




@RestController
public class AgendaController {

    @Autowired
    tarefaRepository tarefaRepository;
    
    @GetMapping("/tarefas")
    public List<tarefa> getTarefas() {
        return tarefaRepository.findAll();
    }

    @GetMapping
    public String getTarefa() {
        return "Pega";
    }

    @PostMapping
    public String createTarefa() {
        return "Cria";
    }

    @PutMapping
    public String updateTarefa() {
        
        return "Atualiza";
    }

    @DeleteMapping
    public String deleteTarefa(){
        return "Deleta";
    }
    
    
}
