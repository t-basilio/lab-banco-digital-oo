import entities.*;
import entities.interfaces.IConta;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		Cliente venilton = new Cliente("Venilton");
		Cliente thiago = new Cliente("Thiago");

		Conta contaCorrenteVanilton = new ContaCorrente(venilton);
		Conta poupancaValniton = new ContaPoupanca(venilton);
		Conta contaCorrenteThiago = new ContaCorrente(thiago);

		Banco banco = new Banco(Arrays.asList(contaCorrenteVanilton, poupancaValniton,contaCorrenteThiago));

		contaCorrenteVanilton.depositar(300);
		contaCorrenteThiago.depositar(1000);

		System.out.println("OPERAÇÃO: EXTRATO DAS CONTAS DO BANCO");
		banco.getContas().forEach(Conta::imprimirExtrato);

		System.out.println("OPERAÇÃO: CC VENILTON (R$800,00) -> POUP VENILTON");
		contaCorrenteVanilton.transferir(800, poupancaValniton);
		contaCorrenteVanilton.imprimirExtrato();
		poupancaValniton.imprimirExtrato();

		System.out.println("OPERAÇÃO: PP VENILTON (R$600,00) -> CC VENILTON");
		poupancaValniton.transferir(600, contaCorrenteVanilton);
		poupancaValniton.imprimirExtrato();
		contaCorrenteVanilton.imprimirExtrato();

		System.out.println("OPERAÇÃO: CC THIAGO (R$500,00) -> CC VENILTON");
		contaCorrenteThiago.transferir(500, contaCorrenteVanilton);
		contaCorrenteThiago.imprimirExtrato();
		contaCorrenteVanilton.imprimirExtrato();


		System.out.println("CLIENTES DO BANCO");
		banco.exibirClientes();

	}

}
