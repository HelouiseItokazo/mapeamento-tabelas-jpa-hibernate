package br.com.fiap.tds.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.tds.dao.UsuarioDao;
import br.com.fiap.tds.entity.Usuario;

public class UsuarioDaoImpl extends GenericDaoImpl<Usuario, Long> implements UsuarioDao{

	public UsuarioDaoImpl(EntityManager em) {
		super(em);
	}

}
