package br.com.investidor.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotBlank;
/**
 * 
 * @author: André Luiz C. Rodrigues
 * @date: 9 de fev de 2020
 */
@Entity
public class TipoAcao {

	@Id
	@SequenceGenerator(name = "tipo_acao_id_seq", sequenceName = "tipo_acao_id_seq")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tipo_acao_id_seq")
	private Long id;

	@NotBlank
	private String nome;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
