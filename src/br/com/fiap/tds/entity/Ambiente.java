package br.com.fiap.tds.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "TAB_AMBIENTE")
@SequenceGenerator(name = "ambiente", sequenceName="SQ_TAB_AMBIENTE", allocationSize = 1)
public class Ambiente {
	
	@Id
	@Column(name="id_ambiente")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ambiente")
	private Integer id;
	
	@Column(name = "nm_setor", length = 50, nullable = false)
	private String setor;
	
	@Column(name = "nm_ambiente", length = 50, nullable = false)
	private String nome;
	
	@Column(name = "nr_andar", nullable = false)
	private Integer andar;
	
	@Column(name = "nr_tamanho", nullable = false)
	private Double tamanho;
	
	@Column(name = "nr_proximidade", nullable = false)
	private Double numeroProximidade;

	@Column(name = "nm_localizacao", length = 50, nullable = false)
	private String nomeLocalizacao;

	public Ambiente() {}

	

	public Ambiente(String setor, String nome, Integer andar, Double tamanho, Double numeroProximidade,
			String nomeLocalizacao) {
		this.setor = setor;
		this.nome = nome;
		this.andar = andar;
		this.tamanho = tamanho;
		this.numeroProximidade = numeroProximidade;
		this.nomeLocalizacao = nomeLocalizacao;
	}

	

	public Ambiente(Integer id, String setor, String nome, Integer andar, Double tamanho, Double numeroProximidade,
			String nomeLocalizacao) {
		this(setor, nome, andar, tamanho, numeroProximidade, nomeLocalizacao);
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getSetor() {
		return setor;
	}

	public void setSetor(String setor) {
		this.setor = setor;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getAndar() {
		return andar;
	}

	public void setAndar(Integer andar) {
		this.andar = andar;
	}

	public Double getTamanho() {
		return tamanho;
	}

	public void setTamanho(Double tamanho) {
		this.tamanho = tamanho;
	}

	public Double getNumeroProximidade() {
		return numeroProximidade;
	}

	public void setNumeroProximidade(Double numeroProximidade) {
		this.numeroProximidade = numeroProximidade;
	}

	public String getNomeLocalizacao() {
		return nomeLocalizacao;
	}

	public void setNomeLocalizacao(String nomeLocalizacao) {
		this.nomeLocalizacao = nomeLocalizacao;
	}
	
}
