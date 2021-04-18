package br.com.fiap.tds.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "TAB_USUARIO")
@SequenceGenerator(name = "usuario", sequenceName="SQ_TAB_USUARIO", allocationSize = 1)
public class Usuario {
	
	@Id
	@Column(name="id_usuario")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "usuario")
	private Integer id;
	
	/**
	 * Esta coluna (representada abaixo) foi colocada apenas para representar a modelagem do banco de dados
	 * ao criar os relacionamentos de fato, isso será alterado
	 */
	@Column(name = "id_dispositivo", nullable = false)
	private Integer idDispositivo;
	
	/**
	 * Esta coluna (representada abaixo) foi colocada apenas para representar a modelagem do banco de dados
	 * ao criar os relacionamentos de fato, isso será alterado
	 */
	@Column(name = "id_usuario_site", nullable = false)
	private Integer idSetorusuarioSite;
	
	@Column(name = "nm_usuario", length = 50, nullable = false)
	private String nome;
	
	@Column(name = "ds_funcao", length = 80, nullable = false)
	private String funcao;
	
	@Column(name = "nm_setor", length = 50, nullable = false)
	private String setor;

	public Usuario() {}

	public Usuario(Integer idDispositivo, Integer idSetorusuarioSite, String nome, String funcao, String setor) {
		this.idDispositivo = idDispositivo;
		this.idSetorusuarioSite = idSetorusuarioSite;
		this.nome = nome;
		this.funcao = funcao;
		this.setor = setor;
	}

	public Usuario(Integer id, Integer idDispositivo, Integer idSetorusuarioSite, String nome, String funcao,
			String setor) {
		this(idDispositivo, idSetorusuarioSite, nome, funcao, setor);
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getIdDispositivo() {
		return idDispositivo;
	}

	public void setIdDispositivo(Integer idDispositivo) {
		this.idDispositivo = idDispositivo;
	}

	public Integer getIdSetorusuarioSite() {
		return idSetorusuarioSite;
	}

	public void setIdSetorusuarioSite(Integer idSetorusuarioSite) {
		this.idSetorusuarioSite = idSetorusuarioSite;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getFuncao() {
		return funcao;
	}

	public void setFuncao(String funcao) {
		this.funcao = funcao;
	}

	public String getSetor() {
		return setor;
	}

	public void setSetor(String setor) {
		this.setor = setor;
	}	

}
