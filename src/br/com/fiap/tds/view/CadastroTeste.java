/** MANUTENÇÃO DE FONTE
 * @author Gabriel
 * @Description Implementação dos relacionamentos
 * @Date 11/05/2021
 * 
 * @author Gabriel
 * @Description Atualização dos relacionamentos para inserir com cascade
 * @Date 16/05/2021
 * 
 * @author Gabriel
 * @Description Fechamento de conexões
 * @Date 16/05/2021
 */

package br.com.fiap.tds.view;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

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
import br.com.fiap.tds.enumeration.ChamadoEnum;
import br.com.fiap.tds.enumeration.StatusEnum;
import br.com.fiap.tds.exception.CommitException;
import br.com.fiap.tds.singleton.EntityManagerFactorySingleton;

public class CadastroTeste {

	public static void main(String[] args) {
		
		// Cadastrando em todas as tabelas em cascata
		
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		
		//Obter daos
		AmbienteDao ambienteDao = new AmbienteDaoImpl(em);
		LoginDao loginDao = new LoginDaoImpl(em);
		DispositivoDao dispositivoDao = new DispositivoDaoImpl(em);
		
		//Instanciar objetos
		Setor setor = new Setor("Recepção");
		Cargo cargo = new Cargo("Recepcionista");
		Ambiente ambiente = new Ambiente(setor, "Recepção", 1, 2.5, 1.0, "Bloco A");
		Usuario usuario = new Usuario(cargo, setor, "Thiago");
		Login login = new Login(usuario, "thiago2021@gmail.com", "#@123vamoscriptograr^");
		Dispositivo dipositivoUsuario = new Dispositivo(usuario, "DeviceWearableDoThiago");
		Dispositivo dipositivoAmbiente = new Dispositivo(ambiente, "DeviceDaRecepção");
		Chamado chamado = new Chamado(StatusEnum.PENDENTES, ChamadoEnum.EMERGENCIAEXTREMA, Calendar.getInstance());
		List<Chamado> chamados = new ArrayList<Chamado>();
		chamados.add(chamado);
		usuario.setChamados(chamados);
			
		//Persistindo objetos
		try {
			
			loginDao.create(login);
			dispositivoDao.create(dipositivoAmbiente);
			dispositivoDao.create(dipositivoUsuario);
			ambienteDao.create(ambiente);
			
			dispositivoDao.commit();
					
			System.out.println("Cadastro(s) efetuados!");
		} catch (CommitException e) {
			System.out.println(e.getMessage());
		} catch (Exception outrasPossiveisExcecoes) {
			System.out.println(outrasPossiveisExcecoes.getMessage());
		}
		
		//fechar
		em.close();
		EntityManagerFactorySingleton.getInstance().createEntityManager().close();
	}

}
