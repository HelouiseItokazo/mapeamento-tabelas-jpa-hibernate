package br.com.fiap.tds.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "T_DISPOSITIVO")
@SequenceGenerator(name = "dispositivo", sequenceName="SQ_T_DISPOSITIVO", allocationSize = 1)
public class Dispositivo {
	
	@Id
	@Column(name="id_dispositivo")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "dispositivo")
	private Long id;
	
	@Column(name = "id_usuario")
	private Long idUsuario;
	
	@Column(name = "id_ambiente")
	private Long idAmbiente;
	
	@Column(name = "nm_dispositivo", length = 50, nullable = false)
	private String nome;

	public Dispositivo() {}

	public Dispositivo(Long idUsuario, String nome) {
		this.idUsuario = idUsuario;
		this.nome = nome;
	}

	public Dispositivo(Long id, Long idAmbiente, String nome) {
		this(idAmbiente, nome);
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public Long getIdAmbiente() {
		return idAmbiente;
	}

	public void setIdAmbiente(Long idAmbiente) {
		this.idAmbiente = idAmbiente;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
}
