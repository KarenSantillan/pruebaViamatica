package com.vaiamtica.karens.entities;

import java.util.List;
import jakarta.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "alumnos")
public class Alumno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank(message = "Se debe ingresar un nombre")
    @Size(min = 2, max = 45, message = "El nombre debe tener maximo 45 caracteres")
    @Column(name = "nombre")
    private String nombre;

    @NotBlank(message = "Se debe ingresar un apellido")
    @Size(min = 2, max = 45, message = "El apellido debe tener maximo 45 caracteres")
    @Column(name = "apellido")
    private String apellido;

    @ManyToOne
    @JoinColumn(name = "idMaestro")
    private Maestro maestro;

    @ManyToMany(mappedBy = "alumnos")
    private List<Materia> materias;

        //Getters y Setters
    //IDMAESTRO
    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id = id;
    }
    //NOMBRE MAESTRO
     public String getNombre(){
        return nombre;
    }
    public void setNombre(String nombre){
        this.nombre = nombre;
    }   

    //APELLIDO MAESTRO

     public String getApellido(){
        return apellido;
    }
    public void setApellido(String apellido){
        this.apellido = apellido;
    }  

    //MATERIAS RELACIONADOS
    public List<Materia> getaAlumnos(){
        return materias;
    }
    public void setAlumnos(List<Materia> materias){
        this.materias = materias;
    }

 }
