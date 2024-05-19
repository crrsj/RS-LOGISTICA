package com.logistica.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.logistica.entidade.Pessoa;

public interface PessoaRepositorio extends JpaRepository<Pessoa, Long> {
    
	
	@Query(value = "select p from Pessoa p where upper(trim(p.nome)) like %?1% ") 
	List<Pessoa> findByNome(String nome); 
		
		

}
