package br.com.fiap.tds.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "TAB_DISPOSITIVO")
@SequenceGenerator(name = "dispositivo", sequenceName="SQ_TAB_DISPOSITIVO", allocationSize = 1)
public class Dispositivo {
	
	@Id
	@Column(name="id_dispositivo")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "dispositivo")
	private Integer id;
	
	/**
	 * Esta coluna (representada abaixo) foi colocada apenas para representar a modelagem do banco de dados
	 * ao criar os relacionamentos de fato, isso será alterado
	 */
	@Column(name = "id_usuario", nullable = false)
	private Integer idUsuario;
	
	@Column(name = "nm_dispositivo", length = 50, nullable = false)
	private String nome;

	public Dispositivo() {}

	public Dispositivo(Integer idUsuario, String nome) {
		this.idUsuario = idUsuario;
		this.nome = nome;
	}

	public Dispositivo(Integer id, Integer idUsuario, String nome) {
		this(idUsuario, nome);
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}	
	
}
