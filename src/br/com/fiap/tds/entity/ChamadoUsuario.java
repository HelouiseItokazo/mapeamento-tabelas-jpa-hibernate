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

/**
 * Esta classe representa uma classe associativa no banco entre T_USUARIO e T_CHAMADO
 * Como existem atributos dentro dela, além das chaves, criamos a classe no java
 */

@Entity
@Table(name = "T_USU_CHAMADO")
@SequenceGenerator(name = "chamadoUsuario", sequenceName="SQ_T_USU_CHAMADO", allocationSize = 1)
public class ChamadoUsuario {
	
	@Id
	@Column(name="id_usu_chamado")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "chamadoUsuario")
	private Long id;
	
	/**
	 * Esta coluna (representada abaixo) foi colocada apenas para representar a modelagem do banco de dados
	 * ao criar os relacionamentos de fato, isso será alterado
	 */
	@Column(name = "id_usuario", nullable = false)
	private Long idUsuario;
	
	/**
	 * Esta coluna (representada abaixo) foi colocada apenas para representar a modelagem do banco de dados
	 * ao criar os relacionamentos de fato, isso será alterado
	 */
	@Column(name = "id_chamado", nullable = false)
	private Long idChamado;
	
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "dt_hr_chamado", updatable = false)
	private Calendar dataEHora;
	
	@Column(name = "id_usuario_solicitado", nullable = false)
	private Long idUsuarioSolicitando;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "ds_nvl_chamado", nullable = false)
	private ChamadoEnum nivelChamado;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "ds_status_chamado", nullable = false)
	private StatusEnum status;

	public ChamadoUsuario() {}

	public ChamadoUsuario(Long idUsuario, Long idChamado, Calendar dataEHora, Long idUsuarioSolicitando,
			ChamadoEnum nivelChamado, StatusEnum status) {
		this.idUsuario = idUsuario;
		this.idChamado = idChamado;
		this.dataEHora = dataEHora;
		this.idUsuarioSolicitando = idUsuarioSolicitando;
		this.nivelChamado = nivelChamado;
		this.status = status;
	}

	public ChamadoUsuario(Long id, Long idUsuario, Long idChamado, Calendar dataEHora, Long idUsuarioSolicitando,
			ChamadoEnum nivelChamado, StatusEnum status) {
		this(idUsuario, idChamado, dataEHora, idUsuarioSolicitando, nivelChamado, status);
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

	public Long getIdChamado() {
		return idChamado;
	}

	public void setIdChamado(Long idChamado) {
		this.idChamado = idChamado;
	}

	public Calendar getDataEHora() {
		return dataEHora;
	}

	public void setDataEHora(Calendar dataEHora) {
		this.dataEHora = dataEHora;
	}

	public Long getIdUsuarioSolicitando() {
		return idUsuarioSolicitando;
	}

	public void setIdUsuarioSolicitando(Long idUsuarioSolicitando) {
		this.idUsuarioSolicitando = idUsuarioSolicitando;
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
