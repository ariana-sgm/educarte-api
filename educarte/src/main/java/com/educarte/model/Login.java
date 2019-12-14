package com.educarte.model;
import javax.persistence.*;

//Anotacion de persistencia a jpa, declara que es una entidad
//nombre de la tabla
@Entity
@Table(name="Login")
public class Login {

    //Primary Key
    @Id
    @Column(name= "id_login")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idLogin;

    @Column(name= "email", unique = true, nullable = false)
    private String email;

    @Column(name = "password", nullable = false)
    private  String password;

    public Long getIdLogin() {
        return idLogin;
    }

    public void setIdLogin(Long idLogin) {
        this.idLogin = idLogin;
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