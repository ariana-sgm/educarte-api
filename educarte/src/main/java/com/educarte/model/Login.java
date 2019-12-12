package com.educarte.model;

import net.bytebuddy.dynamic.loading.InjectionClassLoader;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

//Anotacion de persistencia a jpa, declara que es una entidad
@Entity
//nombre de la tabla
@Table(name="Login")
public class Login {

    //Primary Key
    @Id
    @Column(name= "id_login")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name= "email", unique = true, nullable = false)
    //@NotBlank(message = "Email is mandatory")
    private String email;

    @Column(name = "password", nullable = false)
    //@NotBlank(message = "Password is mandatory")
    private  String password;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}