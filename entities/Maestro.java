package com.vaiamtica.karens.entities;

import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import jakarta.persistence.*;

@Entity
@Table(name = "maestros")
public class Maestro {
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

    @NotBlank(message = "Se debe ingresar un titulo")
    @Size(min = 2, max = 45, message = "El titulo debe tener maximo 45 caracteres")
    @Column(name = "titulo")
    private String titulo;

    @OneToMany(mappedBy = "maestro")
    private List<Alumno> alumnosA;

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
    //TITULO
    public String getTitulo(){
    return titulo;
    }
    public void setTitulo(String titulo){
        this.titulo = titulo;
    }  
    //ALUMNOS RELACIONADOS
    public List<Alumno> getaAlumnos(){
        return alumnosA;
    }
    public void setAlumnos(List<Alumno> alumnosA){
        this.alumnosA = alumnosA;
    }

}
