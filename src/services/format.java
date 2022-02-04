package services;

import java.text.NumberFormat;

public class format {


	public static String formatarMoeda(double vari) {
		NumberFormat nf = NumberFormat.getCurrencyInstance();
		nf.setMinimumFractionDigits(2);
		String formatar = nf.format(vari);
		return formatar;

	}
}
