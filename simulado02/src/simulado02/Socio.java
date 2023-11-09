package simulado02;

public class Socio {
	protected String nome;
	protected int idade;
	
	//método construtor
	public Socio(String nome, int idade) {
		this.nome = nome;
		this.idade = idade;
	}

	//getters e setters
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}
	
	//método toString
	@Override
	public String toString() {
		return "Socio [nome=" + nome + ", idade=" + idade + "]";
	}

	
}
