/**
 * @author Gabriel
 * @Description Implementação inicial
 * @Date 16/05/2021
 * 
 * @author Gabriel
 * @Description Fechamento de conexões
 * @Date 16/05/2021
 */

package br.com.fiap.tds.view;

import javax.persistence.EntityManager;

import br.com.fiap.tds.dao.AmbienteDao;
import br.com.fiap.tds.dao.impl.AmbienteDaoImpl;
import br.com.fiap.tds.entity.Ambiente;
import br.com.fiap.tds.entity.Setor;
import br.com.fiap.tds.exception.CommitException;
import br.com.fiap.tds.singleton.EntityManagerFactorySingleton;

public class CadastroTeste2 {
	public static void main(String[] args) {
		// Cadastrando ambiente + Setor
		
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		
		//Obter daos
		AmbienteDao ambienteDao = new AmbienteDaoImpl(em);
		
		Setor setor = new Setor("T.I");
		Ambiente ambiente = new Ambiente(setor, "Infra", 5, 5.0, 3.0, "Bloco A");
				
		//Persistindo objetos
		try {
			
			ambienteDao.create(ambiente);
			ambienteDao.commit();
			
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
