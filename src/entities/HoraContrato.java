package entities;

import java.util.Date;

public class HoraContrato {
	
	private Date date;
	private Double ValorPorHora;
	private Integer horas;
	
	public HoraContrato() {
		
	}

	public HoraContrato(Date date, Double valorPorHora, Integer horas) {
		this.date = date;
		ValorPorHora = valorPorHora;
		this.horas = horas;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Double getValorPorHora() {
		return ValorPorHora;
	}

	public void setValorPorHora(Double valorPorHora) {
		ValorPorHora = valorPorHora;
	}

	public Integer getHoras() {
		return horas;
	}

	public void setHoras(Integer horas) {
		this.horas = horas;
	}
	
	public double valorTotal() {
		return ValorPorHora * horas;
	}
	
	

}
