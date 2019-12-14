
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
}

