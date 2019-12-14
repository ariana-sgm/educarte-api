package com.educarte.mapping;

import com.educarte.model.Curso;
import org.springframework.stereotype.Service;


import java.util.Optional;

@Service
public class MappingCurso {
    public Curso transformarOptionalCurso(Optional<Curso> cursoOptional) throws Exception {
        Curso curso = null;
        try {
            if(cursoOptional.isPresent()){
                curso = new Curso();
                curso.setIdCurso(cursoOptional.get().getIdCurso());
                curso.setNombreCurso(cursoOptional.get().getNombreCurso());
                curso.setProfesor(cursoOptional.get().getProfesor());
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return curso;
    }
}
