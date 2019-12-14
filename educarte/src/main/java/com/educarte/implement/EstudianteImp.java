package com.educarte.implement;

import com.educarte.model.Curso;
import com.educarte.model.Estudiante;
import com.educarte.service.IEstudianteService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstudianteImp implements IEstudianteService {
    @Override
    public List<Estudiante> buscarListaEstudiante(Long idCurso) {
        return null;
    }

    @Override
    public Estudiante saveEstudiante(Estudiante estudiante) {
        return null;
    }

    @Override
    public boolean eliminarEstudiante(Long idEstudiante) {
        return false;
    }

    @Override
    public Curso buscarEstudiante(Long idEstudiante) {
        return null;
    }
}
