package com.intersoluciones.service.Impl;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.intersoluciones.dtos.PCertificadoDTO;
import com.intersoluciones.dtos.ResponseDTO;
import com.intersoluciones.entities.PCertificado;
import com.intersoluciones.maps.PCertificadoMapper;
import com.intersoluciones.repository.PCertificadoRepository;
import com.intersoluciones.servic.IPCertificadoService;
import com.intersoluciones.utils.Constantes;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class PCertificadoServiceImpl implements IPCertificadoService{
	
	private final PCertificadoRepository pCertificadoRepository;
	
	@Override
	public ResponseEntity<ResponseDTO>consultarPeriodoCertificado() {
		System.out.print("Inicio metodo consultar perido certificado: ");
	    ResponseDTO response = new ResponseDTO();
	    
	    List<PCertificado> tiposPCertificadoList = this.pCertificadoRepository.findAll();
	    List<PCertificadoDTO> tiposPCertificadoDTOList = PCertificadoMapper.INSTANCE.beanListToDtoList(tiposPCertificadoList);
	    
	    response.setMessage(Constantes.CONSULTA_EXITOSAMENTE);
	    response.setStatusCode(HttpStatus.OK.value());
	    response.setObjectresponse(tiposPCertificadoDTOList);
	    
	    System.out.print("Finalizo el metodo consultar periodo certificado : ");
	    return new ResponseEntity<ResponseDTO>(response, HttpStatus.OK);
	}

}
