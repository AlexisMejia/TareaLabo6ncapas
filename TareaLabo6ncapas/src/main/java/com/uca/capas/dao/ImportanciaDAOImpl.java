package com.uca.capas.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.uca.capas.domain.Importancia;

@Repository
public class ImportanciaDAOImpl implements ImportanciaDAO {

	@PersistenceContext(unitName="capas")
	private EntityManager entityManager;
	
	
	
	@Override
	public List<Importancia> finAll() throws DataAccessException {

		StringBuffer sb = new StringBuffer();
		sb.append("select * from public.importancia");
		Query query = entityManager.createNativeQuery(sb.toString(), Importancia.class);
		List<Importancia> resultset = query.getResultList();
		
		return resultset;
	}

}
