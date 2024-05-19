package com.logistica.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.logistica.entidade.Veiculo;
import com.logistica.entidade.Voluntario;
import com.logistica.enums.HabNautica;
import com.logistica.enums.HabVeiculo;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VoluntarioDto {

	
	@NotBlank(message = "Não pode estar em branco")
	private String nome;	
	@JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "dd-MM-yyyy")
	private Date dataNasc;	
	private String cpf;
	@NotBlank(message = "Não pode estar em branco")
	private String telefone;
	@NotBlank(message = "Não pode estar em branco")
	private String email;
    private HabVeiculo habVeiculo;
    private HabNautica habNautica;
    private List<Veiculo>veiculo = new ArrayList<>();
    
    public VoluntarioDto(Voluntario cadastre) {
		
		this.nome = cadastre.getNome();
		this.email = cadastre.getEmail();
		this.dataNasc = cadastre.getDataNasc();
		this.cpf = cadastre.getCpf();
		this.telefone = cadastre.getTelefone();
		this.habVeiculo = cadastre.getHabVeiculo();
		this.habNautica = cadastre.getHabNautica();
		this.veiculo = cadastre.getVeiculo();
		
	}
	
}
