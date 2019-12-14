package com.educarte.model;
import javax.persistence.*;

@Entity
@Table(name="Estudiante")
public class Estudiante {

    @Id
    @Column(name = "id_estudiante")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEstudiante;

    @Column(name = "nombre_estudiante", nullable = false)
    private String nombreEstudiante;

    @Column(name = "apellido_estudiante", nullable = false)
    private String apellidoEstudiante;

    @ManyToOne
    @JoinColumn(name = "id_curso", updatable = false, nullable = false)
    private Curso curso;

    @OneToOne
    @JoinColumn(name = "id_login", updatable = false, nullable = false)
    private Login login;

    public Long getIdEstudiante() {
        return idEstudiante;
    }

    public void setIdEstudiante(Long idEstudiante) {
        this.idEstudiante = idEstudiante;
    }

    public String getNombreEstudiante() {
        return nombreEstudiante;
    }

    public void setNombreEstudiante(String nombreEstudiante) {
        this.nombreEstudiante = nombreEstudiante;
    }

    public String getApellidoEstudiante() {
        return apellidoEstudiante;
    }

    public void setApellidoEstudiante(String apellidoEstudiante) {
        this.apellidoEstudiante = apellidoEstudiante;
    }

    public Login getLogin() {
        return login;
    }

    public void setLogin(Login login) {
        this.login = login;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }
}

