package entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Cliente {

	private String nome;

	@Override
	public String toString() {
		return "Nome: " + nome;
	}
}
