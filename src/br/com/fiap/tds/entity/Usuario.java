package br.com.fiap.tds.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
	
	/**
	 * Esta coluna (representada abaixo) foi colocada apenas para representar a modelagem do banco de dados
	 * ao criar os relacionamentos de fato, isso será alterado
	 */
	@Column(name = "id_cargo", nullable = false)
	private Long idCargo;
	
	/**
	 * Esta coluna (representada abaixo) foi colocada apenas para representar a modelagem do banco de dados
	 * ao criar os relacionamentos de fato, isso será alterado
	 */
	@Column(name = "id_setor", nullable = false)
	private Long idSetor;
	
	@Column(name = "nm_usuario", length = 100, nullable = false)
	private String nome;

	public Usuario() {}

	public Usuario(Long idCargo, Long idSetor, String nome) {
		this.idCargo = idCargo;
		this.idSetor = idSetor;
		this.nome = nome;
	}

	public Usuario(Long id, Long idCargo, Long idSetor, String nome) {
		this(idCargo, idSetor, nome);
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

	public Long getIdCargo() {
		return idCargo;
	}

	public void setIdCargo(Long idCargo) {
		this.idCargo = idCargo;
	}

	public Long getIdSetor() {
		return idSetor;
	}

	public void setIdSetor(Long idSetor) {
		this.idSetor = idSetor;
	}

}
