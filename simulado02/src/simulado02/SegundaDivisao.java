package simulado02;

public class SegundaDivisao extends Time {
	//atributos
	protected int anossegundona;

	public SegundaDivisao(String nome, int maxSocios, int anossegundona) {
		super(nome, maxSocios);
		this.anossegundona = anossegundona;
	}

	public int getAnossegundona() {
		return anossegundona;
	}

	public void setAnossegundona(int anossegundona) {
		this.anossegundona = anossegundona;
	}

	@Override
	public String toString() {
		return "Nome do time: " +nome+ "\nAnos seguidos na Segunda Divisão : " + anossegundona;
	}
}
