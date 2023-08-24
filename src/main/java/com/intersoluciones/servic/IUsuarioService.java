package com.intersoluciones.servic;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.intersoluciones.dtos.ResponseDTO;
import com.intersoluciones.dtos.UsuarioDTO;

public interface IUsuarioService {
	
	public ResponseEntity<ResponseDTO> crearUsuario(UsuarioDTO usuario);
	
	public ResponseEntity<ResponseDTO> actualizarUsuario(Integer id_usuario, UsuarioDTO usuarioDTO);

	public ResponseEntity<ResponseDTO> eliminarUsuario(Integer id_usuario);

	ResponseEntity<ResponseDTO> crearUsuarioConDocumentos(UsuarioDTO usuarioDTO);
	
	
}

