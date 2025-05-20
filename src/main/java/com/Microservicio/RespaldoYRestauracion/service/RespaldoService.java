package com.Microservicio.RespaldoYRestauracion.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Microservicio.RespaldoYRestauracion.model.Respaldo;
import com.Microservicio.RespaldoYRestauracion.repository.RespaldoRepository;

@Service
public class RespaldoService {
    @Autowired
    private RespaldoRepository respaldoRepository;

    public List<Respaldo> listarTodos(){
        return respaldoRepository.findAll();
    }

    public Respaldo save(Respaldo respaldo){
        return respaldoRepository.save(respaldo);       
    }

    public Respaldo findById(int id){
        return respaldoRepository.findById(id);
    }

    public void delete(Respaldo respaldo){
        respaldoRepository.delete(respaldo);
    }
    
}
