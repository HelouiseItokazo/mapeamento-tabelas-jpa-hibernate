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
@Table(name = "TAB_CHAMADO")
@SequenceGenerator(name = "chamado", sequenceName="SQ_TAB_CHAMADO", allocationSize = 1)
public class Chamado {
	
	@Id
	@Column(name="id_chamado")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "chamado")
	private Integer id;
	
	/**
	 * Esta coluna (representada abaixo) foi colocada apenas para representar a modelagem do banco de dados
	 * ao criar os relacionamentos de fato, isso será alterado
	 */
	@Column(name = "id_ambiente", nullable = false)
	private Integer idAmbiente;
	
	@CreationTimestamp
	@Temporal(TemporalType.DATE)
	@Column(name = "dt_chamado", updatable = false, nullable = false)
	private Calendar data;	
	
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "hr_chamado", updatable = false, nullable = false)
	private Calendar hora;
	
	@Enumerated(EnumType.ORDINAL)
	@Column(name = "nvl_chamado", nullable = false)
	private ChamadoEnum nivelChamado;
	
	@Enumerated(EnumType.ORDINAL)
	@Column(name = "stts_chamado", nullable = false)
	private StatusEnum status;	

	public Chamado() {}

	public Chamado(Integer idAmbiente, Calendar data, Calendar hora, ChamadoEnum nivelChamado, StatusEnum status) {
		this.idAmbiente = idAmbiente;
		this.data = data;
		this.hora = hora;
		this.nivelChamado = nivelChamado;
		this.status = status;
	}

	public Chamado(Integer id, Integer idAmbiente, Calendar data, Calendar hora, ChamadoEnum nivelChamado,
			StatusEnum status) {
		this(idAmbiente, data, hora, nivelChamado, status);
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getIdAmbiente() {
		return idAmbiente;
	}

	public void setIdAmbiente(Integer idAmbiente) {
		this.idAmbiente = idAmbiente;
	}

	public Calendar getData() {
		return data;
	}

	public void setData(Calendar data) {
		this.data = data;
	}

	public Calendar getHora() {
		return hora;
	}

	public void setHora(Calendar hora) {
		this.hora = hora;
	}

	public ChamadoEnum getNivelChamado() {
		return nivelChamado;
	}

	public void setNivelChamado(ChamadoEnum nivelChamado) {
		this.nivelChamado = nivelChamado;
	}

	public StatusEnum getStatus() {
		return status;
	}

	public void setStatus(StatusEnum status) {
		this.status = status;
	}
	
}
