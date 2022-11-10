package com.example.webProject.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name ="produtos")
public class CadastroProduto {
	private int id;
	@NotNull
	private String descricao;
	@NotNull	
	private int quantidade;
	@NotNull
	private String valorCompra;
	@NotNull
	private String valorVenda;
	@NotNull
	private String dataValidade;
	@NotNull
	private String fabricante;
		
	public CadastroProduto() {
		
	}
	
	public CadastroProduto(String descricao, int quantidade, String valorCompra, String valorVenda, String dataValidade, String fabricante) {
		this.descricao = descricao;
		this.quantidade = quantidade;
		this.valorCompra = valorCompra;
		this.valorVenda = valorVenda;
		this.dataValidade = dataValidade;
		this.fabricante = fabricante;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
		public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	@Column(name = "DESCRICAO", nullable = false)
	public String getDescricao() {
			return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;

	}
	
	@Column(name = "QUANTIDADE", nullable = false)
	
		public int getQuantidade() {
			return quantidade;
		}
		public void setQuantidade(int quantidade) {
			this.quantidade = quantidade;

	}
	
	@Column(name = "VALORCOMPRA", nullable = false)
		public String getValorCompra() {
			return valorCompra;
		}
		public void setValorCompra(String valorCompra) {
			this.valorCompra = valorCompra;
	
	}
	
	@Column(name = "VALORVENDA", nullable = false)
	public String getValorVenda() {
		return valorVenda;
	}
	public void setValorVenda(String valorVenda) {
		this.valorVenda = valorVenda;

	}
	
	@Column(name = "DATAVALIDADE", nullable = false)
	public String getDataValidade() {
		return dataValidade;
	}
	public void setDataValidade(String dataValidade) {
		this.dataValidade = dataValidade;

	}
	
	@Column(name = "FABRICANTE", nullable = false)
	public String getFabricante() {
		return fabricante;
	}
	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;

	}
	
	@Override
	public String toString() {
		return "Produto [id= "+id+", Descrição = "+ descricao + ", Quantidade = "+ quantidade + ", Valor de compra = "+ valorCompra +
				", Valor de venda = "+ valorVenda + ", Data de validade = " + dataValidade + ", Fabricante = " + fabricante +"]";
	}
}