package com.Microservicio.RespaldoYRestauracion.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Microservicio.RespaldoYRestauracion.model.Respaldo;

@Repository
public interface RespaldoRepository extends JpaRepository<Respaldo, Integer>{
    
    List<Respaldo> findAll();
    
    @SuppressWarnings("unchecked")
    Respaldo save(Respaldo respaldo);

    Respaldo findById(int id);

    void delete(Respaldo respaldo);
    
}
