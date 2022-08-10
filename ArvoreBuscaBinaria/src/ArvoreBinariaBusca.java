import java.util.ArrayList;
import java.util.List;

public class ArvoreBinariaBusca {
	
	private NoAluno raiz;
	
	private NoAluno add(NoAluno atual, int valor, String nome) {
		
		if (atual == null) return new NoAluno(valor, nome);
		
		if (valor < atual.rgm) atual.esquerda = add(atual.esquerda, valor, nome);
		
		else if (valor > atual.rgm) atual.direita = add(atual.direita, valor, nome);
		
		else return atual;
		
		return atual;
	}
	
	public void add(int valor, String nome) {
		raiz = add(raiz, valor, nome);
	}
	
	private boolean encontrarRgm(NoAluno noAtual, int rgmProcurado) {
		if (noAtual == null) return false;
		if (rgmProcurado == noAtual.rgm) return true;
		
		return rgmProcurado < noAtual.rgm ? encontrarRgm(noAtual.esquerda, rgmProcurado) : encontrarRgm(noAtual.direita, rgmProcurado);
	}
	
	public boolean encontrarRGM(int rgmProcurado) {
		return encontrarRgm(raiz, rgmProcurado);
	}
	
	private NoAluno encontrarAluno(NoAluno noAtual, int rgmProcurado) {
		if (noAtual == null) return null;
		if (rgmProcurado == noAtual.rgm) return noAtual;
		
		return rgmProcurado < noAtual.rgm ? encontrarAluno(noAtual.esquerda, rgmProcurado) : encontrarAluno(noAtual.direita, rgmProcurado);
	}
	
	public NoAluno encontrarAluno(int rgmProcurado) {
		return encontrarAluno(raiz, rgmProcurado);
	}
	
	private int encontrarMenorValor(NoAluno atual) {
		return atual.esquerda == null ? atual.rgm : encontrarMenorValor(atual.esquerda);
	}
	
	private NoAluno deletarRecursivo(NoAluno atual, int DeletarRGM) {
		if (atual == null) {
			System.out.println("Aluno nao encontrado! Nenhum no deletado.");
			return null;
		}
		if (DeletarRGM == atual.rgm) {
			
			// nenhum filho
			if (atual.esquerda == null && atual.direita == null) return null;
			
			// unico filho
			if (atual.direita == null) return atual.esquerda;
			if (atual.esquerda == null) return atual.direita;
			
			int menorValor = encontrarMenorValor(atual.direita);
			atual.rgm = menorValor;
			atual.direita = deletarRecursivo(atual.direita, menorValor);
			return atual;
		}
		
		if (DeletarRGM < atual.rgm) {
			atual.esquerda = deletarRecursivo(atual.esquerda, DeletarRGM);
			return atual;
		}
		
		atual.direita = deletarRecursivo(atual.direita, DeletarRGM);
		
		return atual;
	}
	
	public void deletar(int valor) {
		raiz = deletarRecursivo(raiz, valor);
	}
	
	private void mostrarEmOrdemRecursivo(NoAluno raiz) {
	    if (raiz != null) {
	    	mostrarEmOrdemRecursivo(raiz.esquerda);
	        System.out.println(raiz);
	        mostrarEmOrdemRecursivo(raiz.direita);
	    }
	}
	
	public void exibirEmOrdem() {
		System.out.println("EXIBINDO IN-ORDEM");
		mostrarEmOrdemRecursivo(raiz);
	}
	
	private void exibirPreOrdem(NoAluno raiz) {
	    if (raiz != null) {
	    	System.out.println(raiz);
	    	exibirPreOrdem(raiz.esquerda);
	    	exibirPreOrdem(raiz.direita);
	    }
	}
	
	private void dadosDaArvoreEmString(NoAluno raiz, List<String> li) {
		if (raiz != null) {
	    	li.add(raiz.rgm + " " + raiz.getNome() + "\n");
	    	dadosDaArvoreEmString(raiz.esquerda, li);
	    	dadosDaArvoreEmString(raiz.direita, li);
		}
	}
	
	public String dadosDaArvoreEmString() {
		ArrayList<String> lista = new ArrayList<String>();
		dadosDaArvoreEmString(raiz, lista);
		String dados = "";
		for(String usuario : lista) dados += usuario;
		return dados;
	}

	public void exibirPreOrdem() {
		System.out.println("EXIBINDO PRÉ-ORDEM");
		exibirPreOrdem(raiz);
	}
	
	private void exibirPosOrdem(NoAluno raiz) {
		if(raiz != null) {
			exibirPosOrdem(raiz.esquerda);
			exibirPosOrdem(raiz.direita);
			System.out.println(raiz);
		}
	}
	
	public void exibirPosOrdem() {
		System.out.println("EXIBINDO PÓS-ORDEM");
		exibirPosOrdem(raiz);
	}
	
	private void mostrarArvore(NoAluno atual) {
		if (this.contador == 0) System.out.println("Raiz: " + atual);
		else System.out.println(atual);
		
		this.contador++;
		if (atual.esquerda != null) {
			System.out.print("\t".repeat(Math.max(0, contador)) + "|______> Nó esquerda: ");
			mostrarArvore(atual.esquerda);
		}
		
		if (atual.direita != null) {
			System.out.print("\t".repeat(Math.max(0, contador)) + "|______> Nó direita: ");
			mostrarArvore(atual.direita);
		}
		
		this.contador--;
	}
	
	private int contador = 0;
	public void exibirArvore() {
		this.contador = 0;
		if(raiz == null) System.out.println("Arvore Vazia");
		else mostrarArvore(raiz);
	}
	
	private void esvaziarArvore(NoAluno raiz) {
		if(raiz != null) {
			esvaziarArvore(raiz.esquerda);
			esvaziarArvore(raiz.direita);
			this.raiz = null;
		}
	}
	
	public void esvaziarArvoreRecursivo() {
		esvaziarArvore(raiz);
	}
}
