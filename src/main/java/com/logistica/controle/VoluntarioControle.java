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

import com.logistica.dto.VoluntarioDto;
import com.logistica.dto.VoluntariosDto;
import com.logistica.servico.VoluntarioServico;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("voluntario")
@RequiredArgsConstructor
public class VoluntarioControle {
	private final VoluntarioServico voluntarioServico;

	@PostMapping
	@Operation(summary = "Rota responsável pelo cadastro de voluntários") 
    @ApiResponse(responseCode = "201",description = "usuário cadastrado com sucesso",content = {
   		@Content(mediaType = "application.json",schema = @Schema(implementation = ResponseEntity.class))
    })           
	public ResponseEntity<VoluntarioDto>cadastrarVoluntario(@RequestBody @Valid VoluntarioDto voluntario){
		var cadastre = voluntarioServico.cadastrarVoluntario(voluntario);
		var uri =  ServletUriComponentsBuilder.fromCurrentRequest().path("voluntario/{id}")
		.buildAndExpand(cadastre.getId()).toUri();		
		return ResponseEntity.created(uri).body(new VoluntarioDto(cadastre));
	}
	
	@GetMapping
	@Operation(summary = "Rota responsável pela busca de todos os voluntários")
	@ApiResponse(responseCode = "200",description = " sucesso",content = {
	    		@Content(mediaType = "application.json",schema = @Schema(implementation = ResponseEntity.class))
	   })           
	public ResponseEntity<List<VoluntariosDto>>ListarVoluntarios(){
		var listar = voluntarioServico.buscarVoluntarios().stream().map(VoluntariosDto::new).toList();
		return ResponseEntity.ok(listar);
	}
	@PutMapping("{id}")
	@Operation(summary = "Rota responsável por atualizar um voluntário pelo id")
	 @ApiResponse(responseCode = "200",description = " sucesso",content = {
	    		@Content(mediaType = "application.json",schema = @Schema(implementation = ResponseEntity.class))
	  })         		
	public ResponseEntity<VoluntariosDto>atualizarVoluntario(@PathVariable Long id,@RequestBody @Valid VoluntariosDto voluntario){
		var atualize = voluntarioServico.atualizarVoluntario(voluntario, id);
		return  ResponseEntity.ok().body(new VoluntariosDto(atualize));
	}
	
	@GetMapping("{id}")
	@Operation(summary = "Rota responsável por buscar um voluntário pelo id")
	 @ApiResponse(responseCode = "200",description = " sucesso",content = {
	    		@Content(mediaType = "application.json",schema = @Schema(implementation = ResponseEntity.class))
	  })         		
	public ResponseEntity<VoluntariosDto>buscarPorId(@PathVariable Long id){
		var busca = voluntarioServico.buscarPorId(id);
		return ResponseEntity.ok().body(new VoluntariosDto(busca));
	}
	
	@DeleteMapping("{id}")
	@Operation(summary = "Rota responsável por deletar um funcionário pelo id")
	@ApiResponse(responseCode = "204",description = " sem conteúdo",content = {
	    		@Content(mediaType = "application.json",schema = @Schema(implementation = ResponseEntity.class))
	    })           
	public ResponseEntity<VoluntariosDto>excluir(@PathVariable Long id){
		voluntarioServico.excluirVoluntario(id);
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping("buscarVoluntario")
	@Operation(summary = "Rota responsável por buscar um voluntário pelo nome")
	 @ApiResponse(responseCode = "200",description = " sucesso",content = {
	    		@Content(mediaType = "application.json",schema = @Schema(implementation = ResponseEntity.class))
	  })         		
	public ResponseEntity<List<VoluntariosDto>>buscarVoluntarioPorNome(@RequestParam String nome){
		var buscar = voluntarioServico.buscarPorNome(nome).stream().map(VoluntariosDto::new).toList();
		return ResponseEntity.ok(buscar);
	}
}
