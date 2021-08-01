package br.edu.ifg.entities;

import java.sql.Date;

public class Leilao {

	private String item;
	private Double lanceMinimo;
	private Status status;
	private Date dataExpiracao;
	
	public Leilao() {
		
	}
	
	public Leilao(String item) {
		super();
		this.item = item;
	}
	
	
	public Leilao(String item, Double lanceMinimo, Status status, Date dataExpiracao) {
		super();
		this.item = item;
		this.lanceMinimo = lanceMinimo;
		this.status = status;
		this.dataExpiracao = dataExpiracao;
	}
	
	
	

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public Double getLanceMinimo() {
		return lanceMinimo;
	}

	public void setLanceMinimo(Double lanceMinimo) {
		this.lanceMinimo = lanceMinimo;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Date getDataExpiracao() {
		return dataExpiracao;
	}

	public void setDataExpiracao(Date dataExpiracao) {
		this.dataExpiracao = dataExpiracao;
	}
	
	


	
	
}
