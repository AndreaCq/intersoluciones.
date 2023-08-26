package com.intersoluciones.servic;

import org.springframework.http.ResponseEntity;

import com.intersoluciones.dtos.ResponseDTO;

public interface IBancosActivosService {
	
	public ResponseEntity<ResponseDTO>ConsutarBancosActivos();

}
