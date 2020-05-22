package br.com.investidor.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.investidor.model.Empresa;
/**
 * 
 * @author: André Luiz C. Rodrigues
 * @date: 22 de mai de 2020
 */
public interface EmpresaRepository extends JpaRepository<Empresa, Long> {

}
