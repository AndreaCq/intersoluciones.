package com.intersoluciones.maps;


import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.intersoluciones.dtos.TipoDocumentoDTO;

import com.intersoluciones.entities.TipoDocumento;

@Mapper
public interface TipoDocumentoMapper {
	
TipoDocumentoMapper INSTANCE = Mappers.getMapper(TipoDocumentoMapper.class);
	

TipoDocumentoDTO tipoDocumentoToDTO(TipoDocumento tipoDocumento);

TipoDocumento dtoToTipoDocumento(TipoDocumentoDTO tipoDocumentoDTO);
	
}


