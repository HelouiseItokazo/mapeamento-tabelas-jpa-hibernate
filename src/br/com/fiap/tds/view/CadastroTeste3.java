/**
 * @author Gabriel
 * @Description Implementação inicial
 * @Date 16/05/2021
 */

package br.com.fiap.tds.view;

import javax.persistence.EntityManager;

import br.com.fiap.tds.dao.LoginDao;
import br.com.fiap.tds.dao.impl.LoginDaoImpl;
import br.com.fiap.tds.entity.Cargo;
import br.com.fiap.tds.entity.Login;
import br.com.fiap.tds.entity.Setor;
import br.com.fiap.tds.entity.Usuario;
import br.com.fiap.tds.exception.CommitException;
import br.com.fiap.tds.singleton.EntityManagerFactorySingleton;

public class CadastroTeste3 {
	public static void main(String[] args) {
		// Inclusão de novo usuário + login + setor + cargo
		
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		
		LoginDao loginDao = new LoginDaoImpl(em);
		
		Setor setor = new Setor("Comercial");
		Cargo cargo = new Cargo("Ger. de vendas");
		Usuario usuario = new Usuario(cargo, setor, "Gabriel");
		Login login = new Login(usuario, "teste@teste", "senha");
		
		//Persistindo objetos
		try {
			
			loginDao.create(login);
			loginDao.commit();
			
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
