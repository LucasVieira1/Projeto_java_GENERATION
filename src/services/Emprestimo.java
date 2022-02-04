package services;

public class Emprestimo {
	
	public static double parcelas(double emprestimo, int parcelas) {
		double jurosMeses = emprestimo * juros(parcelas) / 100;
		double valorParcelas = (emprestimo / parcelas) + (jurosMeses / parcelas);
		
		return valorParcelas;
	}
	
	private static double juros(int parcelas) {
		return parcelas * 40 / 12;
	}
}
