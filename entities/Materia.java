package com.vaiamtica.karens.entities;
import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import jakarta.persistence.*;

@Entity
@Table(name = "materias")
public class Materia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;   
    @NotBlank(message = "Se debe ingresar una descripcion")
    @Size(min = 2, max = 45, message = "La descripcion debe tener maximo 45 caracteres")
    @Column(name = "descripcion")
    private String descripcion;

    @NotBlank(message = "Se debe ingresar los puntos")
    @Size(min = 2, max = 45, message = "Los puntos deben tener maximo 45 caracteres")
    @Column(name = "puntos")
    private String puntos;

    @ManyToMany
    @JoinTable(
        name = "idMateria",
        joinColumns = @JoinColumn(name = "idMateria"),
        inverseJoinColumns =  @JoinColumn(name = "idAlumno")
    )
    private List<Alumno> alumnos;

    //GETTERS Y SETTERS
    //ID
    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id = id;
    }
    //DESCRIPCION
    public String getDescripcion(){
        return descripcion;
    }
    public void setDescripcion(String descripcion){
        this.descripcion = descripcion;
    }
    //PUNTOS
    public String getPuntos(){
        return puntos;
    }
    public void setPuntos(String puntos){
        this.puntos = puntos;
    }
    //ALUMNOSRELACIONADOS
    public List<Alumno> getaAlumnos(){
        return alumnos;
    }
    public void setAlumnos(List<Alumno> alumnos){
        this.alumnos = alumnos;
    }


}

