package com.vaiamtica.karens.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.vaiamtica.karens.entities.Maestro;
import com.vaiamtica.karens.repositories.MaestroRepository;

public class MaestroService {
    private final MaestroRepository maestroRepository;

    @Autowired
    public MaestroService(MaestroRepository maestroRepository){
        this.maestroRepository = maestroRepository;
    }

    public List<Maestro> obtnerAllMaestros(){
        return maestroRepository.findAll();
    }
    public Optional<Maestro> obtenerMaestroID(Long id){
        return maestroRepository.findById(id);
    }
    public Maestro saveMaestro(Maestro maestro){
        return maestroRepository.save(maestro);
    }
    public Maestro actualizarMaestro(Long id, Maestro maestro) throws Exception{
        Optional<Maestro> maestroExiste = maestroRepository.findById(id);
        if (maestroExiste.isPresent()){
            Maestro maestroAct = maestroExiste.get();
            maestroAct.setNombre(maestro.getNombre());
            maestroAct.setApellido(maestro.getApellido());

            return maestroRepository.save(maestroAct);
        }else{
            throw new Exception("No se encontró  el maestro ingresado");
        }
                    

    }    
    public void eliminarMaestro(Long id){
        maestroRepository.deleteById(id);
    }
}
