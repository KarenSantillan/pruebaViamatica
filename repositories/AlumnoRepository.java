package com.vaiamtica.karens.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.vaiamtica.karens.entities.Alumno;

public interface AlumnoRepository extends JpaRepository<Alumno, Long>{
    
}
    