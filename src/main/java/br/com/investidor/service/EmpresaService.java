package br.com.investidor.service;

import java.util.Collection;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.com.investidor.exception.EmpresaDuplicadaException;
import br.com.investidor.model.Empresa;
import br.com.investidor.repository.EmpresaRepository;

/**
 * 
 * @author: André Luiz C. Rodrigues
 * @date: 22 de mai de 2020
 */

@Service
public class EmpresaService {

	@Autowired
	private EmpresaRepository repository;

	/**
	 * Metodo responsável por cadastrar as empresas para uso nas notas de
	 * corretagem. Regra de Negócio: Empresas com cnpjs iguais não pode existem.
	 * 
	 * @param empresa
	 * @return
	 * @throws EmpresaDuplicadaException
	 */
	public Empresa salvar(Empresa empresa) throws EmpresaDuplicadaException {
		formatarNomeEmpresa(empresa);
		inserirDatas(empresa);
		try {
			return repository.save(empresa);
		} catch (Exception e) {
			throw new EmpresaDuplicadaException("Esse cnpj já está em uso", e);
		}
	}

	protected void inserirDatas(Empresa empresa) {
		if (empresa.getId() == null) {
			empresa.setDataCadastro(new Date());
		} else {
			empresa.setDataAtualizacao(new Date());
		}
	}

	protected void formatarNomeEmpresa(Empresa empresa) {
		empresa.setNome(empresa.getNome().toUpperCase());
	}

	/**
	 * Método responsável por listar todas as empresas já cadastradas
	 * 
	 * @return
	 */
	public Collection<Empresa> listar() {
		return repository.findAll(ordenarPorNome());
	}

	private Sort ordenarPorNome() {
		return new Sort(Sort.Direction.ASC, "nome");
	}

}
