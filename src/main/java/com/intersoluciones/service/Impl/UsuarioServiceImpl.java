package com.intersoluciones.service.Impl;




import java.util.Optional;



import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.intersoluciones.dtos.ResponseDTO;
import com.intersoluciones.dtos.UsuarioDTO;
import com.intersoluciones.entities.TipoDocumento;
import com.intersoluciones.entities.Usuario;
import com.intersoluciones.maps.UsuarioMapper;
import com.intersoluciones.repository.TipoDocumentoRepository;
import com.intersoluciones.repository.UsuarioRepository;
import com.intersoluciones.servic.IUsuarioService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;


@Service
@RequiredArgsConstructor
@Slf4j
public class UsuarioServiceImpl implements IUsuarioService{
	
	private final UsuarioRepository usuarioRepository;
	
	
	@Override
	public ResponseEntity<ResponseDTO> crearUsuario(UsuarioDTO usuarioDTO) {
		Usuario usuario = UsuarioMapper.INSTANCE.dtoToEntity(usuarioDTO);
		usuario = usuarioRepository.save(usuario);
		ResponseDTO responseDTO =new ResponseDTO(HttpStatus.CREATED.name(),HttpStatus.CREATED.value(),usuario);
		return new ResponseEntity<>(responseDTO,HttpStatus.CREATED);
		
		
	}
	@Override
	public ResponseEntity<ResponseDTO> actualizarUsuario(Integer id_usuario, UsuarioDTO usuarioDTO) {
	    System.out.println("inicio metodo" + id_usuario);
	 // Buscar el usuario en la base de datos por su ID
	    Optional<Usuario> optionalUsuario = usuarioRepository.findById(id_usuario);
         
	    // Verificar si el usuario existe en la base de datos
	    if (optionalUsuario.isPresent()) {
	    	
	    	// Obtener el usuario existente de la Optional
	        Usuario existingUsuario = optionalUsuario.get();

	        // Validar y aplicar cambios del usuarioDTO al existingUsuario
	        if (usuarioDTO.getNombre() != null) {
	            existingUsuario.setNombre(usuarioDTO.getNombre());
	        }
	        if (usuarioDTO.getNo_documento() != null) {
	            existingUsuario.setNo_documento(usuarioDTO.getNo_documento());
	        }
	        

	        // Guardar el existingUsuario actualizado
	        try {
	            Usuario updatedUsuario = usuarioRepository.save(existingUsuario);
	            ResponseDTO responseDTO = new ResponseDTO("Usuario actualizado con éxito", id_usuario, updatedUsuario);
	            return new ResponseEntity<>(responseDTO, HttpStatus.OK);
	        } catch (Exception e) {
	            ResponseDTO responseDTO = new ResponseDTO("Error al actualizar el usuario", null, null);
	            return new ResponseEntity<>(responseDTO, HttpStatus.INTERNAL_SERVER_ERROR);
	        }
	    } else {
	        ResponseDTO responseDTO = new ResponseDTO("Usuario no encontrado", 404, null);
	        return new ResponseEntity<>(responseDTO, HttpStatus.NOT_FOUND);
	    }
	}
	
	
	
	
	@Override
	public ResponseEntity<ResponseDTO> eliminarUsuario(Integer id_usuario) {
	    // Buscar el usuario por su ID
	    Optional<Usuario> optionalUsuario = usuarioRepository.findById(id_usuario);
	    
	    // Imprimir información 
	    System.out.println("Inicio del método para eliminar usuario con ID: " + id_usuario);

	    // Verificar si el usuario no está presente en la base de datos
	    if (!optionalUsuario.isPresent()) {
	        // Crear una respuesta de error y devolverla con el estado HTTP 404 (No encontrado)
	        ResponseDTO responseDTO = new ResponseDTO(HttpStatus.NOT_FOUND.name(), HttpStatus.NOT_FOUND.value(), "Usuario no encontrado para eliminar");
	        return new ResponseEntity<>(responseDTO, HttpStatus.NOT_FOUND);
	    }

	    // El usuario existe en la base de datos, obtenemos el objeto Usuario
	    Usuario usuario = optionalUsuario.get();

	    try {
	        // Eliminar el usuario por su ID
	        usuarioRepository.deleteById(id_usuario);

	        // Crear una respuesta exitosa y devolverla con el estado HTTP 200 (OK)
	        ResponseDTO responseDTO = new ResponseDTO(HttpStatus.OK.name(), HttpStatus.OK.value(), "Usuario eliminado");
	        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
	    } catch (Exception e) {
	        // Crear una respuesta de error en caso de excepción al eliminar
	        ResponseDTO responseDTO = new ResponseDTO("Error al eliminar el usuario", null, null);
	        return new ResponseEntity<>(responseDTO, HttpStatus.INTERNAL_SERVER_ERROR);
	    }

	 }
	@Override
	public ResponseEntity<ResponseDTO> crearUsuarioConDocumentos(UsuarioDTO usuarioDTO) {
		log.info("Inicio metodo crearUsuarioConDocumentos: {} " , usuarioDTO);
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
        
        nuevoUsuario.setTipoDocumento(TipoDocumento.builder().id_tipo_documento(usuarioDTO.getTipoDocumento().getId_tipo_documento()).build());
        this.usuarioRepository.save(nuevoUsuario);
     // Crear una respuesta indicando que el usuario se creó con éxito
        ResponseDTO response = new ResponseDTO("Usuario creado con éxito junto con los tipos de documento", null, null);

        // Devolver una respuesta exitosa con la respuesta creada
        return ResponseEntity.ok(response);
		
	}
		
	 }

	
	
	    
	    
	
	

		  
  
	
	
	

	
	
 
	
	
	
 
	 

	

	    
  