package com.educarte.model;

import javax.persistence.*;

public class Estudiante {
        @Id
        @Column(name= "id_estudiante")
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        @Column(name= "nombre", nullable = false)
        //@NotBlank(message = "Name is mandatory")
        private String nombre;

        @Column(name = "apellido", nullable = false)
        //@NotBlank(message = "Password is mandatory")
        private  String apellido;

        @Column(name = "id_materia", nullable = false)
        //@NotBlank(message = "Password is mandatory")
        private Long id_materia;

        @Column(name = "id_curso", nullable = false)
        //@NotBlank(message = "Password is mandatory")
        private  Long id_curso;

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

        public Long getId_materia() {
            return id_materia;
        }

        public void setId_materia(Long id_materia) {
            this.id_materia = id_materia;
        }

        public Long getId_curso() {
            return id_curso;
        }

        public void setId_curso(Long id_curso) {
            this.id_curso = id_curso;
        }

        public Long getId_login() {
            return id_login;
        }

        public void setId_login(Long id_login) {
            this.id_login = id_login;
        }
    }
}
