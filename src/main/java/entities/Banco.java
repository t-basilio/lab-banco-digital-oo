package entities;

import entities.interfaces.IBanco;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

@Getter
@Setter
public class Banco implements IBanco {

	private String nome;
	private List<Conta> contas;

	public Banco () {
		this.contas = new ArrayList<>();
	}
	public Banco (List<Conta> contas) {
		this.contas = contas;
	}

	@Override
	public void exibirClientes() {
		System.out.println("======   Clientes   ======");
		contas.forEach( c -> System.out
				.printf("%s de %s%n", c.getClass().getSimpleName(), c.getCliente().getNome()));
	}
}
