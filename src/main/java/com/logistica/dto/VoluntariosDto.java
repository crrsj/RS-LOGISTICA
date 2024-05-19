package com.logistica.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.logistica.entidade.Veiculo;
import com.logistica.entidade.Voluntario;
import com.logistica.enums.HabNautica;
import com.logistica.enums.HabVeiculo;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VoluntariosDto {
    private Long id;
	private String nome;
	private String telefone;
	private Date dataNasc;
	private String email;
	private HabVeiculo habVeiculo;
	@Enumerated(EnumType.STRING)
	private HabNautica habNautica;
	private List<Veiculo>veiculo = new ArrayList<>();
	
	public VoluntariosDto(Voluntario voluntario) {
		this.id = voluntario.getId();
		this.nome  = voluntario.getNome();
		this.telefone = voluntario.getTelefone();
		this.dataNasc = voluntario.getDataNasc();
		this.email = voluntario.getEmail();
		this.habVeiculo  = voluntario.getHabVeiculo();
		this.habNautica = voluntario.getHabNautica();
		this.veiculo  =voluntario.getVeiculo();
	}
}
