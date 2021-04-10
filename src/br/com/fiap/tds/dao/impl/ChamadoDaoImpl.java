package br.com.fiap.tds.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.tds.dao.ChamadoDao;
import br.com.fiap.tds.entity.Chamado;

public class ChamadoDaoImpl extends GenericDaoImpl<Chamado, Long> implements ChamadoDao {

	public ChamadoDaoImpl(EntityManager em) {
		super(em);
	}

}
