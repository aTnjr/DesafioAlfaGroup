package com.desafioalfagroup.taskManager.model;

import static javax.persistence.GenerationType.AUTO;

import java.io.Serializable;
import java.sql.Time;
import java.time.LocalDate;
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

    @Column(name = "entrega_date")
    private LocalDate entregaDate;

    @Column(name = "entrega_time")
    private Time entregaTime;
    private String status;
    private LocalDateTime data;

    public Tarefa(){
    }

    public Time getEntregaTime() {
        return entregaTime;
    }
    
    public void setEntregaTime(Time entregaTime) {
        this.entregaTime = entregaTime;
    }
    
    public LocalDateTime getData() {
        return data;
    }

    public void setData(){
        this.data = LocalDateTime.now();
    }

    public LocalDate getEntregaDate() {
        return entregaDate;
    }
    
    public void setEntregaDate(LocalDate entregaDate) {
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