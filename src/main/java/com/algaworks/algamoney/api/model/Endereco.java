package com.algaworks.algamoney.api.model;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Size;

@Embeddable
public class Endereco {
	
	@Size(min=1, max=100)
	private String logradouro;
	
	private int numero;

	@Size(min=1, max=20)
	private String complemento;

	@Size(min=1, max=50)
	private String bairro;
	
	@Size(min=1, max=10)
	private String cep;
	
	@ManyToOne
	@JoinColumn(name = "codigo_cidade")
	private Cidade cidade;
	
	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public Cidade getCidade() {
		return cidade;
	}
	
	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}
}
