package com.intersoluciones.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.intersoluciones.dtos.ResponseDTO;
import com.intersoluciones.service.Impl.BancosActivosServiceImpl;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/v1/bancos")
@CrossOrigin
@RequiredArgsConstructor
public class BancosActivosController {
	
	private final BancosActivosServiceImpl bancosActivosService;
	
	@GetMapping
	public ResponseEntity<ResponseDTO>consultarPeriodoCertificado(){
		return this.bancosActivosService.ConsutarBancosActivos();

}
}
