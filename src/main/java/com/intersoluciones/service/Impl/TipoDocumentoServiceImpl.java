package com.intersoluciones.service.Impl;


import java.util.Date;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.intersoluciones.dtos.PCertificadoDTO;
import com.intersoluciones.dtos.ResponseDTO;
import com.intersoluciones.dtos.TipoDocumentoDTO;
import com.intersoluciones.entities.PCertificado;
import com.intersoluciones.entities.TipoDocumento;
import com.intersoluciones.maps.PCertificadoMapper;
import com.intersoluciones.maps.TipoDocumentoMapper;
import com.intersoluciones.repository.TipoDocumentoRepository;
import com.intersoluciones.servic.ITipoDocumentoService;
import com.intersoluciones.utils.Constantes;

import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class TipoDocumentoServiceImpl implements ITipoDocumentoService{
	
	private final TipoDocumentoRepository tipodocumentoRepository;


public TipoDocumento crearTipoDocumento(TipoDocumento tipoDocumento) {
    // Establecer la fecha y usuario de creación
    tipoDocumento.setFechaCreacion(new Date());
    tipoDocumento.setUsuarioCreacion("usuario"); // Reemplaza "usuario" con el nombre del usuario actual

    // Establecer como activo por defecto si no se proporciona
    if (tipoDocumento.getActivo() == null) {
        tipoDocumento.setActivo(true);
    }

    return tipodocumentoRepository.save(tipoDocumento);
		
	}

	@Override
	public ResponseEntity<ResponseDTO> consultarTipoDocumento() {
	    System.out.print("Inicio metodo consultarTipoDocumento: ");
	    ResponseDTO response = new ResponseDTO();
	    
	    List<TipoDocumento> tiposTipoDocumentoList = this.tipodocumentoRepository.findAll();
	    List<TipoDocumentoDTO> tiposTipoDocumentoDTOList = TipoDocumentoMapper.INSTANCE.beanListToDtoList(tiposTipoDocumentoList);
	    
	    response.setMessage(Constantes.CONSULTA_EXITOSAMENTE);
	    response.setStatusCode(HttpStatus.OK.value());
	    response.setObjectresponse(tiposTipoDocumentoDTOList);
	    
	    System.out.print("Finalizo el metodo consultarTipoDocumento: ");
	    return new ResponseEntity<ResponseDTO>(response, HttpStatus.OK);
	}
	
}



	



	
