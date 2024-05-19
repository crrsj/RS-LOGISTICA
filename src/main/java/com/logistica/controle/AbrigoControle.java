package com.logistica.controle;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.logistica.dto.AbrigoDto;
import com.logistica.servico.AbrigoService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("abrigo")
@RequiredArgsConstructor
public class AbrigoControle {
	private final AbrigoService abrigoService;
	@Operation(summary = "Rota responsável pelo cadastro do abrigo") 
    @ApiResponse(responseCode = "201",description = "usuário cadastrado com sucesso",content = {
   		@Content(mediaType = "application.json",schema = @Schema(implementation = ResponseEntity.class))
    })           
	public ResponseEntity<AbrigoDto>cadastrarAbrigo(@RequestBody AbrigoDto abrigo){
		var cadastre = abrigoService.cadastrarAbrigo(abrigo);
		var uri = ServletUriComponentsBuilder.fromCurrentRequest().path("abrigo/{id}")
		.buildAndExpand(cadastre.getId()).toUri();
		return ResponseEntity.created(uri).body(new AbrigoDto(cadastre));
	}

	@GetMapping
	@Operation(summary = "Rota responsável pela busca de todos os abrigos")
	@ApiResponse(responseCode = "200",description = " sucesso",content = {
	    		@Content(mediaType = "application.json",schema = @Schema(implementation = ResponseEntity.class))
	   })           
	public ResponseEntity<List<AbrigoDto>>listarAbrigos(){
		var listar = abrigoService.listarAbrigos().stream().map(AbrigoDto::new).toList();
		return ResponseEntity.ok(listar);
	}
	
	@GetMapping("{id}")
	@Operation(summary = "Rota responsável pela busca do abrigo pelo Id")
	@ApiResponse(responseCode = "200",description = " sucesso",content = {
	    		@Content(mediaType = "application.json",schema = @Schema(implementation = ResponseEntity.class))
	   })           
	public ResponseEntity<AbrigoDto>buscarId(@PathVariable Long id){
		var buscaId = abrigoService.buscarId(id);
		return ResponseEntity.ok().body(new AbrigoDto(buscaId));
	}
	@PutMapping("{id}")
	public ResponseEntity<AbrigoDto>atualizarAbrigo(@RequestBody @Valid AbrigoDto abrigo,@PathVariable Long id){
		var atualize = abrigoService.atualizarAbrigo(abrigo, id);
		return ResponseEntity.ok().body(new AbrigoDto(atualize));
	}
	@DeleteMapping ("{id}")
	@Operation(summary = "Rota responsável por deletar o abrigo")
	@ApiResponse(responseCode = "204",description = " sem conteúdo",content = {
	    		@Content(mediaType = "application.json",schema = @Schema(implementation = ResponseEntity.class))
	   })           
	public ResponseEntity<Void>excluir(@PathVariable Long id){
		abrigoService.excluirAbrigo(id);
		return ResponseEntity.noContent().build();
	}
}
