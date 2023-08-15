package com.intersoluciones.maps;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.intersoluciones.dtos.UsuarioDTO;
import com.intersoluciones.entities.Usuario;

@Mapper
public interface UsuarioMapper {
	
UsuarioMapper INSTANCE = Mappers.getMapper(UsuarioMapper.class);
	
/*	UsuarioDTO entityToDto(UsuarioDTO usuario);
	
	@InheritInverseConfiguration
	Usuario dtoToEntity(UsuarioDTO usuario);*/


   @Mapping(target = "documentType", source = "usuario.tipoDocumento.descripcion")
   UsuarioDTO entityToDto(Usuario usuario);

   @InheritInverseConfiguration
   @Mapping(target = "tipoDocumento.descripcion", source = "documentType")
   
 
 Usuario dtoToEntity(UsuarioDTO usuario);
   
}
		
	


