package com.desafioalfagroup.taskManager.controller;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

import com.desafioalfagroup.taskManager.model.Tarefa;
import com.desafioalfagroup.taskManager.repository.TarefaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/api/tarefas")
public class TaskManagerController {


    @Autowired
    private final TarefaRepository tarefaRepository;
    
    
    public TaskManagerController(TarefaRepository tarefaRepository) {
        this.tarefaRepository = tarefaRepository;
    }

    @GetMapping
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

    @GetMapping("/prioridade")
    public List<Tarefa> tarefasPrioridade(@RequestParam(value = "prioridade", required = false) String prioridade) {
        if (prioridade == null){
            return this.tarefaRepository.findAll();
        }
        return this.tarefaRepository.findByPrioridade(prioridade);
    }

    @GetMapping("/ordem")
    public List<Tarefa> tarefasEntregaOrdem() {
        return tarefaRepository.findAll(Sort.by("entregaDate"));
    }
    
    @GetMapping("/prioridadeEntrega")
    public List<Tarefa> tarefasPrioridadeEntrega(){
        return tarefaRepository.findAllByPrioridadeEntrega();
    }
    
    @GetMapping("/pendentesPrioridade")
    public List<Tarefa> tarefasPendentesPrioridade() {
        return tarefaRepository.findByEntregaDate();
    }

    @GetMapping("/data")
    public List<Tarefa> tarefasPorData(String data){
        LocalDateTime dateTime = LocalDateTime.parse(data);
        return tarefaRepository.findByData(dateTime);
    }
}
