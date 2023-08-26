package com.intersoluciones.servic;


import org.springframework.http.ResponseEntity;


import com.intersoluciones.dtos.ResponseDTO;
import com.intersoluciones.entities.TipoDocumento;

public interface ITipoDocumentoService {

	 public TipoDocumento crearTipoDocumento(TipoDocumento tipoDocumento);
	 
	 public ResponseEntity<ResponseDTO> consultarTipoDocumento();
	
	}


