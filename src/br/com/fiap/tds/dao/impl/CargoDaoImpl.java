package br.com.fiap.tds.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.tds.dao.CargoDao;
import br.com.fiap.tds.entity.Cargo;

public class CargoDaoImpl extends GenericDaoImpl<Cargo, Long> implements CargoDao{

	public CargoDaoImpl(EntityManager em) {
		super(em);
	}

}
