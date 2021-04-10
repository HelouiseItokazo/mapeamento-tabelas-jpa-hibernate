package br.com.fiap.tds.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "T_AMBIENTE")
@SequenceGenerator(name = "ambiente", sequenceName="SQ_T_AMBIENTE", allocationSize = 1)
public class Ambiente {
	
	@Id
	@Column(name="id_ambiente")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ambiente")
	private Long id;
	
	@Column(name = "id_setor", nullable = false)
	private Long idSetor;
	
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

	public Ambiente(Long idSetor, String nome, Integer andar, Double tamanho, Double numeroProximidade,
			String nomeLocalizacao) {
		this.idSetor = idSetor;
		this.nome = nome;
		this.andar = andar;
		this.tamanho = tamanho;
		this.numeroProximidade = numeroProximidade;
		this.nomeLocalizacao = nomeLocalizacao;
	}
	
	public Ambiente(Long id, Long idSetor, String nome, Integer andar, Double tamanho, Double numeroProximidade,
			String nomeLocalizacao) {
		this(idSetor, nome, andar, tamanho, numeroProximidade, nomeLocalizacao);
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getSetor() {
		return idSetor;
	}

	public void setSetor(Long idSetor) {
		this.idSetor = idSetor;
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
