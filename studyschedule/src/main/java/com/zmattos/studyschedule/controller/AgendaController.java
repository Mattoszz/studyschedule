package com.zmattos.studyschedule.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import com.zmattos.studyschedule.model.Agenda;
import com.zmattos.studyschedule.repository.AgendaRepository;

@Controller		
public class AgendaController {
	
	@Autowired
	private AgendaRepository agendaRepository;
	
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
		Iterable<Agenda> cursos = agendaRepository.findAll();
		mv.addObject("cursos", cursos);
		return mv;
	}
}
