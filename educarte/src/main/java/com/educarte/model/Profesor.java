package com.educarte.model;
import javax.persistence.*;

@Entity
@Table(name="Profesor")
public class Profesor {
    @Id
    @Column(name= "id_profesor")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProfesor;

    @Column(name= "nombre_profesor", nullable = false)
    private String nombreProfesor;

    @Column(name = "apellido_profesor", nullable = false)
    private  String apellidoProfesor;

    @OneToOne
    @JoinColumn(name = "id_login", updatable = false, nullable = false)
    private Login idLogin;

    public Long getIdProfesor() {
        return idProfesor;
    }

    public void setIdProfesor(Long idProfesor) {
        this.idProfesor = idProfesor;
    }

    public String getNombreProfesor() {
        return nombreProfesor;
    }

    public void setNombreProfesor(String nombreProfesor) {
        this.nombreProfesor = nombreProfesor;
    }

    public String getApellidoProfesor() {
        return apellidoProfesor;
    }

    public void setApellidoProfesor(String apellidoProfesor) {
        this.apellidoProfesor = apellidoProfesor;
    }

    public Login getIdLogin() {
        return idLogin;
    }

    public void setIdLogin(Login idLogin) {
        this.idLogin = idLogin;
    }
}
