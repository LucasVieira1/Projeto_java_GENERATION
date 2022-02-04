package entities;

import java.util.Scanner;

public class IR {

	private double salario;
	private double parcela;
	private int dependentes;
	private double impfonte;
	private double descontos;
	private double ir;
	private int opc;

	public IR(double salario, double parcela, int dependentes, double impfonte, double descontos, double ir, int opc) {
		this.salario = salario;
		this.parcela = parcela;
	}

	public void simples() {
		Scanner leia = new Scanner(System.in);

		System.out.println("\nInsira o valor da renda mensal: ");
		System.out.print("Digite aqui -->: ");
		salario = leia.nextDouble();

	}

	public void detalhada() {
		Scanner leia = new Scanner(System.in);
		impfonte = -1;

		System.out.println("\nInsira o valor da renda mensal: ");
		System.out.print("Digite aqui -->: ");
		salario = leia.nextDouble();
		System.out.println("\nQuantos dependentes possui? ");
		System.out.print("Digite aqui -->: ");
		dependentes = leia.nextInt();
		while (impfonte < 0) {
			System.out.println(
					"\nQual o valor das deduções durante o ano? (Para informações detalhadas insira um número negativo)");
			System.out.print("Digite aqui -->: ");
			impfonte = leia.nextDouble();

			if (impfonte < 0) {
				System.out.println("As despesas aplicáveis a dedução no imposto de renda são:  ");
				System.out.println("\n- Saúde: Sem valores limites e não são consideráveis gastos com estética");
				System.out.println(
						"\n- Educação: Limite de R$ 3.561,50. São dedutíveis os gastos com Escolas, Faculdades e Universidades e Cursos técnicos e profissionalizantes\n");

			}
		}

	}

	public void calculo() {

		descontos();
		salario -= descontos;

		double ir1;
		double ir2;
		double ir3;
		double ir4;

		ir1 = (salario - 1903.98) * 0.075;
		ir2 = (salario - 2826.66) * 0.15;
		ir3 = (salario - 3751.06) * 0.225;
		ir4 = (salario - 4664.68) * 0.275;

		if (salario <= 1903.00) {
			ir = 0;

		}

		if (salario >= 1903.99 && salario <= 2826.65) {
			ir = ir1;

		}
		if (salario >= 2826.66 && salario <= 3751.05) {
			ir = (922.66 * 0.075) + ir2;
		}
		if (salario >= 3751.06 && salario <= 4664.68) {
			ir = (922.66 * 0.075) + (924.39 * 0.15) + ir3;
		}
		if (salario > 4664.68) {
			ir = (922.66 * 0.075) + (924.39 * 0.15) + (913.62 * 0.225) + ir4;
		}

	}

	public void descontos() {
		descontos = impfonte + (dependentes * 189.59);

	}

	public void menu() {

		System.out.println("\n------SIMULADOR DE IMPOSTO DE RENDA------");
		System.out.println("(1) Cálculo de Imposto de Renda simples");
		System.out.println("(2) Cálculo de Imposto de Renda Detalhado");
		System.out.println("-----------------------------------------");
		System.out.print("Digite aqui -->: ");

	}

	public void total() {

		if (ir < 0) {
			ir = 0;
		}

		System.out.println("\n===============IMPOSTO DE RENDA================");
		System.out.printf("O Valor do Imposto de Renda será de: R$ %.2f", ir);
		System.out.println("\n===============================================");

	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	public double getParcela() {
		return parcela;
	}

	public void setParcela(double parcela) {
		this.parcela = parcela;
	}

	public int getDependentes() {
		return dependentes;
	}

	public void setDependentes(int dependentes) {
		this.dependentes = dependentes;
	}

	public double getImpfonte() {
		return impfonte;
	}

	public void setImpfonte(double impfonte) {
		this.impfonte = impfonte;
	}

	public double getDescontos() {
		return descontos;
	}

	public void setDescontos(double descontos) {
		this.descontos = descontos;
	}

	public double getIr() {
		return ir;
	}

	public void setIr(double ir) {
		this.ir = ir;
	}

	public int getOpc() {
		return opc;
	}

	public void setOpc(int opc) {
		this.opc = opc;
	}

}