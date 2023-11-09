package simulado02;

public class PrimeiraDivisao extends Time {
	//atributos
	protected int posicaoranking; //posição no ranking da primeira divisão

	public PrimeiraDivisao(String nome, int maxSocios, int posicaoranking) {
		super(nome, maxSocios);
		this.posicaoranking = posicaoranking;
	}

	public int getPosicaoranking() {
		return posicaoranking;
	}

	public void setPosicaoranking(int posicaoranking) {
		this.posicaoranking = posicaoranking;
	}

	@Override
	public String toString() {
		return "Nome do time: " +nome+ "\nPosição no ranking da Primeira Divisão : " + posicaoranking;
	}
}
