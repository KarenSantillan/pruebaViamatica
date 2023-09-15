package com.vaiamtica.karens.controllers;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

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

import com.vaiamtica.karens.entities.Materia;
import com.vaiamtica.karens.services.MateriaService;

@RestController
@RequestMapping("/materias")
@Validated
public class MateriaController {
    
    private final MateriaService materiaService;

    @Autowired
    public MateriaController(MateriaService materiaService) {
        this.materiaService = materiaService;
    }

    @GetMapping
    public List<Materia> obetenerAllMaterias() {
        return materiaService.obtenerAllMaterias();
    }

    @GetMapping("/{id}")
    public Optional<Materia> obtenerMateriaID(@PathVariable Long id) {
        return materiaService.obtenerMateriaID(id);
    }

    @PostMapping
    public Materia saveMateria(@Valid @RequestBody Materia materia) {
        return materiaService.saveMateria(materia);
    }

    @PutMapping("/{id}")
    public Materia actualizarMateria(@PathVariable Long id, @RequestBody Materia materia) throws Exception {
        return materiaService.actualizarMateria(id, materia);
    }

    @DeleteMapping("/{id}")
    public void eliminarMateria(@PathVariable Long id) {
        materiaService.eliminarMateria(id);
    }

}


