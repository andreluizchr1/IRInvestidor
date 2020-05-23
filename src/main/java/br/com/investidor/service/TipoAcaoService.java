package br.com.investidor.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.investidor.model.TipoAcao;
import br.com.investidor.repository.TipoAcaoRepository;

@Service
public class TipoAcaoService {

	@Autowired
	private TipoAcaoRepository repository;

	/*
	 * Metodo responsável por listar todos os tipos de ações que podem existir.
	 */
	public Collection<TipoAcao> listar() {
		return repository.findAll();
	}
}
