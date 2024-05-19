package com.logistica.entidade;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.logistica.dto.VeiculoDto;
import com.logistica.enums.Tipo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "veiculos")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Veiculo {
   
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Tipo tipo;
	private String marca;
	private String modelo;
	private String cor;
	private String placa;
	private Long voluntarioId;
	
    @JsonIgnore
	@ManyToOne
	@JoinColumn(name = "voluntarios_id")
	private Voluntario voluntario;
	
	 public Veiculo(VeiculoDto veiculo) {
		this.id = veiculo.getId();
		this.tipo = veiculo.getTipo();
		this.marca = veiculo.getMarca();
		this.modelo = veiculo.getModelo();
		this.cor = veiculo.getCor();
		this.placa = veiculo.getPlaca();
		this.voluntarioId = veiculo.getVoluntarioId();
		this.voluntario = veiculo.getVoluntario();
		
		
	}


}
