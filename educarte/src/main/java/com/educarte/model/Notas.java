
package com.educarte.model;


import javax.persistence.*;

@Entity
@Table(name="Notas")
public class Notas {
    @Id
    @Column(name= "id_notas")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idNotas;

    @ManyToOne
    @JoinColumn(name="id_estudiante", updatable = false, nullable = false)
    private Estudiante estudiante;

    @ManyToOne
    @JoinColumn(name="id_materia", updatable = false, nullable = false)
    private Materia materia;

    @Column(name= "nota1")
    private float nota1;

    @Column(name= "nota2")
    private float nota2;

    @Column(name= "nota3")
    private float nota3;

    @Column(name= "nota4")
    private float nota4;

    @Column(name= "control1")
    private float control1;

    @Column(name= "control2")
    private float control2;

    @Column(name= "control3")
    private float control3;

    @Column(name= "control4")
    private float control4;

    public Long getIdNotas() {
        return idNotas;
    }

    public void setIdNotas(Long idNotas) {
        this.idNotas = idNotas;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    public Materia getMateria() {
        return materia;
    }

    public void setMateria(Materia materia) {
        this.materia = materia;
    }

    public float getNota1() {
        return nota1;
    }

    public void setNota1(float nota1) {
        this.nota1 = nota1;
    }

    public float getNota2() {
        return nota2;
    }

    public void setNota2(float nota2) {
        this.nota2 = nota2;
    }

    public float getNota3() {
        return nota3;
    }

    public void setNota3(float nota3) {
        this.nota3 = nota3;
    }

    public float getNota4() {
        return nota4;
    }

    public void setNota4(float nota4) {
        this.nota4 = nota4;
    }

    public float getControl1() {
        return control1;
    }

    public void setControl1(float control1) {
        this.control1 = control1;
    }

    public float getControl2() {
        return control2;
    }

    public void setControl2(float control2) {
        this.control2 = control2;
    }

    public float getControl3() {
        return control3;
    }

    public void setControl3(float control3) {
        this.control3 = control3;
    }

    public float getControl4() {
        return control4;
    }

    public void setControl4(float control4) {
        this.control4 = control4;
    }
}

