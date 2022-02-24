package com.ricardossl.localizacao.repository.specs;

import org.springframework.data.jpa.domain.Specification;

import com.ricardossl.localizacao.domain.entity.Cidade;

public class CidadeSpecs {
	private CidadeSpecs() {
	}
	
	public static Specification<Cidade> nomeEqual(String nome) {
		return (root, query, criteriaBuilder) 
				-> criteriaBuilder.equal(root.get("nome"), nome);
	}
	
	public static Specification<Cidade> habitantesGreaterThan(Integer value) {
		return (root, query, criteriaBuilder) 
				-> criteriaBuilder.greaterThan(root.get("habitantes"), value);
	}
	
}
