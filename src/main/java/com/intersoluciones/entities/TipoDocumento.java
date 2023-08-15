package com.intersoluciones.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.Where;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "pa_tipo_documento",schema="configuracion")
@EntityListeners(AuditingEntityListener.class)
@Where(clause = "activo = true")


public class TipoDocumento {
	
private static final long serviceVersionUID = 1L;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "id_tipo_documento")
	private Integer id_tipo_documento;
	
	@Basic(optional = false)
	@Column(name = "codigo")
	private String codigo;

	@Basic(optional = false)
	@Column(name = "descripcion")
	private String descripcion;


	@Basic(optional = true)
	@Column(name = "usuario_creacion", insertable = true, updatable = false)
	private String usuarioCreacion;

	@Basic(optional = true)
	@Column(name = "fecha_creacion", insertable = true, updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	@CreatedDate
	private Date fechaCreacion;

	@Basic(optional = true)
	@Column(name = "usuario_modificacion",updatable = true, insertable = false )
	private String usuarioModificacion;

	@Basic(optional = true)
	@Column(name = "fecha_modificacion",updatable = true, insertable = false)
	@Temporal(TemporalType.TIMESTAMP)
	@LastModifiedDate
	private Date fechaModificacion;

	@Basic(optional = true)
	@Column(name = "activo", insertable = true, updatable = true)
	private Boolean activo;
	
	 @ManyToOne
	 @JoinColumn(name = "id_usuario")
	 private Usuario usuario;
	}

	
	
	

	


