package com.educarte.model;

import javax.persistence.*;

@Entity
@Table(name="Materia")
public class Materia {

    @Id
    @Column(name= "id_materia")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idMateria;

    @Column(name= "nombre_materia", nullable = false)
    private String nombreMateria;

    @ManyToOne
    @JoinColumn(name = "id_curso", updatable = false, nullable = false)
    private Curso curso;

    public Long getIdMateria() {
        return idMateria;
    }

    public void setIdMateria(Long idMateria) {
        this.idMateria = idMateria;
    }

    public String getNombreMateria() {
        return nombreMateria;
    }

    public void setNombreMateria(String nombreMateria) {
        this.nombreMateria = nombreMateria;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }
}
