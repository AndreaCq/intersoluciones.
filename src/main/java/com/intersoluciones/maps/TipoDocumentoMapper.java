package com.intersoluciones.maps;



import java.util.List;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

import org.mapstruct.factory.Mappers;

import com.intersoluciones.dtos.TipoDocumentoDTO;
import com.intersoluciones.entities.TipoDocumento;


@Mapper
public interface TipoDocumentoMapper {
	
TipoDocumentoMapper INSTANCE = Mappers.getMapper(TipoDocumentoMapper.class);
	

    TipoDocumentoDTO EntityToDto(TipoDocumento entity);
    
    @InheritInverseConfiguration
    TipoDocumento dtoToEntity(TipoDocumentoDTO dto);
    
    List<TipoDocumentoDTO> beanListToDtoList(List<TipoDocumento>Lista);
    List<TipoDocumento> beanListToEntityList(List<TipoDocumento>Lista);
}


