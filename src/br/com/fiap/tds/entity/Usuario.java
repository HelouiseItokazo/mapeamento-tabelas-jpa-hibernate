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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "T_USUARIO")
@SequenceGenerator(name = "usuario", sequenceName="SQ_T_USUARIO", allocationSize = 1)
public class Usuario {
	
	@Id
	@Column(name="id_usuario")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "usuario")
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "id_cargo", nullable = false)
	private Cargo cargo;
	
	@ManyToOne
	@JoinColumn(name = "id_setor", nullable = false)
	private Setor setor;
	
	@OneToOne(mappedBy = "usuario", cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
	private Dispositivo dispostivo;
	
	@Column(name = "nm_usuario", length = 100, nullable = false)
	private String nome;
	
	@OneToMany(mappedBy = "usuario", cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
	private List<ChamadoUsuario> chamadosUsuario;
	
	public void addChamadoUsuario(ChamadoUsuario chamado) {
		if (this.chamadosUsuario == null) {
			this.chamadosUsuario = new ArrayList<ChamadoUsuario>();
			
			chamado.setUsuario(this);
			chamadosUsuario.add(chamado);
		}
	}

	public Usuario() {}

	public Usuario(Cargo cargo, Setor setor, String nome) {
		this.cargo = cargo;
		this.setor = setor;
		this.nome = nome;
	}

	public Usuario(Long id, Cargo cargo, Setor setor, String nome) {
		this(cargo, setor, nome);
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

	public Cargo getCargo() {
		return cargo;
	}

	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}

	public Setor getSetor() {
		return setor;
	}

	public void setSetor(Setor setor) {
		this.setor = setor;
	}

	public Dispositivo getDispostivo() {
		return dispostivo;
	}

	public void setDispostivo(Dispositivo dispostivio) {
		this.dispostivo = dispostivio;
	}
	
	

}
