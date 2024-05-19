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
public class PessoaDto {

	
	@NotBlank(message = "Não pode estar em branco")
	private String nome;
	@JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "dd-MM-yyyy")
	private Date dataNasc;	
	private String cpf;
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
	
	public PessoaDto(Pessoa cadastre) {
		this.nome = cadastre.getNome();
		this.dataNasc = cadastre.getDataNasc();
		this.cpf = cadastre.getCpf();
		this.telefone  =cadastre.getTelefone();
		this.responsavel = cadastre.getResponsavel();
		this.rua = cadastre.getRua();
		this.numero = cadastre.getNumero();
		this.bairro = cadastre.getBairro();
		this.cidade = cadastre.getCidade();
		this.estado = cadastre.getEstado();
		this.cep = cadastre.getCep();
		this.complemento = cadastre.getComplemento();
	}

}
