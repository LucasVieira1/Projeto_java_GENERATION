package entities;

public class Usuario {

	private String name;
	
	private String senha;
	
	private double saldo;

	public Usuario(String name, String senha) {
		super();
		this.name = name;
		this.senha = senha;
	}
	
	public Usuario(String name, String senha, double saldo) {
		super();
		this.name = name;
		this.senha = senha;
		this.saldo = saldo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	
	public void deposito(double quantia) {
		this.saldo += quantia;
	}
	
	public void saque(double quantia) {
		if(quantia > this.saldo) {
			String erro = "Você tentou sacar um valor acima do seu saldo";
			throw new IllegalStateException(erro);
		}else {
			this.saldo -= quantia;
		}
	}
}
