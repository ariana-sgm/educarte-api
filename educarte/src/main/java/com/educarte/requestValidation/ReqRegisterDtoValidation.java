package com.educarte.requestValidation;

import com.educarte.dto.ReqRegisterDto;
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
}
