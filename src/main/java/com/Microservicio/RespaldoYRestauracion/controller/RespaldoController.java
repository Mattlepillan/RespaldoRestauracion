package com.Microservicio.RespaldoYRestauracion.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Microservicio.RespaldoYRestauracion.model.Respaldo;
import com.Microservicio.RespaldoYRestauracion.service.RespaldoService;

@RestController
@RequestMapping("/api/resp")
public class RespaldoController {
    @Autowired
    private RespaldoService respaldoService;

    @GetMapping
    public ResponseEntity<List<Respaldo>> getRespaldo(){
        List<Respaldo> respaldo = respaldoService.listarTodos();
        if (respaldo.isEmpty())
        {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(respaldo,HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Respaldo> postRespaldo(@RequestBody Respaldo respaldo){
        Respaldo buscado = respaldoService.findById(respaldo.getId());
        if(buscado == null)
        {
            return new ResponseEntity<>(respaldoService.save(respaldo), HttpStatus.CREATED);
        }
        else
        {
            
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }


    }

    @PutMapping("/{id}")
    public ResponseEntity<Respaldo> putCurso(@PathVariable int id, @RequestBody Respaldo respaldo){
        Respaldo buscado = respaldoService.findById(respaldo.getId());
        if(buscado == null)
        {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        else
        {
            buscado.setNombre(respaldo.getNombre());
            buscado.setFecha(respaldo.getFecha());
            return new ResponseEntity<>(respaldoService.save(respaldo),HttpStatus.OK);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Respaldo> deleteCurso(@PathVariable int id, @RequestBody Respaldo respaldo){
        Respaldo buscado = respaldoService.findById(respaldo.getId());
        if(buscado == null)
        {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        else
        {
            respaldoService.delete(respaldo);
            return new ResponseEntity<>( HttpStatus.OK);
        }
    }
    
}
