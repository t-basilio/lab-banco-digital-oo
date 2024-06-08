import entities.*;
import entities.interfaces.IConta;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		Cliente venilton = new Cliente("Venilton");
		Cliente thiago = new Cliente("Thiago");

		Conta contaCorrenteVenilton = new ContaCorrente(venilton);
		Conta poupancaValniton = new ContaPoupanca(venilton);
		Conta contaCorrenteThiago = new ContaCorrente(thiago);

		Banco banco = new Banco(Arrays.asList(contaCorrenteVenilton, poupancaValniton,contaCorrenteThiago));

		contaCorrenteVenilton.depositar(300);
		contaCorrenteThiago.depositar(1000);

		System.out.println("OPERAÇÃO: EXTRATO DAS CONTAS DO BANCO");
		banco.getContas().forEach(Conta::imprimirExtrato);

		System.out.println("OPERAÇÃO: CC VENILTON (R$800,00) -> POUP VENILTON");
		contaCorrenteVenilton.transferir(800, poupancaValniton);
		contaCorrenteVenilton.imprimirExtrato();
		poupancaValniton.imprimirExtrato();

		System.out.println("OPERAÇÃO: PP VENILTON (R$600,00) -> CC VENILTON");
		poupancaValniton.transferir(600, contaCorrenteVenilton);
		poupancaValniton.imprimirExtrato();
		contaCorrenteVenilton.imprimirExtrato();

		System.out.println("OPERAÇÃO: CC THIAGO (R$1300,00) -> CC VENILTON");
		contaCorrenteThiago.transferir(1300, contaCorrenteVenilton);
		contaCorrenteThiago.imprimirExtrato();
		contaCorrenteVenilton.imprimirExtrato();

		System.out.println("OPERAÇÃO: CC VENILTON (R$600,00) -> CC THIAGO");
		contaCorrenteVenilton.transferir(600, contaCorrenteThiago);
		contaCorrenteVenilton.imprimirExtrato();
		contaCorrenteThiago.imprimirExtrato();

		System.out.println("CLIENTES DO BANCO");
		banco.exibirClientes();

	}

}
