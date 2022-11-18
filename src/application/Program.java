package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import entities.Departamento;
import entities.HoraContrato;
import entities.Worker;
import entities.enums.WorkerLevel;

public class Program {

	public static void main(String[] args) throws ParseException {
		Scanner teclado = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
				
		System.out.print("Entre com o departamento do trabalhador: ");
		String departmentName = teclado.nextLine();
		System.out.println("Digite os dados do trabalhador:  ");
		System.out.print("Nome: ");
		String workerNome = teclado.nextLine();
		System.out.print("Level: ");
		String workerLevel = teclado.nextLine();
		System.out.print("Salario: ");
		double workerSalario = teclado.nextDouble();
		Worker worker = new Worker(workerNome, WorkerLevel.valueOf(workerLevel), workerSalario, new Departamento(departmentName));
		
		System.out.print("Quantos contratos esse trabalhador vai ter?");
		int n = teclado.nextInt();
		for(int i = 1; i <= n; i++) {
			System.out.println("Entre com os dados do # " + i + " contrato");
			System.out.print("Data (DD/MM/YYYY): ");
			Date contractDate = sdf.parse(teclado.next());
			System.out.println("Valor por hora: ");
			double valorPorHora = teclado.nextDouble();
			System.out.print("Duração (horas): ");
			int hours = teclado.nextInt();
			System.out.println(" ");
			
			HoraContrato contrato = new HoraContrato(contractDate, valorPorHora, hours);
			worker.contratoAdicionado(contrato);			
		}
		
		System.out.println(" ");
		
		System.out.print("Entre com mês e ano para calcular o salario (MM/YYYY): ");
		String mesAno = teclado.next();
		int mes = Integer.parseInt(mesAno.substring(0, 2));
		int ano = Integer.parseInt(mesAno.substring(3));
		
		System.out.println("Nome: " + worker.getName());
		System.out.println("Departamento: " + worker.getDepartment().getName());
		System.out.println("Quanto ele ganhou no " + mesAno + ": " + String.format("%.2f", worker.calculoGanho(ano, mes)));
		
		
		
		
	}

}
