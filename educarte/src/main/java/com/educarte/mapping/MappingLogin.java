package com.educarte.mapping;

import com.educarte.dto.ResponseLoginDto;
import com.educarte.model.Login;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MappingLogin {

    public ResponseLoginDto transformarLoginToResponseDto(Login login){
        ResponseLoginDto responseLoginDto = new ResponseLoginDto();
        try {
            responseLoginDto.setEmailDto(login.getEmail());
            responseLoginDto.setIdLoginDto(login.getIdLogin());
        } catch (Exception ex){
            ex.printStackTrace();
        }
        return responseLoginDto;
    }

    public Login transformarOptionaLogin(Optional<Login> loginOptional) throws Exception {
        Login login = null;
        try {
            if(loginOptional.isPresent()){
                login = new Login();
                login.setIdLogin(loginOptional.get().getIdLogin());
                login.setPassword(loginOptional.get().getPassword());
                login.setEmail(loginOptional.get().getEmail());
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return login;
    }

}
