package application;

import java.util.Scanner;

import entities.IR;
import entities.Usuario;
import services.Emprestimo;
import services.LoginConfirmacao;
import services.Pagamentos;
import services.format;

public class Program {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("\n======================");
		System.out.println("-BEM VINDO AO BANCO4U-");
		System.out.println("======================");

		int op, limiteTentativas = 0, menuOp, depoOp, empreOp, pagOp, tipo = 0, valor, voltar = 0, totalParcelas = 0;
		String confirmacaoSenha, cpf, tell, chave, email;
		double valorPag;

		Usuario newUser = new Usuario(null, null, 200);

		do {
			System.out.println("\n---LOGIN/CADASTRO---");
			System.out.println("(1) - Login ");
			System.out.println("(2) - Cadastro");
			System.out.println("(0) - Sair");
			System.out.println("--------------------");
			System.out.print("Digite aqui -->: ");
			op = sc.nextInt();

			Usuario admin = new Usuario("Admin", "Admin");

			switch (op) {
			case 1:// Login
				do {
					System.out.println("\n---LOGIN---");
					System.out.println("Usuário: ");
					System.out.print("Digite aqui -->: ");
					String nickUser = sc.next();

					System.out.println("Senha: ");
					System.out.print("Digite aqui -->: ");
					String senhaUser = sc.next();
					// if(nickUser.equals(nick) && senhaUser.equals(senha) ||
					// nickUser.equals(cadastroUser) && senhaUser.equals(cadastroSenha)){
					if (LoginConfirmacao.login(nickUser, senhaUser, admin.getName(), admin.getSenha())
							|| LoginConfirmacao.login(nickUser, senhaUser, newUser.getName(), newUser.getSenha())) {
						System.out.println("\n========================");
						System.out.println("---Bem vindo(a) " + nickUser + "--- ");
						System.out.println("========================");

						do {
							System.out.println("\n---MENU--- ");
							System.out.println("(1) - Depósito/Saque/Extrato");
							System.out.println("(2) - Empréstimo;");
							System.out.println("(3) - Calcular imposto de renda");
							System.out.println("(4) - Pagamentos");
							System.out.println("(0) - Voltar");
							System.out.println("----------");
							System.out.print("Digite aqui -->: ");

							menuOp = sc.nextInt();
							switch (menuOp) {
							case 1:// depositar/sacar/extrato

								System.out.println("\n---DEPÓSITO/SAQUE/EXTRATO--- ");
								do {
									System.out.println("(1) - Saque");
									System.out.println("(2) - Deposito");
									System.out.println("(3) - Extrato");
									System.out.println("(0) - Voltar");
									System.out.println("----------------------------");
									System.out.print("Digite aqui -->: ");
									depoOp = sc.nextInt();

									switch (depoOp) {
									case 1:// saque
										System.out.println("\nQuanto deseja sacar? ");
										System.out.println("------------------------");
										System.out.print("Digite aqui -->: ");
										double valorSacado = sc.nextDouble();
										newUser.saque(valorSacado);
										System.out.println("\n=============SAQUE==============");
										System.out.println(
												"Valor sacado!\n--------------------------------\n*Seu saldo atual é de: "
														+ format.formatarMoeda(newUser.getSaldo()));
										System.out.println("================================\n");

										break;
									case 2:// deposito
										System.out.println("\nQuanto deseja depositar? ");
										System.out.println("----------------");
										System.out.print("Digite aqui -->: ");
										double valorDepositado = sc.nextDouble();
										newUser.deposito(valorDepositado);
										System.out.println("\n============DEPÓSITO============");
										System.out.println(
												"Valor depositado!\n--------------------------------\n*Seu saldo atual é de: "
														+ format.formatarMoeda(newUser.getSaldo()));
										System.out.println("================================\n");
										break;
									case 3:// extrato
										System.out.println("\n===========SALDO================");
										System.out.println(
												"*Seu saldo atual é de: " + format.formatarMoeda(newUser.getSaldo()));
										System.out.println("================================\n");

										break;
									case 0:// sair
										System.out.println("\nVoltando a menu");
										break;
									default:
										System.out.println("Entre um valor válido entre 1, 2, 3 ou 0");
									}

								} while (depoOp != 0);

								break;
							case 2:// EMPRESTIMO
								System.out.println("\n---EMPRÉSTIMO--- ");
								do {
									System.out.println("(0) - voltar \nDigite um valor para simulação de emprestimo: ");
									System.out.println("----------------");
									System.out.print("Digite aqui -->: ");
									empreOp = sc.nextInt();

									if (empreOp == 0) {
										break;
									}

									if (empreOp != 0) {
										System.out.println("\nEm quantas parcelas deseja pagar?(12 a 60 parcelas!)");
										System.out.println("----------------");
										System.out.print("Digite aqui -->: ");
										totalParcelas = sc.nextInt();
									}

									if (empreOp <= 5000 && totalParcelas >= 12 && totalParcelas <= 60) {
										System.out.println("\n=========EMPRÉSTIMO==========");
										System.out.println("Total parcelas: " + totalParcelas + "\nValor empréstimo: "
												+ format.formatarMoeda(empreOp) + "\nTotal: "
												+ format.formatarMoeda(Emprestimo.parcelas(empreOp, totalParcelas))
												+ " Por parcela.");
										System.out.println("=============================");

										break;
									} else {
										System.out.println(
												"\n*Valor excede R$: 5000,00 ou o número de parcelas não é válido, por favor procure uma agência\n");
									}

									if (empreOp == 0) {
										System.out.println("Voltando ao menu");
									}
								} while (empreOp != 0);

								break;
							case 3:// imposto de renda
								int opc;

								IR ir1 = new IR(0, 0, 0, 0, 0, 0, 0);

								ir1.menu();
								opc = sc.nextInt();

								switch (opc) {
								case 1:
									ir1.simples();
									ir1.calculo();
									ir1.total();
									break;

								case 2:
									ir1.detalhada();
									ir1.calculo();
									ir1.total();
								}
								break;
							case 4:// pagamento
								do {
									System.out.println("\n---PAGAMENTOS---");
									System.out.println("(1) - Pix");
									System.out.println("(2) - Boleto");
									System.out.println("(3) - Cartão");
									System.out.println("(0) - Voltar");
									System.out.println("----------------");
									System.out.print("Digite aqui -->: ");
									pagOp = sc.nextInt();
									switch (pagOp) {
									case 1:

										System.out.println("\n---PIX---");
										System.out.println("Tipo de chave:");
										System.out.println("(1) - CPF/CNPJ");
										System.out.println("(2) - Chave aleatória");
										System.out.println("(3) - Telefone");
										System.out.println("(4) - E-mail");
										System.out.println("(0) - Voltar");
										System.out.println("----------------");
										System.out.print("Digite aqui -->: ");
										tipo = sc.nextInt();

										switch (tipo) {
										case 1:
											System.out.print("\nDigite aqui o CPF/CNPJ: ");
											cpf = sc.next();
											System.out.print("Qual o valor da transferência?: ");
											valorPag = sc.nextDouble();
											Pagamentos.testeSaldo(valorPag, newUser);
											break;
										case 2:
											System.out.print("\nDigite aqui a Chave aleatória: ");
											chave = sc.next();
											System.out.print("Qual o valor da transferência?: ");
											valorPag = sc.nextDouble();
											Pagamentos.testeSaldo(valorPag, newUser);
											break;
										case 3:
											System.out.print("\nDigite aqui a número de telefone: ");
											chave = sc.next();
											System.out.print("Qual o valor da transferência?: ");
											valorPag = sc.nextDouble();
											Pagamentos.testeSaldo(valorPag, newUser);
											break;
										case 4:
											System.out.print("\nDigite aqui o e-mail: ");
											chave = sc.next();
											System.out.print("Qual o valor da transferência?: ");
											valorPag = sc.nextDouble();
											Pagamentos.testeSaldo(valorPag, newUser);
											break;
										case 0:
											break;
										default:
											System.out.println("\nOpção inválida!\n");
											break;
										}
										break;

									case 2:
										String p1, p2, p3, p4, p5;
										System.out.println("\n---BOLETO---");
										System.out.println("Novo pagamento:");
										System.out.print("Digite a 1ª parte: ");
										p1 = sc.next();
										System.out.print("Digite a 2ª parte: ");
										p2 = sc.next();
										System.out.print("Digite a 3ª parte: ");
										p3 = sc.next();
										System.out.print("Digite a 4ª parte: ");
										p4 = sc.next();
										System.out.print("Digite a 5ª parte: ");
										p5 = sc.next();
										System.out.println("\n(1) - Continuar");
										System.out.println("(0) - Voltar");
										System.out.println("----------------");
										System.out.print("Digite aqui -->: ");
										voltar = sc.nextInt();

										switch (voltar) {
										case 1:
											System.out.print("Qual o valor da transferência?: ");
											valorPag = sc.nextDouble();
											Pagamentos.testeSaldo(valorPag, newUser);
											break;
										case 0:
											break;
										default:
											System.out.println("\nOpção inválida!\n");
											break;
										}
										break;
									case 3:
										String nome, numero, datavali;
										int cvv;
										System.out.println("\n---CARTÃO---");
										System.out.println("Novo pagamento:");
										System.out.print("Qual o nome do titular?: ");
										nome = sc.next();
										System.out.print("Qual o número do cartão?: ");
										numero = sc.next();
										System.out.print("Qual a data de validade?: ");
										datavali = sc.next();
										System.out.print("Qual o CVV?: ");
										cvv = sc.nextInt();

										System.out.print("Qual o valor da transferência?: ");
										valorPag = sc.nextDouble();
										Pagamentos.testeSaldo(valorPag, newUser);

										break;
									case 0:
										System.out.println("\nPagamento finalizado!");
										break;
									default:
										System.out.println("\nOpção inválida!\n");
										break;

									}
								} while (pagOp != 0);
								// while (pagOp != 0 || tipo != 0 || voltar != 0);

								break;
							default:

							}
						} while (menuOp != 0);
						break;
					} else {
						System.out.println("\n*DADOS INCORRETOS !!! (tentativa(" + (limiteTentativas + 1) + "/3))");
						limiteTentativas++;
					}

					if (limiteTentativas >= 3) {
						System.out.println("\n===============================================");
						System.out.println("Limite de tentativas atingido, conta bloqueada!");
						System.out.println("===============================================");

						System.exit(0);
					}
				} while (limiteTentativas <= 3);

				break;
			case 2:// cadastro
				do {
					System.out.println("\n---CADASTRO---");
					System.out.println("Usuário:");
					System.out.print("Digite aqui -->: ");
					newUser.setName(sc.next());

					System.out.println("Senha:");
					System.out.print("Digite aqui -->: ");
					newUser.setSenha(sc.next());

					System.out.println("Confirme sua senha:");
					System.out.print("Digite aqui -->: ");
					confirmacaoSenha = sc.next();

					if (!confirmacaoSenha.equals(newUser.getSenha())) {
						System.out.println("\n*AS SENHAS NÃO COINCIDEM!");
					}
				} while (!confirmacaoSenha.equals(newUser.getSenha()));

				System.out.println("\n*Usuário cadastrado com sucesso!");
				break;
			case 0:
				System.out.println("\n==================================");
				System.out.println("Obrigado por utilizar o BANCO4U!!!");
				System.out.println("==================================");

				break;
			default:
				System.out.println("\n*Opção inválida!!! (digite 1, 2 ou 0)");
			}

		} while (op != 0);
		sc.close();
	}
}