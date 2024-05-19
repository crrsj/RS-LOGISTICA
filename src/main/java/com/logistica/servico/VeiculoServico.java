package com.logistica.servico;

import java.util.List;

import org.springframework.stereotype.Service;


import com.logistica.dto.VeiculoDto;
import com.logistica.entidade.Veiculo;
import com.logistica.repositorio.VeiculoRepositorio;
import com.logistica.repositorio.VoluntarioRepositorio;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class VeiculoServico {
	
	private final VeiculoRepositorio veiculoRepositorio;
	
	private final VoluntarioRepositorio voluntarioRepositorio;
	
	public Veiculo cadastrarVeiculo(VeiculoDto veiculo) {
		var cadastrarVeiculo = veiculo.novoVeiculo( voluntarioRepositorio);
		return veiculoRepositorio.save(cadastrarVeiculo);
	}
	
	public List<Veiculo>  listarVeiculos() {
		return veiculoRepositorio.findAll();
	}
	
	public Veiculo buscarId( Long id) {
		return veiculoRepositorio.findById(id).get();
		
	}
	
	public Veiculo atualizarVeiculo(VeiculoDto atualizar, Long id) {
		var atualize = new Veiculo(atualizar);
		atualize.getId();
		return veiculoRepositorio.save(atualize);
	}
	public void excluirVeiculo(Long id) {
		veiculoRepositorio.deleteById(id);
	}
}
