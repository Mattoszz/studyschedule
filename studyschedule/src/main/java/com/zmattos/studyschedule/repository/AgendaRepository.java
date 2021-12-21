package com.zmattos.studyschedule.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.zmattos.studyschedule.model.Agenda;

public interface AgendaRepository extends JpaRepository<Agenda, Long>{
	
}
