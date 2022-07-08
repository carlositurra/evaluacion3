package com.generation1.recuperativa.models;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "pacientes")
public class Paciente {
    //atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)   
    private Long id;
    private Long rut;
    private String nombre;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date fecha_nacimiento;

    @Column(updatable = false)
    private Date createdAt;
    private Date updatedAt;
    //relacion One To Many
    @OneToMany(mappedBy ="paciente", cascade=CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Citas_medicas> listaCitas;

    //constructores
public Paciente() {
    }
    
public Paciente(Long id, Long rut, String nombre, Date fecha_nacimiento) {
    this.id = id;
    this.rut = rut;
    this.nombre = nombre;
    this.fecha_nacimiento = fecha_nacimiento;
}
//getters y setters
public Long getId() {
    return id;
}

public void setId(Long id) {
    this.id = id;
}

public Long getRut() {
    return rut;
}

public void setRut(Long rut) {
    this.rut = rut;
}

public String getNombre() {
    return nombre;
}

public void setNombre(String nombre) {
    this.nombre = nombre;
}

public Date getFecha_nacimiento() {
    return fecha_nacimiento;
}

public void setFecha_nacimiento(Date fecha_nacimiento) {
    this.fecha_nacimiento = fecha_nacimiento;
}

@PrePersist
protected void onCreate(){
    this.createdAt = new Date();
}
@PreUpdate
protected void onUpdate(){
    this.updatedAt = new Date();
}
}
