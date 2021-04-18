package br.com.fiap.tds.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.tds.dao.AmbienteDao;
import br.com.fiap.tds.entity.Ambiente;

public class AmbienteDaoImpl extends GenericDaoImpl<Ambiente, Long> implements AmbienteDao{

	public AmbienteDaoImpl(EntityManager em) {
		super(em);
	}

}
