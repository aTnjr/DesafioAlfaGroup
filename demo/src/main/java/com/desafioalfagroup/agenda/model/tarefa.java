package com.desafioalfagroup.agenda.model;

import static javax.persistence.GenerationType.AUTO;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TB_TAREFA")
public class tarefa {

    @Id
    @GeneratedValue(strategy = AUTO)
    private Long id;

    private String Titulo;
    private Date EntregaDate;
    private Time EntregaTime;
    private String Prioridade;
    private String Status;
    private LocalDateTime data;


    public String getPrioridade() {
        return Prioridade;
    }
    
    public Time getEntregaTime() {
        return EntregaTime;
    }

    public void setEntregaTime(Time entregaTime) {
        this.EntregaTime = entregaTime;
    }

    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }

    public Date getEntregaDate() {
        return EntregaDate;
    }

    public void setEntregaDate(Date entregaDate) {
        this.EntregaDate = entregaDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    public String getStatus() {
        return Status;
    }
    public void setStatus(String status) {
        this.Status = status;
    }
    public String getTitulo() {
        return Titulo;
    }
    public void setTitulo(String titulo) {
        this.Titulo = titulo;
    }
    public void setPrioridade(String prioridade) {
        this.Prioridade = prioridade;
    }
}