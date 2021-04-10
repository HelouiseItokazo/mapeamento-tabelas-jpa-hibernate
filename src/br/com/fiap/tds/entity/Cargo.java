package br.com.fiap.tds.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "T_CARGO")
@SequenceGenerator(name = "cargo", sequenceName="SQ_T_CARGO", allocationSize = 1)
public class Cargo {
	
	@Id
	@Column(name="id_cargo")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cargo")
	private Long id;
	
	@Column(name = "nm_localizacao", length = 50, nullable = false)
	private String nome;

	public Cargo() {}

	public Cargo(String nome) {
		this.nome = nome;
	}

	public Cargo(Long id, String nome) {
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
