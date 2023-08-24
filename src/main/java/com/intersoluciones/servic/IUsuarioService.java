package com.intersoluciones.servic;



import org.springframework.http.ResponseEntity;

import com.intersoluciones.dtos.ResponseDTO;
import com.intersoluciones.dtos.UsuarioDTO;

public interface IUsuarioService {
	


	public ResponseEntity<ResponseDTO> crearUsuarioConDocumentos(UsuarioDTO usuarioDTO);

	

	public ResponseEntity<ResponseDTO> actualizarUsuario(UsuarioDTO usuarioDTO);



	public void eliminarUsuario(Integer id_usuario);
	
	
}

