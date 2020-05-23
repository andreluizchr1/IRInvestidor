package br.com.investidor.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.investidor.model.Acao;

/**
 * @author: André Luiz C. Rodrigues
 * @date: 9 de fev de 2020
 */
public interface AcaoRepository extends JpaRepository<Acao, Long> {

}
