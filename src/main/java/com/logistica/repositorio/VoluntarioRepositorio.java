package com.logistica.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.logistica.entidade.Voluntario;

public interface VoluntarioRepositorio extends JpaRepository<Voluntario, Long> {
	@Query(value = "select v from Voluntario v where upper(trim(v.nome)) like %?1% ") 
	List<Voluntario>findByNome(String nome);

}
