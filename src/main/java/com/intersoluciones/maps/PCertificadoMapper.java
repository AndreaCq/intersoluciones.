package com.intersoluciones.maps;

import java.util.List;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import com.intersoluciones.dtos.PCertificadoDTO;
import com.intersoluciones.entities.PCertificado;


@Mapper
public interface PCertificadoMapper {
	
	PCertificadoMapper INSTANCE = Mappers.getMapper(PCertificadoMapper.class);
	

    PCertificadoDTO EntityToDto(PCertificado entity);
    
    @InheritInverseConfiguration
    PCertificado dtoToEntity(PCertificadoDTO dto);
    
    List<PCertificadoDTO> beanListToDtoList(List<PCertificado>Lista);
    List<PCertificado> beanListToEntityList(List<PCertificado>Lista);

}
