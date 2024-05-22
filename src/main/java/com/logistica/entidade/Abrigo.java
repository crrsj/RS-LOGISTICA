package com.logistica.entidade;

import java.io.Serializable;

import com.logistica.dto.AbrigoDto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "abrigos")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Abrigo implements Serializable{

	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String telefone;
	private String rua;
	private String bairro;
	private String cidade;
	private String complemento;
	private String estado;
	private int cep;
	
	
	public Abrigo(AbrigoDto abrigo) {
		this.nome = abrigo.getNome();
		this.telefone = abrigo.getTelefone();
		this.rua = abrigo.getRua();
		this.bairro = abrigo.getBairro();
		this.cidade = abrigo.getCidade();
		this.complemento = abrigo.getComplemento();
		this.cidade = abrigo.getCidade();
		this.estado  =abrigo.getEstado();
		this.cep = abrigo.getCep();
	}
	
}
