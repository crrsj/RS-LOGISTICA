package com.logistica.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.logistica.entidade.Pessoa;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class PessoasDto {
    
	
	private Long id;
	@NotBlank(message = "Não pode estar em branco")
	private String nome;
	@JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "dd-MM-yyyy")
	private Date dataNasc;
	@NotBlank(message = "Não pode estar em branco")
	private String telefone;
	@NotBlank(message = "Não pode estar em branco")
	private String responsavel;
	@NotBlank(message = "Não pode estar em branco")
	private String rua;
	@NotBlank(message = "Não pode estar em branco")
	private String numero;
	@NotBlank(message = "Não pode estar em branco")
	private String bairro;
	@NotBlank(message = "Não pode estar em branco")
	private String cidade;
	@NotBlank(message = "Não pode estar em branco")
	private String complemento;
	@NotBlank(message = "Não pode estar em branco")
	private String estado;
	private int cep;
	
	public PessoasDto(Pessoa pessoa) {
		this.id = pessoa.getId();
		this.nome = pessoa.getNome();
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
}
