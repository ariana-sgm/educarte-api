package com.educarte.controller;

import com.educarte.dto.*;
import com.educarte.implement.CursoImp;
import com.educarte.implement.EstudianteImp;
import com.educarte.implement.MateriaImp;
import com.educarte.implement.NotasImp;
import com.educarte.mapping.MappingMateria;
import com.educarte.model.Curso;
import com.educarte.model.Estudiante;
import com.educarte.model.Materia;
import com.educarte.model.Profesor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins="*")
@RequestMapping("/api/v1/materias")
public class MateriaController {

    @Autowired
    private MateriaImp materiaImp;

    @Autowired
    private MappingMateria mappingMateria;

    @Autowired
    private NotasImp notasImp;

    @Autowired
    private CursoImp cursoImp;

    @Autowired
    private EstudianteImp estudianteImp;

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
        ResponseMateriaCursoDto response = materiaImp.listarMateriasCurso(curso.getIdCurso());
        ReqNotasDto requestNotas = new ReqNotasDto();
        List<Estudiante> listaEstudiantes = estudianteImp.findByIdCurso(curso.getIdCurso());
        try {
            for (Estudiante estudiante : listaEstudiantes) {
                requestNotas.setIdMateria(materiaController.getIdMateria());
                requestNotas.setIdEstudiante(estudiante.getIdEstudiante());
                notasImp.saveNotas(requestNotas);
            }
        } catch (Exception ex){
            ex.printStackTrace();
        }
        return response;
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
