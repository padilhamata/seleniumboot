package com.umuarama.questionario.models;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.sun.istack.internal.NotNull;

import lombok.Data;
@Data
@Entity
@Table(name = "pesquisamicrosolt")
public class PesquisaMicrosolt implements Serializable 
{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
 private long id;
 private Date horainicio;
 private Date horaconclusao;
 private String email;
 private String nome;
 private String veiculo;
 private String concessionaria;
 private Date data;
 private Long os;
 private String reclamacao;
 private String consultor;
 private String tecnico;
 private boolean servicocorretamente;
 private boolean prazocombinado;
}
