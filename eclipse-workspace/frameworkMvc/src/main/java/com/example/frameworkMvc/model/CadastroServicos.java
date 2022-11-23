package com.example.frameworkMvc.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

@Entity
@Table(name ="servicos", uniqueConstraints = {@UniqueConstraint(columnNames = {"descricao"})})
public class CadastroServicos {
	private int id;
	@NotNull
	private String descricao;
	@NotNull
	private String tempoEstimado;
	@NotNull
	private String responsavel;
	@NotNull
	private int valor;
		
	public CadastroServicos() {
		
	}
	
	public CadastroServicos(String descricao, String tempoEstimado, String responsavel, int valor) {
		this.descricao = descricao;
		this.tempoEstimado = tempoEstimado;
		this.responsavel = responsavel;
		this.valor = valor;
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
	
	@Column(name = "TEMPOESTIMADO", nullable = false, unique = true)
		public String getTempoEstimado() {
			return tempoEstimado;
		}
		public void setTempoEstimado(String tempoEstimado) {
			this.tempoEstimado = tempoEstimado;

		}
	@Column(name = "RESPONSAVEL", nullable = false)
		public String getResponsavel() {
			return responsavel;
		}
		public void setResponsavel(String responsavel) {
			this.responsavel = responsavel;

	}
	@Column(name = "VALOR", nullable = false)
		public int getValor() {
			return valor;
		}
		public void setValor(int valor) {
			this.valor = valor;
	
		}
	@Override
	public String toString() {
		return "Serviços [id= " + id + ", Descrição = " + descricao + ", Tempo Estimado = " + 
				tempoEstimado +	", Responsável = " + responsavel + ", Valor = " + valor + "]";
	}
}