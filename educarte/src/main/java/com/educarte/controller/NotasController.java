package com.educarte.controller;


import com.educarte.dto.*;
import com.educarte.implement.MateriaImp;
import com.educarte.implement.NotasImp;
import com.educarte.mapping.MappingNotas;
import com.educarte.model.Materia;
import com.educarte.model.Notas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins="*")
@RequestMapping("/api/v1/notas")
public class NotasController {

    @Autowired
    private NotasImp notasImp;

    @Autowired
    private MappingNotas mappingNotas;

    @Autowired
    private MateriaImp materiaImp;

    @RequestMapping(method = RequestMethod.POST)
    public RespInfoNotasMatDto saveNotas(@RequestBody ReqNotasDto reqNotasDto){
        ReqNotasDto notas = reqNotasDto;
        RespInfoNotasMatDto response = new RespInfoNotasMatDto();
        try {
            Notas notasModel = notasImp.saveNotas(notas);
            response = mappingNotas.transformarNotasResponseInfoMatDto(notasModel);
        } catch (Exception ex){
            ex.printStackTrace();
        }
        return response;
    }

    @RequestMapping(value = "/listas/{idCurso}", method = RequestMethod.GET)
    public ResponseMateriasNotasMateriaDto listarMateriasConNotas (@PathVariable Long idCurso){
        ResponseMateriasNotasMateriaDto response = new ResponseMateriasNotasMateriaDto();
        List<ResponseNotasMateriaDto> listaNotasMateria = new ArrayList<>();
        List<Materia> listaMaterias = materiaImp.findByIdCurso(idCurso);
        for (Materia materia : listaMaterias){
            List<RespInfoNotasMatDto> listaNotas = notasImp.findByIdMateria(materia.getIdMateria());
            ResponseNotasMateriaDto notasMateria = new ResponseNotasMateriaDto();
            notasMateria.setListaNotasMateria(listaNotas);
            listaNotasMateria.add(notasMateria);
        }
        response.setListaMateriasNotasMateria(listaNotasMateria);
        return response;
    }

    @RequestMapping(value = "/actualizar", method = RequestMethod.PUT)
    public ResponseNotasMateriaDto actualizarNotasMateria (@RequestBody List<RespInfoNotasMatDto> listaRequest){
        ResponseNotasMateriaDto response = new ResponseNotasMateriaDto();
        RespInfoNotasMatDto actualizadas = new RespInfoNotasMatDto();
        List <RespInfoNotasMatDto> listaActualizadas = new ArrayList<>();
        try {
            for (RespInfoNotasMatDto reqNotas : listaRequest){
                actualizadas = notasImp.actualizarNotas(reqNotas);

                listaActualizadas.add(actualizadas);
            }
        } catch (Exception ex){
            ex.printStackTrace();
            return null;
        }
        response.setListaNotasMateria(listaActualizadas);
        return response;
    }

    @RequestMapping(value = "/listas/notas/{idEstudiante}", method = RequestMethod.GET)
    public ResponseNotasEstDto listarNotasEstudiante (@PathVariable Long idEstudiante){
        ResponseNotasEstDto response = new ResponseNotasEstDto();
        try{
            response = notasImp.listarNotasEstudiante(idEstudiante);
        } catch (Exception ex){
            ex.printStackTrace();
            return null;
        }
        return response;
    }
}
