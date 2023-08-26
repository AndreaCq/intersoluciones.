package com.intersoluciones.maps;

import java.util.List;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import com.intersoluciones.dtos.DirigidoADTO;
import com.intersoluciones.entities.DirigidoA;

@Mapper
public interface DirigidoAMapper {
	
  DirigidoAMapper INSTANCE = Mappers.getMapper(DirigidoAMapper.class);
	

  DirigidoADTO EntityToDto(DirigidoA entity);
    
    @InheritInverseConfiguration
    DirigidoA dtoToEntity(DirigidoADTO dto);
    
    List<DirigidoADTO> beanListToDtoList(List<DirigidoA>Lista);
    List<DirigidoA> beanListToEntityList(List<DirigidoA>Lista);

}
