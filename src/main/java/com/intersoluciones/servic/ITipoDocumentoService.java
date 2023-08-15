package com.intersoluciones.servic;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import com.intersoluciones.dtos.ResponseDTO;
import com.intersoluciones.dtos.TipoDocumentoDTO;
import com.intersoluciones.entities.TipoDocumento;

public interface ITipoDocumentoService {

	 public TipoDocumento crearTipoDocumento(TipoDocumento tipoDocumento);
	
	}


