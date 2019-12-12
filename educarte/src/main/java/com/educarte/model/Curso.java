package com.educarte.model;
import javax.persistence.*;

@Entity
@Table(name="Curso")
public class Curso {
    @Id
    @Column(name= "id_curso")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name= "nombre", unique = true, nullable = false)
    //@NotBlank(message = "Name is mandatory")
    private String nombre;

    @Column(name = "id_profesor", nullable = false)
    //@NotBlank(message = "id_profesor is mandatory")
    private  Long id_profesor;

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

    public Long getId_profesor() {
        return id_profesor;
    }

    public void setId_profesor(Long id_profesor) {
        this.id_profesor = id_profesor;
    }
}
