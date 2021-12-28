package com.zmattos.studyschedule.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zmattos.studyschedule.model.Conteudo;

@Repository
public interface ConteudoRepository extends JpaRepository<Conteudo, Long>{

}
