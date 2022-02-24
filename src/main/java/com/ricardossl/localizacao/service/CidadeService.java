package com.ricardossl.localizacao.service;

import java.util.List;

import com.ricardossl.localizacao.domain.entity.Cidade;

public interface CidadeService {
	Cidade salvar(Cidade cidade);
	List<Cidade> listarCidades();
	List<Cidade> listarCidadesDinamico(Cidade cidade);
	List<Cidade> listarCidadesByNomeSpecs(String nome);
	
}
