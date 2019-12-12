package com.educarte.model;
import javax.persistence.*;

@Entity
@Table(name="Profesor")
public class Profesor {
    @Id
    @Column(name= "id_profesor")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name= "nombre", nullable = false)
    //@NotBlank(message = "Name is mandatory")
    private String nombre;

    @Column(name = "apellido", nullable = false)
    //@NotBlank(message = "Password is mandatory")
    private  String apellido;

    @Column(name = "id_login", nullable = false)
    //@NotBlank(message = "Password is mandatory")
    private  Long id_login;

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

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Long getId_login() {
        return id_login;
    }

    public void setId_login(Long id_login) {
        this.id_login = id_login;
    }
}
