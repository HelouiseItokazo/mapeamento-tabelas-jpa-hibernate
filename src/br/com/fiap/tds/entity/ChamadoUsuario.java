/** MANUTENÇÃO DE FONTE
 * @author Gabriel
 * @Description Implementação dos relacionamentos
 * @Date 11/05/2021
 */

package br.com.fiap.tds.entity;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
	
	@ManyToOne
	@JoinColumn(name = "id_usuario", nullable = false)
	private Usuario usuario;
	
	@ManyToOne
	@JoinColumn(name = "id_chamado", nullable = false)
	private Chamado chamado;
	
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "dt_hr_chamado", updatable = false)
	private Calendar dataEHora;
	
	@Column(name = "id_usuario_solicitado", nullable = false)
	private Long idUsuarioSolicitado;

	public ChamadoUsuario() {}

	public ChamadoUsuario(Usuario usuario, Chamado chamado, Calendar dataEHora, Long idUsuarioSolicitado) {
		this.usuario = usuario;
		this.chamado = chamado;
		this.dataEHora = dataEHora;
		this.idUsuarioSolicitado = idUsuarioSolicitado;
	}

	public ChamadoUsuario(Long id, Usuario usuario, Chamado chamado, Calendar dataEHora, Long idUsuarioSolicitando) {
		this(usuario, chamado, dataEHora, idUsuarioSolicitando);
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Chamado getChamado() {
		return chamado;
	}

	public void setChamado(Chamado chamado) {
		this.chamado = chamado;
	}

	public Calendar getDataEHora() {
		return dataEHora;
	}

	public void setDataEHora(Calendar dataEHora) {
		this.dataEHora = dataEHora;
	}

	public Long getIdUsuarioSolicitado() {
		return idUsuarioSolicitado;
	}

	public void setIdUsuarioSolicitado(Long idUsuarioSolicitando) {
		this.idUsuarioSolicitado = idUsuarioSolicitando;
	}
	
}
