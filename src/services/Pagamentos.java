package services;

import entities.Usuario;

public class Pagamentos {

	public static void testeSaldo(double valor, Usuario newUser) {
		if (valor > newUser.getSaldo()) {
			// System.out.println("\nSaldo insuficiente! (Finalizando sessão...)\n");
			String erro = "Você tentou transferir/pagar um valor acima do seu saldo";
			throw new IllegalStateException(erro);
		} else {
			newUser.setSaldo(newUser.getSaldo() - valor);
			System.out.println("\n=============PAGAMENTO==============");
			System.out.println(
					"Transferência realizada com sucesso!\n------------------------------------\n*Seu saldo atual é de: "
							+ format.formatarMoeda(newUser.getSaldo()));
			System.out.println("====================================");
		}
	}
}