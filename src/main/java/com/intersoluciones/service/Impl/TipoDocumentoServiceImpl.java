package com.intersoluciones.service.Impl;


import java.util.Date;

import org.springframework.stereotype.Service;
import com.intersoluciones.entities.TipoDocumento;
import com.intersoluciones.repository.TipoDocumentoRepository;
import com.intersoluciones.servic.ITipoDocumentoService;
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



	}



	
