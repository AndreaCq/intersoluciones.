package com.intersoluciones.service.Impl;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.intersoluciones.dtos.BancosActivosDTO;
import com.intersoluciones.dtos.PCertificadoDTO;
import com.intersoluciones.dtos.ResponseDTO;
import com.intersoluciones.entities.BancosActivos;
import com.intersoluciones.entities.PCertificado;
import com.intersoluciones.maps.BancosActivosMapper;
import com.intersoluciones.maps.PCertificadoMapper;
import com.intersoluciones.repository.BancosActivosRepository;
import com.intersoluciones.servic.IBancosActivosService;
import com.intersoluciones.utils.Constantes;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class BancosActivosServiceImpl implements IBancosActivosService{
	
	private final BancosActivosRepository bancosActivosRepository;

	@Override
	public ResponseEntity<ResponseDTO> ConsutarBancosActivos() {
		System.out.print("Inicio metodo consultar bancos activos: ");
	    ResponseDTO response = new ResponseDTO();
	    
	    List<BancosActivos> tiposBancosActivosList = this.bancosActivosRepository.findAll();
	    List<BancosActivosDTO> tiposBancosActivosDTOList = BancosActivosMapper.INSTANCE.beanListToDtoList(tiposBancosActivosList);
	    
	    response.setMessage(Constantes.CONSULTA_EXITOSAMENTE);
	    response.setStatusCode(HttpStatus.OK.value());
	    response.setObjectresponse(tiposBancosActivosDTOList);
	    
	    System.out.print("Finalizo el metodo consultar periodo certificado : ");
	    return new ResponseEntity<ResponseDTO>(response, HttpStatus.OK);
		
	}

}
