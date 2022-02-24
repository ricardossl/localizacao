package com.ricardossl.localizacao.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.ExampleMatcher.StringMatcher;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.ricardossl.localizacao.domain.entity.Cidade;
import com.ricardossl.localizacao.repository.CidadeRepository;
import com.ricardossl.localizacao.repository.specs.CidadeSpecs;
import com.ricardossl.localizacao.service.CidadeService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CidadeServiceImpl implements CidadeService {
	private final CidadeRepository repository;

	@Transactional
	public Cidade salvar(Cidade cidade) {
		return repository.save(cidade);
	}

	@Override
	public List<Cidade> listarCidades() {
		return repository.findAll();
	}

	@Override
	public List<Cidade> listarCidadesDinamico(Cidade cidade) {
		ExampleMatcher matcher = ExampleMatcher.matching().withIgnoreCase("nome")
				.withStringMatcher(StringMatcher.STARTING);

		Example<Cidade> example = Example.of(cidade, matcher);
		return repository.findAll(example);
	}

	@Override
	public List<Cidade> listarCidadesByNomeSpecs(String nome) {
		Specification<Cidade> specs = CidadeSpecs.nomeEqual(nome).and(CidadeSpecs.habitantesGreaterThan(500));

		return repository.findAll(specs);
	}

	@Override
	public List<Cidade> findByNomeNativo(String nome) {
		return repository.findByNomeNativoProjection(nome).stream()
				.map(cidadeProjection 
						-> new Cidade(cidadeProjection.getId(), cidadeProjection.getNome(), null))
				.collect(Collectors.toList());
	}

}
