package com.educarte.controller;

import com.educarte.dto.ReqLoginDto;
import com.educarte.dto.ResponseCursoProfesorDto;
import com.educarte.implement.CursoImp;
import com.educarte.model.Curso;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins="*")
@RequestMapping("/api/v1/cursos")
public class CursoController {

    @Autowired
    private CursoImp cursoImp;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseCursoProfesorDto listarCursosProfesor(@RequestBody Long idProfesor){
        List<Curso> listaCursosProfesor = new ArrayList<>();
        List<List<String>> listaNombreId = new ArrayList<>();
        try {
            listaCursosProfesor = cursoImp.findByIdProfesor(idProfesor);
        } catch (Exception ex){
            ex.printStackTrace();
        }
        for(Curso curso : listaCursosProfesor){
            List <String> listaPorCurso = new ArrayList<>();
            listaPorCurso.add(curso.getNombreCurso());
            listaPorCurso.add(curso.getIdCurso().toString());
            listaNombreId.add(listaPorCurso);
        }
        ResponseCursoProfesorDto response = new ResponseCursoProfesorDto();
        response.setListaCursosProfesor(listaNombreId);
        return response;
    }
}
