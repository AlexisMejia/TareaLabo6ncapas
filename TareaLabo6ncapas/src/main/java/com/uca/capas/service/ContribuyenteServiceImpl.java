package com.uca.capas.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.uca.capas.dao.ContribuyenteDAO;
import com.uca.capas.domain.Contribuyente;

@Service
public class ContribuyenteServiceImpl implements ContribuyenteService {
	
	@Autowired
	ContribuyenteDAO contribuyenteDAO;

	@Override
	@Transactional
	public void save(Contribuyente contribuyente) throws DataAccessException {
		contribuyenteDAO.save(contribuyente);
		
	}

	@Override
	public List<Contribuyente> findAllContribuyente() throws DataAccessException {
		// TODO Auto-generated method stub
		return contribuyenteDAO.findAllContribuyente();
	}

}
