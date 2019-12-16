package com.educarte.controller;

import com.educarte.dto.*;
import com.educarte.implement.EstudianteImp;
import com.educarte.implement.LoginImp;
import com.educarte.model.Curso;
import com.educarte.model.Estudiante;
import com.educarte.model.Profesor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins="*")
@RequestMapping("/api/v1/estudiantes")
public class EstudianteController {
    @Autowired
    EstudianteImp estudianteImp;

    @Autowired
    LoginImp loginImp;

    @RequestMapping(value ="/guardados", method = RequestMethod.POST)
    public ResponseEstudianteCursoDto saveEstudiante(@RequestBody ReqEstudianteDto estudianteDto){
        ResponseEstudianteDto estudianteController = new ResponseEstudianteDto();
        try{
            estudianteController = estudianteImp.saveEstudiante(estudianteDto);
            if (estudianteController == null) return null;
        } catch (Exception ex){
            ex.printStackTrace();
            return null;
        }
        return estudianteImp.listarEstudiantesCurso(estudianteController.getIdCurso());
    }

    @RequestMapping(value = "/finds", method = RequestMethod.GET)
    public ResponseEstudianteDto findByIdLogin(@RequestBody ReqLoginDto reqLoginDto) {
        ResponseEstudianteDto responseEstudianteDto = new ResponseEstudianteDto();
        try {
            responseEstudianteDto = loginImp.findEstByEmailAndPassword(reqLoginDto.getEmailDto(), reqLoginDto.getPasswordDto());

        }catch (Exception ex){
            ex.printStackTrace();
        }
        return responseEstudianteDto;
    }

    @RequestMapping(value = "/listas/{idCurso}", method = RequestMethod.GET)
    public ResponseEstudianteCursoDto listarEstudiantesCurso(@PathVariable Long idCurso){
        ResponseEstudianteCursoDto response = new ResponseEstudianteCursoDto();
        try {
            response = estudianteImp.listarEstudiantesCurso(idCurso);
        } catch (Exception ex){
            ex.printStackTrace();
        }
        return response;
    }

    @RequestMapping(value = "/deletes/{idEstudiante}", method = RequestMethod.GET)
    public ResponseEstudianteCursoDto deleteEstudiante(@PathVariable Long idEstudiante){
        Curso curso = estudianteImp.findById(idEstudiante).getCurso();
        try{
            boolean eliminado = estudianteImp.eliminarEstudiante(idEstudiante);
            if (!eliminado) return null;
        } catch (Exception ex){
            ex.printStackTrace();
            return null;
        }
        return estudianteImp.listarEstudiantesCurso(curso.getIdCurso());
    }





}
