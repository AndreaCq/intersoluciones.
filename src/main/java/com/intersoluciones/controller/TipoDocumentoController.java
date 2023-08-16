package com.intersoluciones.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.intersoluciones.dtos.ResponseDTO;
import com.intersoluciones.dtos.TipoDocumentoDTO;
import com.intersoluciones.entities.TipoDocumento;
import com.intersoluciones.servic.ITipoDocumentoService;
import com.intersoluciones.service.Impl.TipoDocumentoServiceImpl;
import com.intersoluciones.service.Impl.UsuarioServiceImpl;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/v1/tipo_documento")
@CrossOrigin
@RequiredArgsConstructor
public class TipoDocumentoController {
	
	private final TipoDocumentoServiceImpl tipodocumentoService;
	
	
	 @PostMapping
	    public ResponseEntity<TipoDocumento> crearTipoDocumento(@RequestBody TipoDocumento tipoDocumento) {
	        TipoDocumento nuevoTipoDocumento = tipodocumentoService.crearTipoDocumento(tipoDocumento);
	        return new ResponseEntity<>(nuevoTipoDocumento, HttpStatus.CREATED);
	

}
}




