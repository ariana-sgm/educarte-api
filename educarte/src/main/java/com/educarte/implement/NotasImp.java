package com.educarte.implement;

import com.educarte.model.Notas;
import com.educarte.service.INotasService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotasImp implements INotasService {
    @Override
    public List<Notas> buscarListaNotas(Long idMateria) {
        return null;
    }

    @Override
    public Notas saveNota(Notas notas) {
        return null;
    }

    @Override
    public Notas actualizarNotas(Notas notas) {
        return null;
    }

    @Override
    public Notas buscarNotas(Long idEstudiante, Long idMateria) {
        return null;
    }
}
