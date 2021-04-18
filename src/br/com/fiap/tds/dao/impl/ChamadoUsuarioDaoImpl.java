package br.com.fiap.tds.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.tds.dao.ChamadoUsuarioDao;
import br.com.fiap.tds.entity.ChamadoUsuario;

public class ChamadoUsuarioDaoImpl extends GenericDaoImpl<ChamadoUsuario, Long> implements ChamadoUsuarioDao {

	public ChamadoUsuarioDaoImpl(EntityManager em) {
		super(em);
	}

}
