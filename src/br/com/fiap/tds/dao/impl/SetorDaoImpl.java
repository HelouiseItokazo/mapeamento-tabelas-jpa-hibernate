package br.com.fiap.tds.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.tds.dao.SetorDao;
import br.com.fiap.tds.entity.Setor;

public class SetorDaoImpl extends GenericDaoImpl<Setor, Long> implements SetorDao{

	public SetorDaoImpl(EntityManager em) {
		super(em);
	}

}
