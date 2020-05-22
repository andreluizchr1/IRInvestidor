package br.com.investidor.service;

import java.util.Collection;
import java.util.Date;

import javax.validation.ConstraintViolationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.com.investidor.exception.CodigoDuplicadoException;
import br.com.investidor.model.Acao;
import br.com.investidor.repository.AcaoRepository;

/**
 * 
 * @author: André Luiz C. Rodrigues
 * @date: 15 de fev de 2020
 */
@Service
public class AcaoService {

	@Autowired
	private AcaoRepository repository;

	/**
	 * Metodo responsável por realizar o cadastro de uma ação. Regra de Negócio:
	 * Nenhuma ação pode ter um ticker igual a outro.
	 * 
	 * @param acao
	 * @return
	 * @throws ConstraintViolationException
	 */
	public Acao salvar(Acao acao) throws CodigoDuplicadoException {

		registrarAlteracao(acao);

		try {
			return repository.save(acao);
		} catch (Exception e) {
			throw new CodigoDuplicadoException("Uma ação com esse código já existe.");
		}
	}

	public Collection<Acao> listar() {
		return repository.findAll(ordenarPorCodigo());
	}

	private Sort ordenarPorCodigo() {
		return new Sort(Sort.Direction.ASC, "ticker");
	}

	protected void registrarAlteracao(Acao acao) {
		if (acao.getId() == null) {
			acao.setDataCadastro(new Date());
		} else {
			acao.setDataAtualizacao(new Date());
		}
	}
}
