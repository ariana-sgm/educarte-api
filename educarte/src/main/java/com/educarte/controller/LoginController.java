package com.educarte.controller;

import com.educarte.dto.*;
import com.educarte.exception.MyException;
import com.educarte.implement.LoginImp;
import com.educarte.implement.ProfesorImp;
import com.educarte.model.Login;
import com.educarte.model.Profesor;
import com.educarte.requestValidation.ReqRegisterDtoValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins="*")
@RequestMapping("/api/v1/logins")
public class LoginController {

    @Autowired
    private LoginImp loginImp;

    @Autowired
    private ProfesorImp profesorImp;

    @Autowired
    private ReqRegisterDtoValidation validation;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseLoginDto saveLogin(@RequestBody ReqLoginDto log){
        ResponseLoginDto loginController = new ResponseLoginDto();
        try {
            loginController = loginImp.saveLogin(log);
        } catch (Exception ex){
            ex.printStackTrace();
        }
        return loginController;
    }

    @RequestMapping(value = "/sessions/profesor", method = RequestMethod.POST)
    public ResponseProfesorDto validateLoginProfesor(@RequestBody ReqLoginDto loginDto){
        ResponseProfesorDto loginController = new ResponseProfesorDto();
        try {
            loginController = loginImp.findByEmailAndPassword(loginDto.getEmailDto(), loginDto.getPasswordDto());
        } catch (Exception ex){
            ex.printStackTrace();
            return null;
        }
        return loginController;
    }

    @RequestMapping(value = "/sessions/estudiante", method = RequestMethod.POST)
    public ResponseProfesorDto validateLoginEstudiante(@RequestBody ReqLoginDto loginDto){
        ResponseProfesorDto loginController = new ResponseProfesorDto();
        try {
            loginController = loginImp.findByEmailAndPassword(loginDto.getEmailDto(), loginDto.getPasswordDto());
        } catch (Exception ex){
            ex.printStackTrace();
            return null;
        }
        return loginController;
    }



    @RequestMapping(value = "/registrations", method = RequestMethod.POST)
    public boolean registration(@RequestBody ReqRegisterDto registerDto) throws MyException{
        if(!validation.isValidReqRegisterDto(registerDto)) return false;
        if(loginImp.findByEmail(registerDto.getEmailDto())){
            return false;
        }

        ReqLoginDto loginDto = new ReqLoginDto();
        loginDto.setEmailDto(registerDto.getEmailDto());
        loginDto.setPasswordDto(registerDto.getPasswordDto());
        ResponseLoginDto loginLocal = new ResponseLoginDto();

        try{
            loginLocal = loginImp.saveLogin(loginDto);
        } catch (Exception ex){
            ex.printStackTrace();
            return false;
        }


        ReqProfesorDto profesorDto= new ReqProfesorDto();
        ResponseProfesorDto response = new ResponseProfesorDto();
        profesorDto.setApellidoProfesorDto(registerDto.getApellidoProfesorDto());
        profesorDto.setIdLoginDto(loginLocal.getIdLoginDto());
        profesorDto.setNombreProfesorDto(registerDto.getNombreProfesorDto());
        try{
            response = profesorImp.saveProfesor(profesorDto);

        } catch (Exception ex){
            ex.printStackTrace();
            return false;
        }
        return true;
    }
}
