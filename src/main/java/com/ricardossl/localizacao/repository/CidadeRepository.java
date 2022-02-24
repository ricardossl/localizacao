package com.ricardossl.localizacao.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ricardossl.localizacao.domain.entity.Cidade;

public interface CidadeRepository extends JpaRepository<Cidade, Long> {
	List<Cidade> findByNome(String nome);

	List<Cidade> findByHabitantes(Long habitantes);
	
	@Query("select c from Cidade c where upper(c.nome) like upper(?1)")
	List<Cidade> findByNomeLike(String nome);
}
