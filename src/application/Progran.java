package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.ContratoHora;
import entities.Departamento;
import entities.Trabalhador;
import entities.enums.NivelTrabalhador;

public class Progran {

	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		System.out.print("Digite o nome do departamento: ");
		String departamentoTrabalhador = sc.nextLine();
		System.out.println("Digite os dados do trabalhador: ");
		System.out.print("Nome: ");
		String nomeTrabalhador = sc.nextLine();
		System.out.print("NIVEL: ");
		String nivelTrabalhador = sc.nextLine();
		System.out.print("Digite o salario base: ");
		double salarioBase = sc.nextDouble();

		Trabalhador trab = new Trabalhador(nomeTrabalhador, NivelTrabalhador.valueOf(nivelTrabalhador), salarioBase,
				new Departamento(departamentoTrabalhador));

		System.out.println("Digite a quantidade de contratos para esse trabalhador: ");
		int qntContratos = sc.nextInt();

		for (int i = 1; i <= qntContratos; i++) {
			System.out.println("Entre com os dados do contrato "+i+": ");
			System.out.println("Data (DD/MM/YYYY)");
			Date dataContrato = sdf.parse(sc.next()); 
			System.out.println("Valor por hora: ");
			double valorHora = sc.nextDouble();
			System.out.println("quantas horas: ");
			int horas = sc.nextInt();
			
			ContratoHora contrato = new ContratoHora(dataContrato, valorHora, horas);
			trab.addContrato(contrato);
		}
		
		System.out.println("Entre com o mes e o ano que deseja calcular a renda (MM/YYYY)");
		String mesEano = sc.next();
		int mes = Integer.parseInt(mesEano.substring(0, 2));
		int ano = Integer.parseInt(mesEano.substring(3));
		
		System.out.println("Nome: "+trab.getNome());
		System.out.println("Departamento: "+trab.getDepartamento().getNome());
		System.out.println("renta para "+mesEano+": "+ trab.renda(ano, mes));
		
		sc.close();
	}

}
