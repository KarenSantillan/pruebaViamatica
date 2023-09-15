package com.vaiamtica.karens.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vaiamtica.karens.entities.Maestro;
import com.vaiamtica.karens.services.MaestroService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/maestros")
@Validated
public class MaestroController {
        private final MaestroService maestroService;
    @Autowired
    public MaestroController(MaestroService maestroService){
        this.maestroService = maestroService;
    }

    @GetMapping
    public List<Maestro> obtenerAllMaestros(){
        return maestroService.obtnerAllMaestros();

    }
    @GetMapping("/{id}")
    public Optional<Maestro> obtenerMaestroID(@PathVariable Long id){
        return maestroService.obtenerMaestroID(id);
    }

    @PostMapping
    public Maestro saveMaestro(@Valid @RequestBody Maestro maestro){
        return maestroService.saveMaestro(maestro);
    }

    @PutMapping("/{id}")
    public Maestro actualizarMaestro(@PathVariable Long id, @RequestBody Maestro maestro) throws Exception{
        return maestroService.actualizarMaestro(id, maestro);
    }

    @DeleteMapping("/{id}")
    public void eliminarMaestro(@PathVariable Long id){
        maestroService.eliminarMaestro(id);
    }
}
