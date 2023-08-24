package com.intersoluciones.maps;


import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import com.intersoluciones.dtos.UsuarioDTO;
import com.intersoluciones.entities.Usuario;

@Mapper(uses = TipoDocumentoMapper.class)
public interface UsuarioMapper {

    UsuarioMapper INSTANCE = Mappers.getMapper(UsuarioMapper.class);
    
    UsuarioDTO entityToDto(Usuario usuario);

    @InheritInverseConfiguration
    Usuario dtoToEntity(UsuarioDTO usuarioDTO);

  
}
		
	


