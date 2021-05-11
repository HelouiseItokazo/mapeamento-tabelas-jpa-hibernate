/** MANUTENÇÃO DE FONTE
 * @author Gabriel
 * @Description Implementação dos relacionamentos
 * @Date 11/05/2021
 */

package br.com.fiap.tds.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "T_SETOR")
@SequenceGenerator(name = "setor", sequenceName="SQ_T_SETOR", allocationSize = 1)
public class Setor {
	
	@Id
	@Column(name="id_setor")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "setor")
	private Long id;
	
	@Column(name = "nm_setor", length = 50, nullable = false)
	private String nome;
	
	@OneToMany(mappedBy = "setor", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
	private List<Ambiente> ambientes;
	
	@OneToMany(mappedBy = "setor", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
	private List<Usuario> usuarios;
	
	public void addUsuario(Usuario usuario) {
		if (usuarios == null)
			this.usuarios = new ArrayList<Usuario>();
		
		usuario.setSetor(this);
		usuarios.add(usuario);
	}
	
	public void addAmbiente(Ambiente ambiente) {
		if (ambientes == null)
			this.ambientes = new ArrayList<Ambiente>();
		
		ambiente.setSetor(this);
		ambientes.add(ambiente);
	}
	
	public Setor() {}

	public Setor(String nome) {
		this.nome = nome;
	}

	public Setor(Long id, String nome) {
		this(nome);
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
