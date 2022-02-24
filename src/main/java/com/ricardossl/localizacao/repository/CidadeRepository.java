package com.ricardossl.localizacao.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ricardossl.localizacao.domain.entity.Cidade;
import com.ricardossl.localizacao.repository.projections.CidadeProjection;

public interface CidadeRepository extends JpaRepository<Cidade, Long>, JpaSpecificationExecutor<Cidade> {

	@Query(nativeQuery = true, value = "select * from tb_cidade c where c.nome = :nome")
	List<Cidade> findByNomeNativo(@Param("nome") String nome);

	@Query(nativeQuery = true, value = "select c.id_cidade as id, c.nome from tb_cidade c where c.nome = :nome")
	List<CidadeProjection> findByNomeNativoProjection(@Param("nome") String nome);

	List<Cidade> findByNome(String nome);

	List<Cidade> findByHabitantes(Long habitantes);

	@Query("select c from Cidade c where upper(c.nome) like upper(?1)")
	List<Cidade> findByNomeLike(String nome, Pageable pageable);
}
