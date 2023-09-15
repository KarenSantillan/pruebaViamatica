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

import com.vaiamtica.karens.services.AlumnoService;
import jakarta.validation.Valid;
import com.vaiamtica.karens.entities.Alumno;

@RestController
@RequestMapping("/alumnos")
@Validated
public class AlumnoController {
    private final AlumnoService alumnoService;
    @Autowired
    public AlumnoController(AlumnoService alumnoService){
        this.alumnoService = alumnoService;
    }

    @GetMapping
    public List<Alumno> obtenerAllAlumnos(){
        return alumnoService.obtnerAllAlumnos();

    }
    @GetMapping("/{id}")
    public Optional<Alumno> obtenerAlumnoID(@PathVariable Long id){
        return alumnoService.obtenerAlumnoID(id);
    }

    @PostMapping
    public Alumno saveAlumno(@Valid @RequestBody Alumno alumno){
        return alumnoService.saveAlumno(alumno);
    }

    @PutMapping("/{id}")
    public Alumno actualizarAlumno(@PathVariable Long id, @RequestBody Alumno alumno) throws Exception{
        return alumnoService.actualizarAlumno(id, alumno);
    }

    @DeleteMapping("/{id}")
    public void eliminarAlumno(@PathVariable Long id){
        alumnoService.eliminarAlumno(id);
    }
}
