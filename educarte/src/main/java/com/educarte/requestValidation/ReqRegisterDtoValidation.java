package com.educarte.requestValidation;

import com.educarte.dto.ReqRegisterDto;
import com.educarte.dto.ReqRegisterEstudianteDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReqRegisterDtoValidation {
    public boolean isValidReqRegisterDto(ReqRegisterDto reqRegisterDto) {
        if (reqRegisterDto.getPasswordDto() == null || reqRegisterDto.getPasswordDto().isEmpty()) return false;
        if (reqRegisterDto.getEmailDto() == null || reqRegisterDto.getEmailDto().isEmpty()) return false;
        if (reqRegisterDto.getApellidoProfesorDto() == null || reqRegisterDto.getApellidoProfesorDto().isEmpty())
            return false;
        if (reqRegisterDto.getNombreProfesorDto() == null || reqRegisterDto.getNombreProfesorDto().isEmpty())
            return false;

        return true;
    }

    public boolean isValidReqRegisterDto(ReqRegisterEstudianteDto reqRegisterDto) {
        if (reqRegisterDto.getPasswordEstDto() == null || reqRegisterDto.getPasswordEstDto().isEmpty()) return false;
        if (reqRegisterDto.getEmailEstDto() == null || reqRegisterDto.getEmailEstDto().isEmpty()) return false;
        if (reqRegisterDto.getApellidoEstDto() == null || reqRegisterDto.getApellidoEstDto().isEmpty())
            return false;
        if (reqRegisterDto.getNombreEstDto() == null || reqRegisterDto.getNombreEstDto().isEmpty())
            return false;

        return true;
    }
}
