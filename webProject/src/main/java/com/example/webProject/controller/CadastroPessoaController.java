package com.example.webProject.controller;

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

import com.example.webProject.exception.resourceNotFoundException;
import com.example.webProject.model.CadastroPessoa;
import com.example.webProject.repository.CadastroPessoaRepository;


@RestController
@RequestMapping("/api/v1")
public class CadastroPessoaController {
	
	@Autowired
	private CadastroPessoaRepository cadastroPessoaRepository;
	
	//Pegar todos os cadastros
	@GetMapping("/CadastroPessoa")
	@ResponseStatus(HttpStatus.OK)
	public List<CadastroPessoa> getAllCadastroPessoa(){
		return this.cadastroPessoaRepository.findAll();
	}
	
	//Selecionar cadastro pelo ID
	@GetMapping("/CadastroPessoa/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<CadastroPessoa>getcadastroPessoaById(@PathVariable(value="id")int cadastroPessoaId)
			throws resourceNotFoundException{
				CadastroPessoa cadastroPessoa = cadastroPessoaRepository.findById(cadastroPessoaId)
						.orElseThrow(() -> new resourceNotFoundException("O ID "+cadastroPessoaId
								+ " não corresponde a nenhum Cadastro"));
				return ResponseEntity.ok().body(cadastroPessoa);
			}
		//Salvar Cadastro
		@PostMapping("/CadastroPessoa")
		@ResponseStatus(HttpStatus.CREATED)
		public CadastroPessoa cadastroPessoaRepository(@RequestBody CadastroPessoa cadastroPessoa) {
			return this.cadastroPessoaRepository.save(cadastroPessoa);
		}
		
			//Atualizar cadastro Pessoa
			@PutMapping("/CadastroPessoa/{id}")
			@ResponseStatus(HttpStatus.OK)
			public ResponseEntity<CadastroPessoa> updateCadastroPessoa(@PathVariable(value="id")int cadastroPessoaId, 
				@Validated @RequestBody CadastroPessoa cadastroPessoaValores) throws resourceNotFoundException{
					CadastroPessoa cadastroPessoa = cadastroPessoaRepository.findById(cadastroPessoaId)
						.orElseThrow(() -> new resourceNotFoundException("O ID "+cadastroPessoaId
								+ " não corresponde a nenhum Cadastro"));
				cadastroPessoa.setNome(cadastroPessoaValores.getNome());
				cadastroPessoa.setEmail(cadastroPessoaValores.getEmail());
				cadastroPessoa.setTel(cadastroPessoaValores.getTel());
				cadastroPessoa.setSenha(cadastroPessoaValores.getSenha());
				
				return ResponseEntity.ok(this.cadastroPessoaRepository.save(cadastroPessoa));
			}
			//Deleletar Pessoa
			@DeleteMapping("/CadastroPessoa/{id}")
			@ResponseStatus(HttpStatus.OK)
			public Map<String, Boolean>deletaCadastroPessoa(@PathVariable(value="id")int cadastroPessoaId) 
					throws resourceNotFoundException{
				CadastroPessoa cadastroPessoa = cadastroPessoaRepository.findById(cadastroPessoaId)
						.orElseThrow(() -> new resourceNotFoundException("O ID "+cadastroPessoaId
								+ " não corresponde a nenhum Cadastro"));
				this.cadastroPessoaRepository.delete(cadastroPessoa);
				Map<String, Boolean> resposta = new HashMap<>();
				resposta.put("Cadastro deletado com sucesso", Boolean.TRUE);
				return resposta;
			}
				
}	
	