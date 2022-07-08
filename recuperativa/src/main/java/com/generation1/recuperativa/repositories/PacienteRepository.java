package com.generation1.recuperativa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.generation1.recuperativa.models.Paciente;
@Repository
public interface PacienteRepository extends JpaRepository<Paciente,Long> {
    
}
