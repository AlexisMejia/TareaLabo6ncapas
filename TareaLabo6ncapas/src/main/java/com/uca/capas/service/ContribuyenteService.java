package com.uca.capas.service;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.uca.capas.domain.Contribuyente;

public interface ContribuyenteService {

	public void save(Contribuyente contribuyente) throws DataAccessException;

	public List<Contribuyente> findAllContribuyente() throws DataAccessException;
}
