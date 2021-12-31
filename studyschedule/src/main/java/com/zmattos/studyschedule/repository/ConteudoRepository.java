package com.zmattos.studyschedule.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zmattos.studyschedule.model.Agenda;
import com.zmattos.studyschedule.model.Conteudo;

@Repository
public interface ConteudoRepository extends JpaRepository<Conteudo, Long>{
	List<Conteudo> findByAgenda(Agenda agenda);
}
