package com.intersoluciones.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.intersoluciones.dtos.ResponseDTO;
import com.intersoluciones.dtos.UsuarioDTO;
import com.intersoluciones.service.Impl.UsuarioServiceImpl;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/v1/usuario")
@CrossOrigin
@RequiredArgsConstructor
public class UsuarioController {
	
	private final UsuarioServiceImpl serviceUsuario;



   @PostMapping("/crear-usuario-documento")
   public ResponseEntity<ResponseDTO> crearUsuarioDocumento(@RequestBody UsuarioDTO usuarioDTO) {
       return serviceUsuario.crearUsuarioConDocumentos(usuarioDTO);
}
  
   
   @PutMapping("/actualizar")
   public ResponseEntity<ResponseDTO> actualizarUsuario(@RequestBody UsuarioDTO usuarioDTO ) {   
   	return serviceUsuario.actualizarUsuario(usuarioDTO);
   }
   
   @GetMapping("eliminar/{id}")
   public String eliminarUsuario(@PathVariable Integer id){
	   if(id>0) {
		   serviceUsuario.eliminarUsuario(id);
		
	   }
	   return "Usuario eliminado";
   }
}  












