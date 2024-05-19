package com.logistica.entidade;

import java.io.Serializable;
import java.util.Date;

import com.logistica.dto.PessoaDto;
import com.logistica.dto.PessoasDto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "pessoas")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pessoa implements Serializable {
	
	
	private static final long serialVersionUID = 1L;
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String cpf;
	private Date dataNasc;
	private String telefone;
	private String responsavel;
	private String rua;
	private String numero;
	private String bairro;
	private String cidade;
	private String complemento;
	private String estado;
	private int cep;


	public Pessoa(PessoaDto pessoa) {
	this.nome =	pessoa.getNome();
	this.cpf = 	pessoa.getCpf();
	this.dataNasc = pessoa.getDataNasc();
	this.telefone = pessoa.getTelefone();
	this.responsavel = pessoa.getResponsavel();
	this.rua = pessoa.getRua();
	this.numero = pessoa.getNumero();
	this.bairro = pessoa.getBairro();
	this.cidade = pessoa.getCidade();
	this.complemento = pessoa.getComplemento();
	this.estado = pessoa.getEstado();
	this.cep = pessoa.getCep();
	}


	public Pessoa(PessoasDto pessoa) {
		this.id = pessoa.getId();
		this.nome =	pessoa.getNome();		
		this.dataNasc = pessoa.getDataNasc();
		this.telefone = pessoa.getTelefone();
		this.responsavel = pessoa.getResponsavel();
		this.rua = pessoa.getRua();
		this.numero = pessoa.getNumero();
		this.bairro = pessoa.getBairro();
		this.cidade = pessoa.getCidade();
		this.estado = pessoa.getEstado();
		this.complemento = pessoa.getComplemento();
		this.cep = pessoa.getCep();
	}
	
	
	

}
