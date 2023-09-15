package com.vaiamtica.karens.services;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;

import com.vaiamtica.karens.entities.Materia;
import com.vaiamtica.karens.repositories.MateriaRepository;

public class MateriaService {

    private final MateriaRepository materiaRepository;

    @Autowired
    public MateriaService(MateriaRepository materiasRepository) {
        this.materiaRepository = materiasRepository;
    }
    public List<Materia> obtenerAllMaterias() {
        return materiaRepository.findAll();
    }

    public Optional<Materia> obtenerMateriaID(Long id) {
        return materiaRepository.findById(id);
    }

    public Materia saveMateria(Materia materia) {
        return materiaRepository.save(materia);
    }
    public Materia actualizarMateria(Long id, Materia materia) throws Exception{
        Optional<Materia> materiaExiste = materiaRepository.findById(id);
        if (materiaExiste.isPresent()){
            Materia materiaAct = materiaExiste.get();
            materiaAct.setDescripcion(materia.getDescripcion());
            materiaAct.setPuntos(materia.getPuntos());

            return materiaRepository.save(materiaAct);
        }else{
            throw new Exception("No se encontró  el alummno ingresado");
        }
                    

    }    

    public void eliminarMateria(Long id) {
        materiaRepository.deleteById(id);
    }
}
