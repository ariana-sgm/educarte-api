package com.educarte.implement;

import com.educarte.dto.ReqLoginDto;
import com.educarte.dto.ResponseLoginDto;
import com.educarte.dto.ResponseProfesorDto;
import com.educarte.mapping.MappingLogin;
import com.educarte.model.Login;
import com.educarte.repository.LoginRepository;
import com.educarte.service.ILoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//Servicio que sera llamado desde el controller
@Service
public class LoginImp implements ILoginService {

    //Evita hacer instancia
    @Autowired
    private LoginRepository loginRepository;

    @Autowired
    private MappingLogin mappingLogin;

    @Autowired
    ProfesorImp profesorImp;

    @Override
    public ResponseLoginDto saveLogin(ReqLoginDto login) {
        ResponseLoginDto responseLoginDto;
        Login loginLocal = new Login();
        loginLocal.setEmail(login.getEmailDto());
        loginLocal.setPassword(login.getPasswordDto());
        try{

            loginLocal = loginRepository.save(loginLocal);
        } catch (Exception ex){
            ex.printStackTrace();
        }
        responseLoginDto = mappingLogin.transformarLoginToResponseDto(loginLocal);

        return responseLoginDto;
    }

    @Override
    public Login findById(Long id) {
        Login loginLocal = new Login();
        try{
            loginLocal = mappingLogin.transformarOptionaLogin(loginRepository.findById(id));
            if(null == loginLocal){
               return null;
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return loginLocal;
    }

    @Override
    public boolean findByEmail(String email) {
        boolean existUser = false;
        Login loginLocal = null;
        try{
            loginLocal = loginRepository.findByEmail(email);
            if(null != loginLocal){
                existUser = true;
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return existUser;
    }

    @Override
    public ResponseProfesorDto findByEmailAndPassword(String email, String password) {
        ResponseProfesorDto responseProfesorDto = null;
        Login loginLocal = null;
        try{
            loginLocal = loginRepository.findByEmailAndPassword(email, password);
            if(null != loginLocal){
                responseProfesorDto = profesorImp.findByIdLogin(loginLocal);
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return responseProfesorDto;
    }
}
