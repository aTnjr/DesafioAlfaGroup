package com.desafioalfagroup.taskManager.model;

import static javax.persistence.GenerationType.AUTO;

import java.io.Serializable;
import java.sql.Time;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="TB_TAREFA")
public class Tarefa implements Serializable {

    @Id
    @GeneratedValue(strategy = AUTO)
    private Long id;

    private String titulo;
    private Time duracao;
    private String prioridade;

    @Column(name = "entrega_date")
    private LocalDateTime entregaDate;

    private String status;
    private LocalDateTime data;

    public Tarefa(){
    }
    
    public String getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(String prioridade) {
        this.prioridade = prioridade;
    }

    public Time getDuracao() {
        return duracao;
    }

    public void setDuracao(Time duracao) {
        this.duracao = duracao;
    }

    public LocalDateTime getData() {
        return data;
    }

    public void setData(){
        this.data = LocalDateTime.now();
    }

    public LocalDateTime getEntregaDate() {
        return entregaDate;
    }
    
    public void setEntregaDate(LocalDateTime entregaDate) {
        this.entregaDate = entregaDate;
    }
    
    public Long getId() {
        return id;
    }
    
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
}