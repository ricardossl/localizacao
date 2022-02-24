package com.ricardossl.localizacao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ricardossl.localizacao.domain.entity.Cidade;
import com.ricardossl.localizacao.service.CidadeService;

import lombok.RequiredArgsConstructor;

@SpringBootApplication
@RequiredArgsConstructor
public class LocalizacaoApplication implements CommandLineRunner {
	private static final Logger logger = LoggerFactory.getLogger(LocalizacaoApplication.class);

	private final CidadeService service;

	@Override
	public void run(String... args) throws Exception {
		logger.info("Listando cidades...");

		var cidade = Cidade.builder().nome("Goiânia").build();

		service.findByNomeNativo(cidade.getNome()).forEach(t -> logger.warn(t.toString()));
	}

	public static void main(String[] args) {
		SpringApplication.run(LocalizacaoApplication.class, args);
	}

}
