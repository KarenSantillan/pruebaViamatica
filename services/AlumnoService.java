package com.vaiamtica.karens.services;

import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.Optional;


import com.vaiamtica.karens.repositories.AlumnoRepository;
import com.vaiamtica.karens.entities.Alumno;

public class AlumnoService {
    private final AlumnoRepository alumnoRepository;

    @Autowired
    public AlumnoService(AlumnoRepository alumnoRepository){
        this.alumnoRepository = alumnoRepository;
    }

    public List<Alumno> obtnerAllAlumnos(){
        return alumnoRepository.findAll();
    }
    public Optional<Alumno> obtenerAlumnoID(Long id){
        return alumnoRepository.findById(id);
    }
    public Alumno saveAlumno(Alumno alumno){
        return alumnoRepository.save(alumno);
    }
    public Alumno actualizarAlumno(Long id, Alumno alumno) throws Exception{
        Optional<Alumno> alumnoExiste = alumnoRepository.findById(id);
        if (alumnoExiste.isPresent()){
            Alumno alumnoAct = alumnoExiste.get();
            alumnoAct.setNombre(alumno.getNombre());
            alumnoAct.setApellido(alumno.getApellido());

            return alumnoRepository.save(alumnoAct);
        }else{
            throw new Exception("No se encontró  el alummno ingresado");
        }
                    

    }
    public void eliminarAlumno(Long id){
        alumnoRepository.deleteById(id);
    }
}
