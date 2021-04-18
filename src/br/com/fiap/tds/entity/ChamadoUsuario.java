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

/**
 * Esta classe representa uma classe associativa no banco entre T_USUARIO e T_CHAMADO
 * Como existem atributos dentro dela, além das chaves, criamos a classe no java
 */

@Entity
@Table(name = "TAB_USU_CHAMADO")
@SequenceGenerator(name = "chamadoUsuario", sequenceName="SQ_TAB_USU_CHAMADO", allocationSize = 1)
public class ChamadoUsuario {
	
	@Id
	@Column(name="id_usu_chamado")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "chamadoUsuario")
	private Integer id;
	
	/**
	 * Esta coluna (representada abaixo) foi colocada apenas para representar a modelagem do banco de dados
	 * ao criar os relacionamentos de fato, isso será alterado
	 */
	@Column(name = "id_usuario", nullable = false)
	private Integer idUsuario;
	
	/**
	 * Esta coluna (representada abaixo) foi colocada apenas para representar a modelagem do banco de dados
	 * ao criar os relacionamentos de fato, isso será alterado
	 */
	@Column(name = "id_chamado", nullable = false)
	private Integer idChamado;
	
	@CreationTimestamp
	@Temporal(TemporalType.DATE)
	@Column(name = "dt_chamado", updatable = false, nullable = false)
	private Calendar data;	
	
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "hr_chamado", updatable = false, nullable = false)
	private Calendar hora;
	
	@Column(name = "resp_chamado", nullable = false)
	private Integer resposta;

	public ChamadoUsuario() {}

	public ChamadoUsuario(Integer idUsuario, Integer idChamado, Calendar data, Calendar hora, Integer resposta) {
		this.idUsuario = idUsuario;
		this.idChamado = idChamado;
		this.data = data;
		this.hora = hora;
		this.resposta = resposta;
	}

	public ChamadoUsuario(Integer id, Integer idUsuario, Integer idChamado, Calendar data, Calendar hora,
			Integer resposta) {
		this(idUsuario, idChamado, data, hora, resposta);
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}

	public Integer getIdChamado() {
		return idChamado;
	}

	public void setIdChamado(Integer idChamado) {
		this.idChamado = idChamado;
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

	public Integer getResposta() {
		return resposta;
	}

	public void setResposta(Integer resposta) {
		this.resposta = resposta;
	}
	
}
