package com.intersoluciones.controller;




import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;

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

@PostMapping("/crear")
    public ResponseEntity<ResponseDTO> crearUsuario(@RequestBody UsuarioDTO usuarioDTO) {
        return serviceUsuario.crearUsuario(usuarioDTO);
    }

@PutMapping("/actualizar/{id}")
public ResponseEntity<ResponseDTO> actualizarUsuario(@PathVariable Integer id, @RequestBody UsuarioDTO usuarioDTO) {
	return serviceUsuario.actualizarUsuario(id, usuarioDTO);
}

   @DeleteMapping("/eliminar/{id_usuario}")
  public ResponseEntity<ResponseDTO> eliminarUsuario(@PathVariable Integer id_usuario) {
  return this.serviceUsuario.eliminarUsuario(id_usuario);
	
}
   @PostMapping("agregar-documentos/{id_usuario}/")
   public ResponseEntity<String> agregarDocumentos(@PathVariable Integer id_usuario) {
      serviceUsuario.agregarDocumentosAUsuario(id_usuario);  
   return ResponseEntity.ok("Documentos agregados correctamente");
}
   @PostMapping("/registrar-con-documento")
   public ResponseEntity<ResponseDTO> registrarUsuarioConDocumento(@RequestBody UsuarioDTO usuarioDTO) {
	   return serviceUsuario.registrarUsuarioConDocumento(usuarioDTO);
	       }
}











