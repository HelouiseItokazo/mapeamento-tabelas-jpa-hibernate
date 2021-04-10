package br.com.fiap.tds.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.tds.dao.DispositivoDao;
import br.com.fiap.tds.entity.Dispositivo;

public class DispositivoDaoImpl extends GenericDaoImpl<Dispositivo, Long> implements DispositivoDao{

	public DispositivoDaoImpl(EntityManager em) {
		super(em);
	}

}
