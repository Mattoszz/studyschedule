package com.zmattos.studyschedule.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;

import lombok.Data;

@Entity
@Data
public class Conteudo{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@NotEmpty
	private String conteudoEstudado;
	@NotEmpty
	private String tempoDeEstudo;
	
	@ManyToOne
	private Agenda agenda;
}
