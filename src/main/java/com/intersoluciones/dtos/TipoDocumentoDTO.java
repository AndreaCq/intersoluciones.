package com.intersoluciones.dtos;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TipoDocumentoDTO {
	
	private Integer id_tipo_documento;
	private String codigo;
	private String descripcion;
	private String usuarioCreacion;
	private Date fechaCreacion;
	private String usuarioModificacion;
	private Date fechaModificacion;
	private Boolean activo;


}
