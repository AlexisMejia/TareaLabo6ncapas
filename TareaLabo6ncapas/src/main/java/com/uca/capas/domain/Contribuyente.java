package com.uca.capas.domain;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;


@Entity
@Table(schema="public", name="contribuyente")
public class Contribuyente {
	
	
	@Id
	@Column(name="c_contribuyente")
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Integer codigoContribuyente;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="c_importancia")
	private Importancia importancia;
	
	@Size(max=30, message="El campo no debe contener mas de 30 caracteres")
	@NotEmpty(message="*Campo Obligatorio*")
	@Column(name="s_nombre")
	private String nombreContribuyente;
	
	@Size(max=30, message="El campo no debe contener mas de 30 caracteres")
	@NotEmpty(message="*Campo Obligatorio*")
	@Column(name="s_apellido")
	private String apellidoContribuyente;
	
	@Size(max=14, message="El campo no debe contener mas de 14 caracteres")
	@NotEmpty(message="*Campo Obligatorio*")
	@Column(name="s_nit")
	private String nitContribuyente;
	

	@Column(name="f_fecha_ingreso")
	private LocalDate fIngreso;

	
	


	public Contribuyente(Integer codigoContribuyente, String nombreContribuyente, String apellidoContribuyente, String nitContribuyente,LocalDate fIngreso) {
		super();
		this.codigoContribuyente = codigoContribuyente;
		this.nombreContribuyente = nombreContribuyente;
		this.apellidoContribuyente = apellidoContribuyente;
		this.nitContribuyente = nitContribuyente;
		this.fIngreso = fIngreso;
	}

	public Importancia getImportancia() {
		return importancia;
	}

	public void setImportancia(Importancia importancia) {
		this.importancia = importancia;
	}

	public Contribuyente() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getCodigoContribuyente() {
		return codigoContribuyente;
	}

	public void setCodigoContribuyente(Integer codigoContribuyente) {
		this.codigoContribuyente = codigoContribuyente;
	}

	public String getNombreContribuyente() {
		return nombreContribuyente;
	}

	public void setNombreContribuyente(String nombreContribuyente) {
		this.nombreContribuyente = nombreContribuyente;
	}

	public String getApellidoContribuyente() {
		return apellidoContribuyente;
	}

	public void setApellidoContribuyente(String apellidoContribuyente) {
		this.apellidoContribuyente = apellidoContribuyente;
	}

	public String getNitContribuyente() {
		return nitContribuyente;
	}

	public void setNitContribuyente(String nitContribuyente) {
		this.nitContribuyente = nitContribuyente;
	}

	public LocalDate getfIngreso() {
		return fIngreso;
	}

	public void setfIngreso(LocalDate fIngreso) {
		this.fIngreso = fIngreso;
	}
	
	
}
