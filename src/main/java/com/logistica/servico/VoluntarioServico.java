package com.logistica.servico;

import java.util.List;

import org.springframework.stereotype.Service;

import com.logistica.dto.VoluntarioDto;
import com.logistica.dto.VoluntariosDto;
import com.logistica.entidade.Voluntario;
import com.logistica.repositorio.VoluntarioRepositorio;

import lombok.RequiredArgsConstructor;

  @Service
  @RequiredArgsConstructor
  public class VoluntarioServico {
	private final VoluntarioRepositorio voluntarioRepositorio;
	
	public Voluntario cadastrarVoluntario(VoluntarioDto voluntario) {
		var cadastrar = new Voluntario(voluntario);
		return voluntarioRepositorio.save(cadastrar);
	}
	
  public List<Voluntario>buscarVoluntarios(){
	  return voluntarioRepositorio.findAll();
	  
  }
  
  public Voluntario buscarPorId(Long id) {
	  return voluntarioRepositorio.findById(id).get();
  }
  
  public Voluntario atualizarVoluntario(VoluntariosDto voluntario, Long id) {
	  var atualize =  new Voluntario(voluntario);
	  atualize.setId(id);
	  return voluntarioRepositorio.save(atualize);
	  
  }
  
  public void excluirVoluntario(Long id) {
	  voluntarioRepositorio.findById(id).get();
	  voluntarioRepositorio.deleteById(id);
  }
  
  public List<Voluntario> buscarPorNome(String nome) {
	 return voluntarioRepositorio.findByNome(nome.trim().toUpperCase());
	  
  }
}
