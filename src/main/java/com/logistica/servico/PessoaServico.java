package com.logistica.servico;

import java.util.List;

import org.springframework.stereotype.Service;

import com.logistica.dto.PessoaDto;
import com.logistica.dto.PessoasDto;
import com.logistica.entidade.Pessoa;
import com.logistica.repositorio.PessoaRepositorio;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PessoaServico {
	
	private final PessoaRepositorio pessoaRepositorio;
	
	public Pessoa cadastrarPessoa(PessoaDto pessoa) {
		var cadastrar = new Pessoa(pessoa);
		return pessoaRepositorio.save(cadastrar);
	}
	
	public List<Pessoa>listarPessoas(){
	 return	pessoaRepositorio.findAll();
	}

	public Pessoa buscarPorId(Long id) {
		return pessoaRepositorio.findById(id).get();
	}
	
	public Pessoa atualizarPessoas(PessoasDto pessoa,Long id) {
		var atualize = new Pessoa(pessoa);
		atualize.setId(id);
		return pessoaRepositorio.save(atualize);
	}
	
	public void excluirPessoa(Long id) {
		pessoaRepositorio.findById(id).get();
		pessoaRepositorio.deleteById(id);
	}
	public List<Pessoa> buscarPorNome(String nome) {
	return	pessoaRepositorio.findByNome(nome.trim().toUpperCase());
	}
}
