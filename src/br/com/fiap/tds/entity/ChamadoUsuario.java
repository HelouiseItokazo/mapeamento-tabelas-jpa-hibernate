package br.com.fiap.tds.entity;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;


@Entity
@Table(name = "T_USU_CHAMADO")
@SequenceGenerator(name = "chamadoUsuario", sequenceName="SQ_T_USU_CHAMADO", allocationSize = 1)
public class ChamadoUsuario {
	
	@Id
	@Column(name="id_usu_chamado")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "chamadoUsuario")
	private Long id;
	
	@Column(name = "id_usuario", nullable = false)
	private Long idUsuario;
	
	@Column(name = "id_chamado", nullable = false)
	private Long idChamado;
	
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "dt_hr_chamado", updatable = false)
	private Calendar dataEHora;
	
	@Column(name = "id_usuario_solicitado", nullable = false)
	private Long idUsuarioSolicitando;

	public ChamadoUsuario() {}

	public ChamadoUsuario(Long idUsuario, Long idChamado, Calendar dataEHora, Long idUsuarioSolicitando) {
		this.idUsuario = idUsuario;
		this.idChamado = idChamado;
		this.dataEHora = dataEHora;
		this.idUsuarioSolicitando = idUsuarioSolicitando;
	}

	public ChamadoUsuario(Long id, Long idUsuario, Long idChamado, Calendar dataEHora, Long idUsuarioSolicitando) {
		this(idUsuario, idChamado, dataEHora, idUsuarioSolicitando);
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
	
}
