package com.intersoluciones.maps;

import java.util.List;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import com.intersoluciones.dtos.BancosActivosDTO;
import com.intersoluciones.entities.BancosActivos;


@Mapper
public interface BancosActivosMapper {
	
	
BancosActivosMapper INSTANCE = Mappers.getMapper(BancosActivosMapper.class);
	

    BancosActivosDTO EntityToDto(BancosActivos entity);
    
    @InheritInverseConfiguration
    BancosActivos dtoToEntity(BancosActivosDTO dto);
    
    List<BancosActivosDTO> beanListToDtoList(List<BancosActivos>Lista);
    List<BancosActivos> beanListToEntityList(List<BancosActivos>Lista);

}
