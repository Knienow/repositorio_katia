package com.example.frameworkMvc.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.frameworkMvc.exception.resourceNotFoundException;
import com.example.frameworkMvc.model.CadastroServicos;
import com.example.frameworkMvc.repository.CadastroServicosRepository;


@RestController
@RequestMapping("/api/v1")
public class CadastroServicosController {
	
	@Autowired
	private CadastroServicosRepository cadastroServicosRepository;
	
	//Pegar todos os cadastros
	@GetMapping("/CadastroServicos")
	@ResponseStatus(HttpStatus.OK)
	public List<CadastroServicos> getAllCadastroServicos(){
		return this.cadastroServicosRepository.findAll();
	}
	
	//Selecionar cadastro pelo ID
	@GetMapping("/CadastroServicos/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<CadastroServicos>getcadastroServicosById(@PathVariable(value="id")int cadastroServicosId)
			throws resourceNotFoundException{
				CadastroServicos cadastroServicos = cadastroServicosRepository.findById(cadastroServicosId)
						.orElseThrow(() -> new resourceNotFoundException("O ID "+ cadastroServicosId
								+ " não corresponde a nenhum Cadastro"));
				return ResponseEntity.ok().body(cadastroServicos);
			}
		//Salvar Cadastro
		@PostMapping("/CadastroServicos")
		@ResponseStatus(HttpStatus.CREATED)
		public CadastroServicos cadastroServicosRepository(@RequestBody CadastroServicos cadastroServicos) {
			
			return this.cadastroServicosRepository.save(cadastroServicos);
		}
		
			//Atualizar cadastro Servicos
			@PutMapping("/CadastroServicos/{id}")
			@ResponseStatus(HttpStatus.OK)
			public ResponseEntity<CadastroServicos> updateCadastroServicos(@PathVariable(value="id")int cadastroServicosId, 
				@Validated @RequestBody CadastroServicos cadastroServicosValores) throws resourceNotFoundException{
					CadastroServicos cadastroServicos = cadastroServicosRepository.findById(cadastroServicosId)
						.orElseThrow(() -> new resourceNotFoundException("O ID "+ cadastroServicosId
								+ " não corresponde a nenhum Cadastro"));
				cadastroServicos.setDescricao(cadastroServicosValores.getDescricao());
				cadastroServicos.setTempoEstimado(cadastroServicosValores.getTempoEstimado());
				cadastroServicos.setResponsavel(cadastroServicosValores.getResponsavel());
				cadastroServicos.setValor(cadastroServicosValores.getValor());
				
				return ResponseEntity.ok(this.cadastroServicosRepository.save(cadastroServicos));
			}
			//Deleletar cadastro Servicos
			@DeleteMapping("/CadastroServicos/{id}")
			@ResponseStatus(HttpStatus.OK)
			public Map<String, Boolean>deletaCadastroServicos(@PathVariable(value="id")int cadastroServicosId) 
					throws resourceNotFoundException{
				CadastroServicos cadastroServicos = cadastroServicosRepository.findById(cadastroServicosId)
						.orElseThrow(() -> new resourceNotFoundException("O ID "+cadastroServicosId
								+ " não corresponde a nenhum Cadastro"));
				this.cadastroServicosRepository.delete(cadastroServicos);
				Map<String, Boolean> resposta = new HashMap<>();
				resposta.put("Cadastro deletado com sucesso", Boolean.TRUE);
				return resposta;
			}
}
				