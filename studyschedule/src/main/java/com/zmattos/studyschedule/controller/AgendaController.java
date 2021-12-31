package com.zmattos.studyschedule.controller;

import java.time.LocalDate;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
		Agenda curso = agendaRepository.findById(id).get();
		ModelAndView mv = new ModelAndView("agenda/detalhesCurso");		
		mv.addObject("curso", curso);
		
		List<Conteudo> conteudos = conteudoRepository.findByAgenda(curso);
		mv.addObject("conteudos", conteudos);		
		return mv;
		
	}
	
	@PostMapping("/{id}")
	public String detalhesCursoPost(@PathVariable("id") Long id, @Valid Conteudo conteudo, BindingResult result, RedirectAttributes attributes) {
			
		if(result.hasErrors()) {
			attributes.addFlashAttribute("mensagem", "Verifique os campos!");
			return "redirect:/{id}";
		}		
		Agenda curso = agendaRepository.findById(id).get();
		conteudo.setAgenda(curso);
		conteudoRepository.save(conteudo);
		attributes.addFlashAttribute("mensagem", "Conteudo adicionado com sucesso!");
		return "redirect:/{id}";
	}
	
}
