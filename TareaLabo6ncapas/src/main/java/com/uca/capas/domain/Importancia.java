package com.uca.capas.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(schema="public", name="importancia")
public class Importancia {
	
	@Id
	@Column(name="c_importancia")
	@NotNull
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer codigoImportancia;
	
	
	@Column(name="s_importancia")
	private String nameImportancia;

	@OneToMany(mappedBy="importancia", fetch=FetchType.EAGER)
	private List<Contribuyente> contribuyentes = new ArrayList<Contribuyente>();


	public List<Contribuyente> getContribuyente() {
		return contribuyentes;
	}



	public void setContribuyente(List<Contribuyente> contribuyentes) {
		this.contribuyentes = contribuyentes;
	}



	public void setCodigoImportancia(Integer codigoImportancia) {
		this.codigoImportancia = codigoImportancia;
	}


	public Integer getCodigoImportancia() {
		return codigoImportancia;
	}

	public void setNameImportancia(String nameImportancia) {
		this.nameImportancia = nameImportancia;
	}


	public String getNameImportancia() {
		return nameImportancia;
	}



	public Importancia(Integer codigoImportancia, String nameImportancia, List<Contribuyente> contribuyentes) {
		super();
		this.codigoImportancia = codigoImportancia;
		this.nameImportancia = nameImportancia;
		this.contribuyentes = contribuyentes;
	}



	public Importancia() {
		super();
		// TODO Auto-generated constructor stub
	}

	

}
