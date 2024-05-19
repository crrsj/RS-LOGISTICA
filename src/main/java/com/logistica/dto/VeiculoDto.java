package com.logistica.dto;

import com.logistica.entidade.Veiculo;
import com.logistica.entidade.Voluntario;
import com.logistica.enums.Tipo;
import com.logistica.repositorio.VoluntarioRepositorio;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VeiculoDto {
	
	private Long id;
    @Enumerated(EnumType.STRING)
	private Tipo tipo;
    @NotBlank(message = "Não pode estar em branco")
	private String marca;
    @NotBlank(message = "Não pode estar em branco")
	private String modelo;
    @NotBlank(message = "Não pode estar em branco")
	private String cor;
    @NotBlank(message = "Não pode estar em branco")
	private String placa;
    @NotNull
	private Long voluntarioId;
	private Voluntario voluntario;
	
	public Veiculo novoVeiculo(VoluntarioRepositorio voluntarioRepositorio) {
	 var voluntario = voluntarioRepositorio.findById(voluntarioId).get();
		return new Veiculo(id,tipo,marca,modelo,cor,placa,voluntarioId,voluntario);
	}

	public VeiculoDto(Veiculo cadastre) {
		this.id = cadastre.getId();
		this.tipo = cadastre.getTipo();
		this.marca = cadastre.getMarca();
		this.modelo = cadastre.getModelo();
		this.cor = cadastre.getCor();
		this.placa = cadastre.getPlaca();
		this.voluntarioId = cadastre.getVoluntarioId();
		this.voluntario = cadastre.getVoluntario();
	}
	
	
}
