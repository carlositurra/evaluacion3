package com.generation1.recuperativa.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

@Entity
@Table(name="citas_medicas")
public class Citas_medicas{
//atributos
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;
private String hora;
private String area_medica;
//relacion Many To One
@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="paciente_id")
	private Paciente paciente;
//constructores
public Citas_medicas() {
}
public Citas_medicas(Long id, String hora, String area_medica, Paciente paciente) {
    this.id = id;
    this.hora = hora;
    this.area_medica = area_medica;
    this.paciente = paciente;
}
//getters y setters
public Long getId() {
    return id;
}
public void setId(Long id) {
    this.id = id;
}
public String getHora() {
    return hora;
}
public void setHora(String hora) {
    this.hora = hora;
}
public String getArea_medica() {
    return area_medica;
}
public void setArea_medica(String area_medica) {
    this.area_medica = area_medica;
}
public Paciente getPaciente() {
    return paciente;
}
public void setPaciente(Paciente paciente) {
    this.paciente = paciente;
}



@Column(updatable = false)
private Date createdAt;
private Date updatedAt;


@PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }
    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
}
}