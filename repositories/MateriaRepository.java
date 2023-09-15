package com.vaiamtica.karens.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.vaiamtica.karens.entities.Materia;

public interface MateriaRepository extends JpaRepository<Materia, Long>{
    
}
