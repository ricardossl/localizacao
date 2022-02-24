package com.ricardossl.localizacao.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.ricardossl.localizacao.domain.entity.Cidade;
import com.ricardossl.localizacao.repository.CidadeRepository;
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
	
	
}
