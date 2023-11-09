package simulado02;

public class Principal {

	public static void main(String[] args) {
		int x = 0;
		System.out.println("\n *** BEM VINDO AO SISTEMA DE CADASTROS DO BRASILEIRÃO ***");

		//array dos times com quantidade inserida pelo usuário
		while (true) {
			x = Teclado.leInt("\n Qual a quantidade de times que você gostaria de cadastrar? Por favor, digite um número entre 1 e 50");

			if (x >= 1 && x <= 50) {
				break; // valor inserido válido, interrompe o loop e cria o array
			}

			System.out.println("\n Quantidade inválida. Por favor, digite um número entre 1 e 50."); //valor inserido inválido, o usuário pode digitar novamente
		}

		Time[] times = new Time[x]; //criação do array de times


		//cadastro dos times presentes no array: o programa faz um loop para cada posição no array e solicita
		//ao usuário digitar as informações do time utilizando a classe Teclado
		for (int i = 0; i < times.length; i++) {
			//sorteio para determinar se o time é de segunda ou primeira divisão. Nessa expressão a condição é um valor booleano (true or false). No Math.random() o número aleatório vai ser entre 0 e 1, portanto as chances dele ser menor que 0.5 são 50%

			if (Math.random() < 0.5) { //time da primeira divisão
				String nome = Teclado.leString ("\nDigite o nome do time");
				int maxSocios = Teclado.leInt ("\nDigite a quantidade de sócios");
				int posicaoranking = Teclado.leInt ("\nDigite a posição do ranking na primeira divisão");
				times[i] = new PrimeiraDivisao (nome, maxSocios, posicaoranking);
			}
			else { //time da segunda divisão
				String nome = Teclado.leString ("\nDigite o nome do time");
				int maxSocios = Teclado.leInt ("\nDigite a quantidade de sócios");
				int anossegundona = Teclado.leInt ("\nDigite a quantidade de anos desse time na segunda divisão");
				times[i] = new SegundaDivisao (nome, maxSocios, anossegundona);

			}

		}

		//cadastro dos sócios: inserir 20 sócios em cada time do array
		//nome e idade são gerados automaticamente utilizando métodos que estão fora do método main
		for (int i = 0; i < times.length; i++) {
			for (int j = 0; j < 20; j++) {
				String nome = gerarNomeAleatorio();
				int idade = gerarIdadeAleatoria();

				Socio socio = new Socio (nome, idade);

				boolean inserido = times[i].insereSocio(socio);

				if(inserido)
					System.out.println("\nSócio cadastrado com sucesso!");
				else {
					System.out.println("Erro ao cadastrar sócio"); 
					break; }
				}
			}	
		
		//imprimir informações de todos os times e seus sócios
		for (int i = 0; i < times.length; i++) {
			System.out.println ("\nINFORMAÇÕES DO TIME");
			System.out.println (times[i]);
			Socio[] socios = times[i].getSocios();
			System.out.println("Número de sócios: " + socios.length);
		        }
		
		//programa executa um loop em cada posição do array para imprimir o nome do sócio mais velho de cada time do array
		for (int i = 0; i < times.length; i++) {
	    String socioMaisVelho = times[i].socioMaisVelho();
	    	if (socioMaisVelho != null) {
	        System.out.println("\nTime: " + times[i].getNome());
	        System.out.println("\nO sócio mais velho desse time é: " + socioMaisVelho);
	    	}
	    	else {
	        System.out.println("\nO time " + times[i].getNome() + " não possui sócios cadastrados.");
	    	}
		}

		//programa identifica qual o melhor time da primeira divisão
		PrimeiraDivisao melhorTime = null;

		//programa executa um loop para cada posição do array times e verifica se o time é uma instância de PrimeiraDivisao
		//se é, o programa compara a posição do time com a posição do time atualmente melhor colocado no ranking. O resultado é armazenado na variável melhorTime
		for (int i = 0; i < times.length; i++) {
		    if (times[i] instanceof PrimeiraDivisao) {
		        PrimeiraDivisao timeAtual = (PrimeiraDivisao) times[i];
		        if (melhorTime == null || timeAtual.getPosicaoranking() < melhorTime.getPosicaoranking()) {
		            melhorTime = timeAtual;
		        }
		    }
		}
				//depois de verificar, o programa imprime as informações desse time
				 if (melhorTime != null) {
					 System.out.println("\nInformações do time da primeira divisão melhor colocado no ranking:");
					 System.out.println("Nome do time: " + melhorTime.getNome());
					 System.out.println("Posição no ranking: " + melhorTime.getPosicaoranking());
				 } 
				 else {
					 System.out.println("\nNão há nenhum time da primeira divisao cadastrado nessa lista.");
				 }
			 }

		
		//gerar nomes aleatórios para os sócios
		private static String gerarNomeAleatorio() {
			String[] nomes = {"Joana", "Mario", "Elisandra", "Gumercindo", "Laisa", "Carlos Alberto", "Mariana", "Lázaro", "Celestina", "Bartolomeu", "Morgana", "Xandão", "Magnólia", "Mortícia", "Wando", "Guilherme", "Laura", "Beatriz", "Rafael", "Lucão"};
			int listaNomes = (int) (Math.random() * nomes.length);
			return nomes[listaNomes];
			}

		//gerar uma idade aleatória entre 18 e 80 anos para o sócio
		private static int gerarIdadeAleatoria() {
			int idade = (int) (Math.random() * 63) + 18; //+18 para sempre ser maior de 18 anos
			return idade; 
				}
}

		