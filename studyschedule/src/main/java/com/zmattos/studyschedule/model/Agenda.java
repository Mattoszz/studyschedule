package com.zmattos.studyschedule.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Entity
@Data
@Table(name = "Cad_Atividade")
public class Agenda implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@NotEmpty
	private String curso;
	
	@NotEmpty
	private String local;
	
	@Lob
	private String descricao;
	
	@NotEmpty
	private String professor;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "dd/MM/yyyy")
	private LocalDate dataCadastro ;
	
	@NotEmpty
	private String dataInicio;
	
	@NotEmpty
	private String dataFim;
	
	@OneToMany
	private List<Conteudo> conteudo;
}
