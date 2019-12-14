package com.educarte.controller;

import com.educarte.dto.ReqLoginDto;
import com.educarte.dto.ReqProfesorDto;
import com.educarte.dto.ReqRegisterDto;
import com.educarte.dto.ResponseLoginDto;
import com.educarte.exception.MyException;
import com.educarte.implement.LoginImp;
import com.educarte.implement.ProfesorImp;
import com.educarte.model.Login;
import com.educarte.model.Profesor;
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

    @RequestMapping(value = "/sessions", method = RequestMethod.POST)
    public boolean validateLogin(@RequestBody ReqLoginDto loginDto){
        boolean loginController = false;
        try {
            loginController = loginImp.findByEmailAndPassword(loginDto.getEmailDto(), loginDto.getPasswordDto());
        } catch (Exception ex){
            ex.printStackTrace();
        }
        return loginController;
    }

    @RequestMapping(value = "/registrations", method = RequestMethod.POST)
    public boolean registration(@RequestBody ReqRegisterDto registerDto) throws MyException{
        if(loginImp.findByEmail(registerDto.getEmailDto()) ){
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
        }


        ReqProfesorDto profesorDto= new ReqProfesorDto();
        profesorDto.setApellidoProfesorDto(registerDto.getApellidoProfesorDto());
        profesorDto.setIdLoginDto(loginLocal.getIdLoginDto());
        profesorDto.setNombreProfesorDto(registerDto.getNombreProfesorDto());
        Profesor profesorLocal = new Profesor();
        try{
            profesorLocal = profesorImp.saveProfesor(profesorDto);
        } catch (Exception ex){
            ex.printStackTrace();
        }
        return true;
    }
}
