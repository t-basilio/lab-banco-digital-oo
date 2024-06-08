package entities;

import exceptions.LimiteExpection;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ContaCorrente extends Conta {

	private final double VALOR_LIMITE = 500d;

	private double limite;

	public ContaCorrente(Cliente cliente) {
		super(cliente);
		this.limite = VALOR_LIMITE;
	}

	@Override
	public void depositar(double valor) {
		if (valor <= 0)
			throw new IllegalArgumentException("Valor deve ser maior que zero!");

		if (this.limite < VALOR_LIMITE)
			tratarDeposito(valor);
		else
			setSaldo(getSaldo() + valor);
	}

	@Override
	public void sacar(double valor) {
		if (valor <= 0)
			throw new IllegalArgumentException("Valor deve ser maior que zero!");

		if(valor < getSaldo())
			setSaldo(getSaldo() - valor);
		else if(valor <= getSaldo() + this.limite)
			tratarSaque(valor);
		else
			throw new LimiteExpection("Não há limite disponivel.");
	}

	@Override
	public void imprimirExtrato() {
		System.out.println("=== Extrato Conta Corrente ===");
		super.imprimirInfosComuns();
		System.out.printf("Limite: %.2f%n", this.limite);
		System.out.println("======== FIM  EXTRATO ========\n");
	}

	private void tratarSaque(double valor) {
		double negativo = getSaldo() - valor;
		this.limite += negativo;
		setSaldo(0d);
	}
	private void tratarDeposito(double valor) {
		if(valor > VALOR_LIMITE){
			setSaldo(valor - VALOR_LIMITE);
			this.limite = VALOR_LIMITE;

		} else
			this.limite = valor;
	}

}
