package com.zmattos.studyschedule.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import com.zmattos.studyschedule.model.Agenda;
import com.zmattos.studyschedule.model.Conteudo;
import com.zmattos.studyschedule.repository.AgendaRepository;
import com.zmattos.studyschedule.repository.ConteudoRepository;

@Controller		
public class AgendaController {
	
	@Autowired
	private AgendaRepository agendaRepository;
	
	@Autowired
	private ConteudoRepository conteudoRepository;
	
	@GetMapping("/cadastrarCurso")
	public String form() {
		return "agenda/formAgenda";
		
	}
	
	@PostMapping("/cadastrarCurso")
	public String form(Agenda curso) {
		
		curso.setDataCadastro(LocalDate.now());
		agendaRepository.save(curso);
					
		return "redirect:/cadastrarCurso";
	}
	
	@GetMapping("/cursos")
	public ModelAndView listaCursos() {
		ModelAndView mv = new ModelAndView("index");
		List<Agenda> cursos = agendaRepository.findAll();
		mv.addObject("cursos", cursos);
		return mv;
	}
	
	@GetMapping("/{id}")
	public ModelAndView detalhesCurso(@PathVariable("id") Long id) {
		ModelAndView mv = new ModelAndView("agenda/detalhesCurso");	
		Agenda curso = agendaRepository.findById(id).get();
		mv.addObject("curso", curso);
		return mv;
	}
	
	@PostMapping("/{id}")
	public String detalhesCursoPost(@PathVariable("id") Long id, Conteudo conteudo) {		
		Agenda curso = agendaRepository.findById(id).get();
		conteudo.setAgenda(curso);
		conteudoRepository.save(conteudo);
		return "redirect:/{id}";
	}
	
}
