package com.logistica.servico;

import java.util.List;

import org.springframework.stereotype.Service;

import com.logistica.dto.AbrigoDto;
import com.logistica.entidade.Abrigo;
import com.logistica.repositorio.AbrigoRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AbrigoService {
	private final AbrigoRepository abrigoRepository;

	public Abrigo cadastrarAbrigo(AbrigoDto abrigo) {
		var cadastrar = new Abrigo(abrigo);
		return abrigoRepository.save(cadastrar);
	}
	
	public List<Abrigo>listarAbrigos(){
		return abrigoRepository.findAll();
	}
	
	public Abrigo buscarId(Long id) {
		return abrigoRepository.findById(id).get();
	}
	
	public void excluirAbrigo(Long id) {
		abrigoRepository.findById(id).get();
		abrigoRepository.deleteById(id);
	}
	public Abrigo atualizarAbrigo(AbrigoDto abrigo,Long id) {
		var atualize = new Abrigo(abrigo);
		atualize.setId(id);
		return abrigoRepository.save(atualize);
	}
}
