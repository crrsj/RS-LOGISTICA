package com.logistica.entidade;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.logistica.enums.HabVeiculo;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.logistica.dto.VoluntarioDto;
import com.logistica.dto.VoluntariosDto;
import com.logistica.enums.HabNautica;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Entity
@Table(name = "voluntarios")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Voluntario implements Serializable{	
    
	
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)    
	private Long id;
    private String nome;
    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "dd-MM-yyyy")
    private Date dataNasc;
    private String cpf;
    private String telefone;
    private String email;
    private HabVeiculo habVeiculo;
    private HabNautica habNautica;
    @JsonIgnore
    @OneToMany(mappedBy = "voluntario")
    private List<Veiculo> veiculo = new ArrayList<Veiculo>();
	
    
    public Voluntario(VoluntarioDto voluntario) {
		
		this.nome = voluntario.getNome();
		this.cpf = voluntario.getCpf();
		this.dataNasc = voluntario.getDataNasc();
		this.telefone = voluntario.getTelefone();
		this.email = voluntario.getEmail();
		this.habVeiculo = voluntario.getHabVeiculo();
		this.habNautica = voluntario.getHabNautica();
	}


	public Voluntario(VoluntariosDto voluntario) {
		this.id = voluntario.getId();
		this.nome = voluntario.getNome();
		this.dataNasc = voluntario.getDataNasc();
		this.telefone = voluntario.getTelefone();
		this.email = voluntario.getEmail();
		this.habVeiculo = voluntario.getHabVeiculo();
		this.habNautica = voluntario.getHabNautica();
	}
}
