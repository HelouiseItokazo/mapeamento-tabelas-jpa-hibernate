package br.com.fiap.tds.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
