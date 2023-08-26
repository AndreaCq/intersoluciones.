package com.intersoluciones.servic;

import org.springframework.http.ResponseEntity;

import com.intersoluciones.dtos.ResponseDTO;


public interface IPCertificadoService {

	public ResponseEntity<ResponseDTO>consultarPeriodoCertificado();

}
