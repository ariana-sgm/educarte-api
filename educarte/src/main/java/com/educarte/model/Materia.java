package com.educarte.model;
import javax.persistence.*;

@Entity
@Table(name="Materia")
public class Materia {
    @Id
    @Column(name= "id_materia")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name= "nombre", unique = true, nullable = false)
    //@NotBlank(message = "Nombre is mandatory")
    private String nombre;

    @Column(name = "id_curso", nullable = false)
    //@NotBlank(message = "id_curso is mandatory")
    private  Long id_curso;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Long getId_curso() {
        return id_curso;
    }

    public void setId_curso(Long id_curso) {
        this.id_curso = id_curso;
    }
}

