package services;

import com.desafioalfagroup.agenda.model.Tarefa;
import com.desafioalfagroup.agenda.repository.TarefaRepository;

import org.springframework.beans.factory.annotation.Autowired;

public class TarefaService {
    
    @Autowired
    TarefaRepository tarefaRepository;

    public Tarefa saveTarefa(Tarefa tarefa){
        return tarefaRepository.saveAndFlush(tarefa);
    } 

}
