package com.educarte.implement;

import com.educarte.dto.ReqProfesorDto;
import com.educarte.dto.ResponseProfesorDto;
import com.educarte.mapping.MappingLogin;
import com.educarte.mapping.MappingProfesor;
import com.educarte.model.Login;
import com.educarte.model.Profesor;
import com.educarte.repository.LoginRepository;
import com.educarte.repository.ProfesorRepository;
import com.educarte.service.IProfesorService;
import com.sun.org.apache.regexp.internal.RE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfesorImp implements IProfesorService {

    @Autowired
    private ProfesorRepository profesorRepository;

    @Autowired
    private LoginImp loginImp;

    @Autowired
    private MappingProfesor mappingProfesor;

    @Override
    public ResponseProfesorDto saveProfesor(ReqProfesorDto profesorDto) {
        ResponseProfesorDto response = new ResponseProfesorDto();
        Profesor profesorLocal = new Profesor();
        Profesor provisional = new Profesor();
        try{
            Login login = loginImp.findById(profesorDto.getIdLoginDto());
            provisional.setIdLogin(login);
            provisional.setApellidoProfesor(profesorDto.getApellidoProfesorDto());
            provisional.setNombreProfesor(profesorDto.getNombreProfesorDto());
        } catch (Exception ex){
            ex.printStackTrace();
        }
        try{
            profesorLocal = profesorRepository.save(provisional);
        } catch (Exception ex){
            ex.printStackTrace();
        }
        response = mappingProfesor.transformarProfesorResponseDto(profesorLocal);
        return response;
    }

    @Override
    public Profesor findById(Long idProfesor) {
        Profesor profesor = new Profesor();
        try{
            profesor = mappingProfesor.transformarOptionaProfesor(profesorRepository.findById(idProfesor));
            if(null == profesor){
                return null;
            }
        }catch (Exception ex){
            ex.printStackTrace();
            return null;
        }
        return profesor;
    }

    @Override
    public ResponseProfesorDto findByIdLogin(Login idLogin) {
        ResponseProfesorDto response = new ResponseProfesorDto();
        Profesor profesorLocal = new Profesor();
        try{
            profesorLocal = profesorRepository.findByIdLogin(idLogin);
        }catch(Exception ex){
            ex.printStackTrace();
            return null;
        }
        return response = mappingProfesor.transformarProfesorResponseDto(profesorLocal);
    }
}
