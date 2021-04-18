package br.com.fiap.tds.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "TAB_USUARIO_SITE")
@SequenceGenerator(name = "login", sequenceName="SQ_TAB_USUARIO_SITE", allocationSize = 1)
public class Login {
	
	@Id
	@Column(name="id_usuario_site")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "login")
	private Integer id;
	
	/**
	 * Esta coluna (representada abaixo) foi colocada apenas para representar a modelagem do banco de dados
	 * ao criar os relacionamentos de fato, isso será alterado
	 */
	@Column(name = "id_usuario",  nullable = false)
	private Integer idUsuario;
	
	@Column(name = "ds_email", length = 80, nullable = false, unique = true)
	private String email;
	
	//TODO CRIPTOGRAFAR
	@Column(name = "vl_senha", length = 15, nullable = false)
	private String senha;

	public Login() {}

	public Login(Integer idUsuario, String email, String senha) {
		this.idUsuario = idUsuario;
		this.email = email;
		this.senha = senha;
	}

	public Login(Integer id, Integer idUsuario, String email, String senha) {
		this(idUsuario, email, senha);
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
