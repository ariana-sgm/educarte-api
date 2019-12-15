package com.educarte.controller;

import com.educarte.dto.*;
import com.educarte.implement.CursoImp;
import com.educarte.model.Curso;
import com.educarte.model.Profesor;
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

    @RequestMapping(value ="/guardados", method = RequestMethod.POST)
    public ResponseCursoProfesorDto saveCurso(@RequestBody ReqCursoDto cursoDto){
        Curso cursoController = new Curso();
        try{
            cursoController = cursoImp.saveCurso(cursoDto);
            if (cursoController == null) return null;
        } catch (Exception ex){
            ex.printStackTrace();
            return null;
        }
        return cursoImp.listarCursosProfesor(cursoController.getProfesor().getIdProfesor());
    }

    @RequestMapping(value = "/listas/{idProfesor}", method = RequestMethod.GET)
    public ResponseCursoProfesorDto listarCursosProfesor(@PathVariable Long idProfesor){
        ResponseCursoProfesorDto response = new ResponseCursoProfesorDto();
        try {
            response = cursoImp.listarCursosProfesor(idProfesor);
        } catch (Exception ex){
            ex.printStackTrace();
        }
        return response;
    }

    @RequestMapping(value = "/deletes/{idCurso}", method = RequestMethod.GET)
    public ResponseCursoProfesorDto deleteCurso(@PathVariable Long idCurso){
        Profesor profesor = cursoImp.findById(idCurso).getProfesor();
        try{
            boolean eliminado = cursoImp.eliminarCurso(idCurso);
            if (!eliminado) return null;
        } catch (Exception ex){
            ex.printStackTrace();
            return null;
        }
        return cursoImp.listarCursosProfesor(profesor.getIdProfesor());
    }
}
