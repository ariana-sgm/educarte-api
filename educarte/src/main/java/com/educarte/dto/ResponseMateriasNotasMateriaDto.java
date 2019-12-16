package com.educarte.dto;

import java.util.List;

public class ResponseMateriasNotasMateriaDto {
    private List<ResponseNotasMateriaDto> listaMateriasNotasMateria;

    public List<ResponseNotasMateriaDto> getListaMateriasNotasMateria() {
        return listaMateriasNotasMateria;
    }

    public void setListaMateriasNotasMateria(List<ResponseNotasMateriaDto> listaMateriasNotasMateria) {
        this.listaMateriasNotasMateria = listaMateriasNotasMateria;
    }
}
