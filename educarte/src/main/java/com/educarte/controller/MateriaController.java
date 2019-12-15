package com.educarte.controller;

import com.educarte.dto.*;
import com.educarte.implement.MateriaImp;
import com.educarte.mapping.MappingMateria;
import com.educarte.model.Curso;
import com.educarte.model.Materia;
import com.educarte.model.Profesor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins="*")
@RequestMapping("/api/v1/materias")
public class MateriaController {

    @Autowired
    MateriaImp materiaImp;

    @Autowired
    MappingMateria mappingMateria;

    @RequestMapping(value ="/guardadas", method = RequestMethod.POST)
    public ResponseMateriaCursoDto saveMateria(@RequestBody ReqMateriaDto materiaDto){
        Materia materiaController = new Materia();
        try{
            materiaController = materiaImp.saveMateria(materiaDto);
            if (materiaController == null) return null;
        } catch (Exception ex){
            ex.printStackTrace();
            return null;
        }
        Curso curso = materiaController.getCurso();
        return materiaImp.listarMateriasCurso(curso.getIdCurso());
    }

    @RequestMapping(value = "/listas/{idCurso}", method = RequestMethod.GET)
    public ResponseMateriaCursoDto listarMateriasCurso(@PathVariable Long idCurso){
        ResponseMateriaCursoDto response = new ResponseMateriaCursoDto();
        try {
            response = materiaImp.listarMateriasCurso(idCurso);
        } catch (Exception ex){
            ex.printStackTrace();
        }
        return response;
    }

    @RequestMapping(value = "/deletes/{idMateria}", method = RequestMethod.GET)
    public ResponseMateriaCursoDto deleteMateria(@PathVariable Long idMateria){
        Curso curso = materiaImp.findById(idMateria).getCurso();
        try{
            boolean eliminada = materiaImp.eliminarMateria(idMateria);
            if(!eliminada) return null;
        } catch (Exception ex){
            ex.printStackTrace();
            return null;
        }
        return materiaImp.listarMateriasCurso(curso.getIdCurso());
    }


}
