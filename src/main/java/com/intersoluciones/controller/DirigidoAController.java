package com.intersoluciones.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.intersoluciones.service.Impl.DirigidoAServiceImpl;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/v1/dirigido_a")
@CrossOrigin
@RequiredArgsConstructor
public class DirigidoAController {
	
	private final DirigidoAServiceImpl dirigidoAService;

}
