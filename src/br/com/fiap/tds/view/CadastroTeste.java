/** MANUTENÇÃO DE FONTE
 * @author Gabriel
 * @Description Implementação dos relacionamentos
 * @Date 11/05/2021
 */

package br.com.fiap.tds.view;

import java.util.Calendar;

import javax.persistence.EntityManager;

import br.com.fiap.tds.dao.AmbienteDao;
import br.com.fiap.tds.dao.CargoDao;
import br.com.fiap.tds.dao.ChamadoDao;
import br.com.fiap.tds.dao.ChamadoUsuarioDao;
import br.com.fiap.tds.dao.DispositivoDao;
import br.com.fiap.tds.dao.LoginDao;
import br.com.fiap.tds.dao.SetorDao;
import br.com.fiap.tds.dao.UsuarioDao;
import br.com.fiap.tds.dao.impl.AmbienteDaoImpl;
import br.com.fiap.tds.dao.impl.CargoDaoImpl;
import br.com.fiap.tds.dao.impl.ChamadoDaoImpl;
import br.com.fiap.tds.dao.impl.ChamadoUsuarioDaoImpl;
import br.com.fiap.tds.dao.impl.DispositivoDaoImpl;
import br.com.fiap.tds.dao.impl.LoginDaoImpl;
import br.com.fiap.tds.dao.impl.SetorDaoImpl;
import br.com.fiap.tds.dao.impl.UsuarioDaoImpl;
import br.com.fiap.tds.entity.Ambiente;
import br.com.fiap.tds.entity.Cargo;
import br.com.fiap.tds.entity.Chamado;
import br.com.fiap.tds.entity.ChamadoUsuario;
import br.com.fiap.tds.entity.Dispositivo;
import br.com.fiap.tds.entity.Login;
import br.com.fiap.tds.entity.Setor;
import br.com.fiap.tds.entity.Usuario;
import br.com.fiap.tds.enumeration.ChamadoEnum;
import br.com.fiap.tds.enumeration.StatusEnum;
import br.com.fiap.tds.exception.CommitException;
import br.com.fiap.tds.singleton.EntityManagerFactorySingleton;

public class CadastroTeste {

	public static void main(String[] args) {
		
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		
		//Obter daos
		SetorDao setorDao = new SetorDaoImpl(em);
		CargoDao cargoDao = new CargoDaoImpl(em);
		AmbienteDao ambienteDao = new AmbienteDaoImpl(em);
		UsuarioDao usuarioDao = new UsuarioDaoImpl(em);
		LoginDao loginDao = new LoginDaoImpl(em);
		DispositivoDao dispositivoDao = new DispositivoDaoImpl(em);
		ChamadoDao chamadoDao = new ChamadoDaoImpl(em);
		ChamadoUsuarioDao chamadoUsuarioDao = new ChamadoUsuarioDaoImpl(em);
		
		//Instanciar objetos
		Setor setor = new Setor("Recepção");
		Cargo cargo = new Cargo("Recepcionista");
		Ambiente ambiente = new Ambiente(setor, "Recepção", 1, 2.5, 1.0, "Recepção");
		Usuario usuario = new Usuario(cargo, setor, "Thiago");
		Login login = new Login(1l, "thiago2021@gmail.com", "#@123vamoscriptograr^");
		Dispositivo dipositivo = new Dispositivo(usuario, "DeviceWearableDoThiago");
		Chamado chamado = new Chamado(StatusEnum.PENDENTES, ChamadoEnum.EMERGENCIAEXTREMA, Calendar.getInstance());
		ChamadoUsuario chamadoUsuario = new ChamadoUsuario(usuario, chamado, Calendar.getInstance(), 2l);
		
		//Persistindo objetos
		try {
			setorDao.create(setor);
			setorDao.commit();
			
			cargoDao.create(cargo);
			cargoDao.commit();
			
			ambienteDao.create(ambiente);
			ambienteDao.commit();
			
			usuarioDao.create(usuario);
			usuarioDao.commit();
			
			loginDao.create(login);
			loginDao.commit();
			
			dispositivoDao.create(dipositivo);
			dispositivoDao.commit();
			
			chamadoDao.create(chamado);
			chamadoDao.commit();
			
			chamadoUsuarioDao.create(chamadoUsuario);
			chamadoUsuarioDao.commit();
			
			System.out.println("Cadastro(s) efetuados!");
		} catch (CommitException e) {
			System.out.println(e.getMessage());
		} catch (Exception outrasPossiveisExcecoes) {
			System.out.println(outrasPossiveisExcecoes.getMessage());
		}
		
		//fechar
		em.close();
	}

}
