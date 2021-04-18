package br.com.fiap.tds.entity;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;

import br.com.fiap.tds.enumeration.ChamadoEnum;
import br.com.fiap.tds.enumeration.StatusEnum;

@Entity
@Table(name = "T_CHAMADO")
@SequenceGenerator(name = "chamado", sequenceName="SQ_T_CHAMADO", allocationSize = 1)
public class Chamado {
	
	@Id
	@Column(name="id_chamado")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "chamado")
	private Long id;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "ds_status_chamado", nullable = false)
	private StatusEnum status;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "ds_nvl_chamado", nullable = false)
	private ChamadoEnum nivelChamado;
	
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "dt_hr_chamado", updatable = false)
	private Calendar dataEHora;	

	public Chamado() {}

	public Chamado(StatusEnum status, ChamadoEnum nivelChamado, Calendar dataEHora) {
		this.status = status;
		this.nivelChamado = nivelChamado;
		this.dataEHora = dataEHora;
	}

	public Chamado(Long id, StatusEnum status, ChamadoEnum nivelChamado, Calendar dataEHora) {
		this(status, nivelChamado, dataEHora);
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public StatusEnum getStatus() {
		return status;
	}

	public void setStatus(StatusEnum status) {
		this.status = status;
	}

	public ChamadoEnum getTipoChamado() {
		return nivelChamado;
	}

	public void setTipoChamado(ChamadoEnum nivelChamado) {
		this.nivelChamado = nivelChamado;
	}

	public Calendar getDataEHora() {
		return dataEHora;
	}

	public void setDataEHora(Calendar dataEHora) {
		this.dataEHora = dataEHora;
	}	
	
}
