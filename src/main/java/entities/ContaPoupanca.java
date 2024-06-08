package entities;

import exceptions.LimiteExpection;

public class ContaPoupanca extends Conta {

	public ContaPoupanca(Cliente cliente) {
		super(cliente);
	}

	@Override
	public void sacar(double valor) {
		if (valor <= 0)
			throw new IllegalArgumentException("Valor deve ser maior que zero!");

		if(valor <= getSaldo())
			setSaldo(getSaldo() - valor);
		else
			throw new LimiteExpection("Saldo insuficiente.");
	}

	@Override
	public void depositar(double valor) {
		if (valor <= 0)
			throw new IllegalArgumentException("Valor deve ser maior que zero!");

		setSaldo(getSaldo() + valor);
	}

	@Override
	public void imprimirExtrato() {
		System.out.println("=== Extrato Conta Poupança ===");
		super.imprimirInfosComuns();
		System.out.println("======== FIM  EXTRATO ========\n");
	}
}
