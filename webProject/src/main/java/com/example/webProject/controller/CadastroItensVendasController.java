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
import com.example.webProject.model.CadastroItensVendas;
import com.example.webProject.repository.CadastroItensVendasRepository;


@RestController
@RequestMapping("/api/v1")
public class CadastroItensVendasController {
	
	@Autowired
	private CadastroItensVendasRepository cadastroItensVendasRepository;
	
	@PostMapping("/CadastroItensVendas")
	@ResponseStatus(HttpStatus.CREATED)
	public CadastroItensVendas cadastroItensVendasRepository(@RequestBody CadastroItensVendas cadastroItensVendas) {
		return this.cadastroItensVendasRepository.save(cadastroItensVendas);
	}
	
	@GetMapping("/CadastroItensVendas")
	@ResponseStatus(HttpStatus.OK)
	public List<CadastroItensVendas> getAllCadastroItensVendas(){
		return this.cadastroItensVendasRepository.findAll();
	}
	
	@GetMapping("/CadastroItensVendas/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<CadastroItensVendas>getCadastroItensVendasById(@PathVariable(value="id")int cadastroItensVendasId)
			throws resourceNotFoundException{
				CadastroItensVendas cadastroItensVendas = cadastroItensVendasRepository.findById(cadastroItensVendasId)
						.orElseThrow(() -> new resourceNotFoundException("O ID "+cadastroItensVendasId
								+ " não corresponde a nenhum Cadastro"));
				return ResponseEntity.ok().body(cadastroItensVendas);
			}
		
	@PutMapping("/CadastroItensVendas/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<CadastroItensVendas> updateCadastroItensVendas(@PathVariable(value="id")int cadastroItensVendasId, 
		@Validated @RequestBody CadastroItensVendas cadastroItensVendasValores) throws resourceNotFoundException{
			CadastroItensVendas cadastroItensVendas = cadastroItensVendasRepository.findById(cadastroItensVendasId)
				.orElseThrow(() -> new resourceNotFoundException("O ID "+ cadastroItensVendasId
						+ " não corresponde a nenhum Cadastro"));
		cadastroItensVendas.setIdVenda(cadastroItensVendasValores.getIdVenda());
		cadastroItensVendas.setIdProduto(cadastroItensVendasValores.getIdProduto());
		cadastroItensVendas.setQuantidade(cadastroItensVendasValores.getQuantidade());
		cadastroItensVendas.setValorItem(cadastroItensVendasValores.getValorItem());
		
		return ResponseEntity.ok(this.cadastroItensVendasRepository.save(cadastroItensVendas));
	}

	@DeleteMapping("/CadastroItensVendas/{id}")
	@ResponseStatus(HttpStatus.OK)
	public Map<String, Boolean>deletaCadastroItensVendas(@PathVariable(value="id")int cadastroItensVendasId) 
			throws resourceNotFoundException{
		CadastroItensVendas cadastroItensVendas = cadastroItensVendasRepository.findById(cadastroItensVendasId)
				.orElseThrow(() -> new resourceNotFoundException("O ID "+cadastroItensVendasId
						+ " não corresponde a nenhum Cadastro"));
		this.cadastroItensVendasRepository.delete(cadastroItensVendas);
		Map<String, Boolean> resposta = new HashMap<>();
		resposta.put("Cadastro deletado com sucesso", Boolean.TRUE);
		return resposta;
	}
				
}	
	