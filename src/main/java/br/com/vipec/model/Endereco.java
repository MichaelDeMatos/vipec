package br.com.vipec.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * Endereco
 */
public class Endereco {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Integer id;
	
	@Column(length = 8, nullable = false)
	private String cep;

	@Column(length = 50, nullable = false)
	private String logradouro;

	@Column(length = 10, nullable = false)
	private String numero;

	@Column(length = 30, nullable = true)
	private String complemento;

	@Column(length = 30, nullable = false)
	private String bairro;

	@ManyToOne(optional = false)
	private Uf uf;

	// private Municipio municipio;
}