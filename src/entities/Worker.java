package entities;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import entities.enums.WorkerLevel;

public class Worker {
	
	private String name;
	private WorkerLevel level;
	private double salario;
	
	private Departamento department; //Associação enumerada
	private List<HoraContrato> contratos = new ArrayList();
	
	public Worker() {
		
	}

	public Worker(String name, WorkerLevel level, double salario, Departamento department) {
		this.name = name;
		this.level = level;
		this.salario = salario;
		this.department = department;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public WorkerLevel getLevel() {
		return level;
	}

	public void setLevel(WorkerLevel level) {
		this.level = level;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	public Departamento getDepartment() {
		return department;
	}

	public void setDepartment(Departamento department) {
		this.department = department;
	}

	public List<HoraContrato> getContratos() {
		return contratos;
	}
	
	public void contratoAdicionado(HoraContrato contrato) {
		contratos.add(contrato);
	}
	
	public void contratoRemovido(HoraContrato contrato) {
		contratos.remove(contrato);
	}
	
	public double calculoGanho(int ano, int mes) {
		double soma = salario;
		
		Calendar cal = Calendar.getInstance();
		for(HoraContrato x : contratos) {
			cal.setTime(x.getDate());
			int x_ano = cal.get(Calendar.YEAR);
			int x_mes = 1 + cal.get(Calendar.MONTH);
			
			if(ano == x_ano && mes == x_mes ) {
				soma += x.valorTotal(); 			
			}
			
		}
		return soma;
	}
	
	
	
}
