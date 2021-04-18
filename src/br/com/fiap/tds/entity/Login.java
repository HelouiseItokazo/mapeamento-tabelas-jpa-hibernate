package br.com.fiap.tds.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "T_LOGIN")
@SequenceGenerator(name = "login", sequenceName="SQ_T_LOGIN", allocationSize = 1)
public class Login {
	
	@Id
	@Column(name="id_login")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "login")
	private Long id;
	
	/**
	 * Esta coluna (representada abaixo) foi colocada apenas para representar a modelagem do banco de dados
	 * ao criar os relacionamentos de fato, isso será alterado
	 */
	@Column(name = "id_usuario",  nullable = false)
	private Long idUsuario;
	
	@Column(name = "ds_email", length = 200, nullable = false)
	private String email;
	
	//TODO CRIPTOGRAFAR
	@Column(name = "vl_senha", length = 1500, nullable = false)
	private String senha;

	public Login() {}

	public Login(Long idUsuario, String email, String senha) {
		this.idUsuario = idUsuario;
		this.email = email;
		this.senha = senha;
	}

	public Login(Long id, Long idUsuario, String email, String senha) {
		this(idUsuario, email, senha);
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
}
