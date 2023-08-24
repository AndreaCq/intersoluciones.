package com.intersoluciones.maps;


import java.util.List;

import org.mapstruct.Mapper;

import org.mapstruct.factory.Mappers;

import com.intersoluciones.dtos.TipoDocumentoDTO;

import com.intersoluciones.entities.TipoDocumento;

@Mapper
public interface TipoDocumentoMapper {
	
TipoDocumentoMapper INSTANCE = Mappers.getMapper(TipoDocumentoMapper.class);
	

TipoDocumentoDTO tipoDocumentoToDTO(TipoDocumento tipoDocumento);



//List<TipoDocumentoDTO> tipoDocumentosToDTO(List<TipoDocumento> tipoDocumentos);

//List<TipoDocumento> dtosToTipoDocumentos(List<TipoDocumentoDTO> tipoDocumentoDTO);
	

    




	
}


