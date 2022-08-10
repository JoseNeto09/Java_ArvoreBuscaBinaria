
public class NoAluno {
	
	int rgm;
	private String nome;
	NoAluno esquerda;
	NoAluno direita;
	
	NoAluno(int value, String nome) {
		this.rgm = value;
		this.nome = nome;
		esquerda = null;
		direita = null;
	}
	
	public String getNome() {
		return nome;
	}
	
	@Override
	public String toString() {
		return "(Nome: " + this.nome + "- RGM: " + this.rgm + ")";
	}

}
