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
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


import com.logistica.dto.VeiculoDto;

import com.logistica.servico.VeiculoServico;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;


@RestController
@RequestMapping("veiculo")
@RequiredArgsConstructor
public class VeiculoControle {

	private final VeiculoServico veiculoServico;
	
	@PostMapping
	@Operation(summary = "Rota responsável pelo cadastro de veículos") 
    @ApiResponse(responseCode = "201",description = "usuário cadastrado com sucesso",content = {
   		@Content(mediaType = "application.json",schema = @Schema(implementation = ResponseEntity.class))
    })           
	public ResponseEntity<VeiculoDto> cadastrarVeiculo(@RequestBody VeiculoDto veiculo){
		var cadastre = veiculoServico.cadastrarVeiculo(veiculo);
		var uri =  ServletUriComponentsBuilder.fromCurrentRequest().path("veiculo/{id}")
		.buildAndExpand(cadastre.getId()).toUri();
		return ResponseEntity.created(uri).body(new VeiculoDto(cadastre));
	}
	
	@GetMapping
	 @Operation(summary = "Rota responsável por buscar todos os veículos")
	 @ApiResponse(responseCode = "200",description = " sucesso",content = {
	    		@Content(mediaType = "application.json",schema = @Schema(implementation = ResponseEntity.class))
	  })         		
	public ResponseEntity<List<VeiculoDto>>listar(){
		var listando = veiculoServico.listarVeiculos().stream().map(VeiculoDto::new).toList();
		return ResponseEntity.ok(listando);
	}
	
	@GetMapping("{id}")
	 @Operation(summary = "Rota responsável por buscar um veículo pelo id")
	 @ApiResponse(responseCode = "200",description = " sucesso",content = {
	    		@Content(mediaType = "application.json",schema = @Schema(implementation = ResponseEntity.class))
	  })         		
	public ResponseEntity<VeiculoDto>buscarId(@PathVariable Long id){
		var buscaId = veiculoServico.buscarId(id);
		return ResponseEntity.ok().body(new VeiculoDto(buscaId));
	}
	
	@DeleteMapping("{id}")
	@Operation(summary = "Rota responsável pela busca de todos os veículos")
	@ApiResponse(responseCode = "200",description = " sucesso",content = {
	    		@Content(mediaType = "application.json",schema = @Schema(implementation = ResponseEntity.class))
	   })           
	public ResponseEntity<Void>excluir(@PathVariable Long id){
		veiculoServico.buscarId(id);
		veiculoServico.excluirVeiculo(id);
		return ResponseEntity.noContent().build();
	}
	@PutMapping("{id}")
	 @Operation(summary = "Rota responsável por atualizar um abrigo pelo id")
	 @ApiResponse(responseCode = "200",description = " sucesso",content = {
	    		@Content(mediaType = "application.json",schema = @Schema(implementation = ResponseEntity.class))
	  })         
	public ResponseEntity<VeiculoDto>atualize(@PathVariable Long id,@RequestBody @Valid VeiculoDto atualizar){
		var atualizando = veiculoServico.atualizarVeiculo(atualizar, id);
		return ResponseEntity.ok().body(new VeiculoDto(atualizando));
	}
}
