/**
 * @author Gabriel
 * @Description Implementação inicial
 * @Date 16/05/2021
 */

package br.com.fiap.tds.view;

import javax.persistence.EntityManager;

import br.com.fiap.tds.dao.AmbienteDao;
import br.com.fiap.tds.dao.CargoDao;
import br.com.fiap.tds.dao.ChamadoDao;
import br.com.fiap.tds.dao.DispositivoDao;
import br.com.fiap.tds.dao.LoginDao;
import br.com.fiap.tds.dao.SetorDao;
import br.com.fiap.tds.dao.UsuarioDao;
import br.com.fiap.tds.dao.impl.AmbienteDaoImpl;
import br.com.fiap.tds.dao.impl.CargoDaoImpl;
import br.com.fiap.tds.dao.impl.ChamadoDaoImpl;
import br.com.fiap.tds.dao.impl.DispositivoDaoImpl;
import br.com.fiap.tds.dao.impl.LoginDaoImpl;
import br.com.fiap.tds.dao.impl.SetorDaoImpl;
import br.com.fiap.tds.dao.impl.UsuarioDaoImpl;
import br.com.fiap.tds.entity.Ambiente;
import br.com.fiap.tds.entity.Cargo;
import br.com.fiap.tds.entity.Chamado;
import br.com.fiap.tds.entity.Dispositivo;
import br.com.fiap.tds.entity.Login;
import br.com.fiap.tds.entity.Setor;
import br.com.fiap.tds.entity.Usuario;
import br.com.fiap.tds.exception.EntityNotFoundException;
import br.com.fiap.tds.singleton.EntityManagerFactorySingleton;

public class BuscaTeste {
	
	public static void main(String[] args) {
		// Busca de usuários
		
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		
		//Obter daos
		SetorDao setorDao = new SetorDaoImpl(em);
		CargoDao cargoDao = new CargoDaoImpl(em);
		AmbienteDao ambienteDao = new AmbienteDaoImpl(em);
		UsuarioDao usuarioDao = new UsuarioDaoImpl(em);
		LoginDao loginDao = new LoginDaoImpl(em);
		DispositivoDao dispositivoDao = new DispositivoDaoImpl(em);
		ChamadoDao chamadoDao = new ChamadoDaoImpl(em);
		
		
		try {
			
			// Consulta de chamados e usuários
			
			Usuario usuario = usuarioDao.read(1l);
			Chamado chamado = chamadoDao.read(1l);
			
			System.out.println("Chamados do usuário " + usuario.getNome());
			usuario.getChamados().forEach(c -> System.out.println(c.getId() + " " + c.getTipoChamado()));
			
			System.out.println("Usuários do chamado " + chamado.getId());
			chamado.getUsuarios().forEach(u -> System.out.println(u.getId() + " " + u.getNome()));
			
			// Consulta de setor e seus usuários e ambientes
			Setor setor = setorDao.read(1l);
			
			System.out.println("Usuários do setor " + setor.getNome());
			setor.getUsuarios().forEach(u -> System.out.println(u.getId() + " " + u.getNome()));
			
			System.out.println("Ambientes do setor " + setor.getNome());
			setor.getAmbientes().forEach(a -> System.out.println(a.getId() + " " + a.getNome()));
			
			// Consulta de cargo e usuários
			Cargo cargo = cargoDao.read(1l);
			
			System.out.println("Usuários do cargo " + cargo.getNome());
			cargo.getUsuarios().forEach(u -> System.out.println(u.getId() + " " + u.getNome()));
			
			// Exibindo usuário relacionadoa a um login
			
			Login login = loginDao.read(1l);
			
			System.out.println("Usuário do login " + login.getEmail());
			System.out.println(login.getUsuario().getNome());
			
			// Exibe setor de um ambiente
			
			Ambiente ambiente = ambienteDao.read(1l);
			
			System.out.println("Setor do ambiente " + ambiente.getNome());
			System.out.println(ambiente.getSetor().getNome());
			
			// Exibe dispositivo, se é ligado a um usuário ou ambiente
			
			Dispositivo dispositivo = dispositivoDao.read(1l);
			System.out.println("Dispositivo " + dispositivo.getNome());
			System.out.println(dispositivo.getTipo().toString());
			
		} catch (EntityNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		em.close();
		EntityManagerFactorySingleton.getInstance().createEntityManager().close();
		
	}

}
