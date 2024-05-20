package com.logistica.controle;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.logistica.dto.PessoaDto;
import com.logistica.dto.PessoasDto;
import com.logistica.servico.PessoaServico;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("pessoa")
@RequiredArgsConstructor
public class PessoaControle {
	
	private final PessoaServico pessoaServico;
	
	
	@PostMapping
	@Operation(summary = "Rota responsável por cadastrar uma pessoa")
	 @ApiResponse(responseCode = "201",description = " sucesso",content = {
	    		@Content(mediaType = "application.json",schema = @Schema(implementation = ResponseEntity.class))
	  })         		
	public ResponseEntity<PessoaDto>cadastrarPessoa(@RequestBody @Valid PessoaDto pessoa){
		var cadastre = pessoaServico.cadastrarPessoa(pessoa);
		var uri = ServletUriComponentsBuilder.fromCurrentRequest().path("pessoas/{id}")
		.buildAndExpand(cadastre.getId()).toUri();
		return ResponseEntity.created(uri).body(new PessoaDto(cadastre));
	}
	
	@GetMapping
	@Operation(summary = "Rota responsável pela busca de todos as pessoas")
	@ApiResponse(responseCode = "200",description = " sucesso",content = {
	    		@Content(mediaType = "application.json",schema = @Schema(implementation = ResponseEntity.class))
	   })           
	public ResponseEntity<List<PessoasDto>>listarPessoas(){
		var liste = pessoaServico.listarPessoas().stream().map(PessoasDto::new).toList();
		return ResponseEntity.ok(liste);
	}

	@GetMapping("{id}")
	@Operation(summary = "Rota responsável pela busca da pessoa pelo Id")
	@ApiResponse(responseCode = "200",description = " sucesso",content = {
	    		@Content(mediaType = "application.json",schema = @Schema(implementation = ResponseEntity.class))
	   })           
	public ResponseEntity<PessoasDto>buscarPorId(@PathVariable Long id){
		var busca = pessoaServico.buscarPorId(id);
		return ResponseEntity.ok().body(new PessoasDto(busca));
	}
	
	@PutMapping("{id}")
	@Operation(summary = "Rota responsável por atualizar uma pessoa pelo id")
	 @ApiResponse(responseCode = "200",description = " sucesso",content = {
	    		@Content(mediaType = "application.json",schema = @Schema(implementation = ResponseEntity.class))
	  })         		
	public ResponseEntity<PessoasDto>atualizarPesoas(@RequestBody @Valid PessoasDto pessoa, @PathVariable Long id){
		var atualize = pessoaServico.atualizarPessoas(pessoa, id);
		return ResponseEntity.ok().body(new PessoasDto(atualize));
	}
	
	@DeleteMapping("{id}")
	@Operation(summary = "Rota responsável por deletar uma pessoa pelo id")
	 @ApiResponse(responseCode = "204",description = " sem conteúdo",content = {
	    		@Content(mediaType = "application.json",schema = @Schema(implementation = ResponseEntity.class))
	  })         		
	public ResponseEntity<Void>excluirpessoa(@PathVariable Long id){		
		pessoaServico.excluirPessoa(id);
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping("busca")
	@Operation(summary = "Rota responsável pela busca da pessoa pelo nome")
	@ApiResponse(responseCode = "200",description = " sucesso",content = {
	    		@Content(mediaType = "application.json",schema = @Schema(implementation = ResponseEntity.class))
	   })     
	public ResponseEntity<List<PessoasDto>>buscarPorNome(@RequestParam String nome){
		var buscaPorNome = pessoaServico.buscarPorNome(nome).stream().map(PessoasDto::new).toList();
		return  ResponseEntity.ok(buscaPorNome);
	}
}
 