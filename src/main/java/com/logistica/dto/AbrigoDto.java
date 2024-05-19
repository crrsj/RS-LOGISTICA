package com.logistica.dto;

import com.logistica.entidade.Abrigo;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AbrigoDto {

	private Long id;
	@NotBlank(message = "Não pode estar em branco")
	private String nome;
	@NotBlank(message = "Não pode estar em branco")
	private String telefone;
	@NotBlank(message = "Não pode estar em branco")
	private String rua;
	@NotBlank(message = "Não pode estar em branco")
	private String bairro;
	@NotBlank(message = "Não pode estar em branco")
	private String cidade;
	@NotBlank(message = "Não pode estar em branco")
	private String complemento;
	@NotBlank(message = "Não pode estar em branco")
	private String estado;
	private int cep;
	

	public AbrigoDto(Abrigo cadastre) {
		this.id = cadastre.getId();
		this.nome = cadastre.getNome();
		this.telefone = cadastre.getTelefone();
		this.rua = cadastre.getRua();
		this.bairro = cadastre.getBairro();
		this.cidade = cadastre.getCidade();
		this.complemento = cadastre.getComplemento();
		this.estado = cadastre.getEstado();
		this.cep = cadastre.getCep(); 
	}
}
