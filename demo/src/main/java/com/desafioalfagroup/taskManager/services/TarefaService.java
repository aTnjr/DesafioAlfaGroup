package com.desafioalfagroup.taskManager.services;

import com.desafioalfagroup.taskManager.model.Tarefa;
import com.desafioalfagroup.taskManager.repository.TarefaRepository;

import org.springframework.beans.factory.annotation.Autowired;



public class TarefaService {
    
    @Autowired
    TarefaRepository tarefaRepository;

    public Tarefa saveTarefa(Tarefa tarefa){
        return tarefaRepository.saveAndFlush(tarefa);
    }
    

}
