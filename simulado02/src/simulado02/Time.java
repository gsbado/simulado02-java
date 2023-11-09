package simulado02;

public class Time {
	protected String nome;
	protected Socio[] socios;


	public Time(String nome, int maxSocios) {
		this.nome = nome;
		this.socios = new Socio[maxSocios];
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public Socio[] getSocios() {
		return socios;
	}


	public void setSocios(Socio[] socios) {
		this.socios = socios;
	}

	public boolean insereSocio (Socio novosocio) {
		for (int i = 0; i < socios.length; i++) { //percorre todos o array dos sócios
			if (socios[i] == null) {
				socios[i] = novosocio;
				return true; //sócio inserido com sucesso
			}
		}
		return false; //falha ao inserir o sócio
	}
	
	
	public String socioMaisVelho() {
        int idadeSociomaisvelho = 0;
        String nomeSociomaisvelho = "";
        
        for (int i = 0; i < socios.length; i++) { //percorre todos o array dos sócios
            if (socios[i] != null && socios[i].getIdade() > idadeSociomaisvelho) {
                idadeSociomaisvelho = socios[i].getIdade();
                nomeSociomaisvelho = socios[i].getNome();
            }
            }
        return nomeSociomaisvelho; //nome e idade do sócio mais velho
    }

	public void imprimeSocios(){
        for (int i = 0; i < socios.length; i++) { //percorre todo o array de sócios
            System.out.println ("\n" + socios[i]); //imprime as informações de todos os sócios presentes na array
        }
    }
	
	@Override
	public String toString() {
		return "Time [Nome do time = " + nome + ", Quantidade de sócios = " + socios.length + "]";
	}
}
