package com.intersoluciones.service.Impl;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.intersoluciones.dtos.ResponseDTO;
import com.intersoluciones.dtos.UsuarioDTO;
import com.intersoluciones.entities.TipoDocumento;
import com.intersoluciones.entities.Usuario;
import com.intersoluciones.maps.UsuarioMapper;
import com.intersoluciones.repository.UsuarioRepository;
import com.intersoluciones.servic.IUsuarioService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class UsuarioServiceImpl implements IUsuarioService {

	private final UsuarioRepository usuarioRepository;

	@Override
	public ResponseEntity<ResponseDTO> crearUsuarioConDocumentos(UsuarioDTO usuarioDTO) {
		log.info("Inicio metodo crearUsuarioConDocumentos: {} ", usuarioDTO);
		// Crear un nuevo objeto Usuario para guardar en la base de datos
		Usuario nuevoUsuario = new Usuario();
		// Establecer las propiedades del usuario a partir de UsuarioDTO
		nuevoUsuario.setNombre(usuarioDTO.getNombre());
		nuevoUsuario.setNo_documento(usuarioDTO.getNo_documento());
		nuevoUsuario.setTelefono(usuarioDTO.getTelefono());
		nuevoUsuario.setCiudad(usuarioDTO.getCiudad());
		nuevoUsuario.setDireccion(usuarioDTO.getDireccion());
		nuevoUsuario.setEmail(usuarioDTO.getEmail());
		nuevoUsuario.setPassword(usuarioDTO.getPassword());
		nuevoUsuario.setActivo(usuarioDTO.getActivo());
		nuevoUsuario.setBloqueado(usuarioDTO.getBloqueado());
		nuevoUsuario.setFechaCreacion(usuarioDTO.getFechaCreacion());
		nuevoUsuario.setFechaModifica(usuarioDTO.getFechaModifica());
		nuevoUsuario.setUsuarioCreacion(usuarioDTO.getUsuarioCreacion());
		nuevoUsuario.setUsuarioModifica(usuarioDTO.getUsuarioModifica());

		nuevoUsuario.setTipoDocumento(TipoDocumento.builder()
				.id_tipo_documento(usuarioDTO.getTipoDocumento().getId_tipo_documento()).build());
		this.usuarioRepository.save(nuevoUsuario);
		// Crear una respuesta indicando que el usuario se creó con éxito
		ResponseDTO response = new ResponseDTO("Usuario creado con éxito junto con los tipos de documento", null, null);

		// Devolver una respuesta exitosa con la respuesta creada
		return ResponseEntity.ok(response);
	}
	
	@Override
	 public ResponseEntity<ResponseDTO> actualizarUsuario(UsuarioDTO usuarioDTO) {
	       
	        // Actualizar los datos del usuario existente con los datos de usuarioDTO
	        usuarioRepository.save(UsuarioMapper.INSTANCE.dtoToEntity(usuarioDTO));

	        ResponseDTO responseDTO = new ResponseDTO("Usuario actualizado con éxito", null, null);
	        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
	     
	}
	
	@Override
	public void eliminarUsuario(Integer id_usuario) {
		this.usuarioRepository.deleteById(id_usuario);
	}

}
