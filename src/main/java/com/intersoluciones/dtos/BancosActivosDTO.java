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
public class BancosActivosDTO {
	
	
	private Integer id_bancos_activos;
	private String codigo;
	private String descripcion;
	private String usuarioCreacion;
	private Date fechaCreacion;
	private String usuarioModifica;
	private Date fechaModifica;
	private Boolean activo;


	

}
