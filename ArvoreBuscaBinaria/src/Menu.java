import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.concurrent.TimeUnit;


public class Menu {
	
	public void mostrarMenu() {
		System.out.println("\n \t ALUNO: JOSE LOPES SOBRINHO NETO");
		System.out.println("\n \t DISCIPLINA: ESTRUTURA DE DADOS 1");
		System.out.println("\n \t PROFESSOR: WALACE BONFIM");
		System.out.println("\n \t EDITOR DE ARVORE \n");
		
		System.out.println("1 - INSERIR - Digite o RGM e o Nome.");
		System.out.println("2 - REMOVER - Digite o RGM a ser removido.");
		System.out.println("3 - PESQUISAR - Digite o RGM a ser pesquisado.");
		System.out.println("4 - ESVAZIAR - apaga todos os dados e arquivos.");
		System.out.println("5 - EXIBIR A ARVORE");
		System.out.println("0 - SAIR");
	}
	
	public void mostrarArvore(ArvoreBinariaBusca abb) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("1 - EXIBIR ARVORE E NO");
		System.out.println("2 - EXIBIR ARVORE PRE-ORDEM");
		System.out.println("3 - EXIBIR ARVORE POS-ORDEM");
		System.out.println("4 - EXIBIR ARVORE IN-ORDEM");
		
		int escolha = Integer.parseInt(br.readLine());
		
		switch (escolha) {
			case 1 : abb.exibirArvore(); break;
			case 2 : abb.exibirPreOrdem(); break;
			case 3 : abb.exibirPosOrdem(); break;
			default :abb.exibirEmOrdem(); break;
		}
	}
	
	public void LimpandoConsole() {
		 for(int i = 0; i < 3; i++) 
			 System.out.println();
	}
	
	private int checarRgmComoInteiro() throws IOException {
		
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			try {
				int rgm = Integer.parseInt(br.readLine());
				return rgm;
			} catch (NumberFormatException e) {
				System.out.println("Formato de RGM invalido!");
				System.out.println("Digite o RGM do aluno");
			}
		}
		
	}
	
	public int validandoRGM(ArvoreBinariaBusca abb) throws IOException {
		System.out.println("RGM: ");
		while(true) {
			int rgm = checarRgmComoInteiro();
			
			if (checarRgmExistente(abb, rgm)) {
				System.out.println("Esse rgm existe, digite um novo:");
				continue;
			}
			System.out.println("RGM validado!");
			return rgm;
		}
	}

	private boolean checarRgmExistente(ArvoreBinariaBusca abb, int rgm) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		if(abb.encontrarRGM(rgm)) return true;
		return false;
	}
	
	public String validandoNome() throws IOException {
		System.out.println("nome: ");
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		String nome = br.readLine();
		return nome;
	}
	
	public NoAluno procurarRgm(ArvoreBinariaBusca abb) throws IOException {
		System.out.println("Digite o rgm a procurar: ");
		int rgm = checarRgmComoInteiro();
		if(abb.encontrarAluno(rgm) != null) return abb.encontrarAluno(rgm);
		return null;
	}
	
}
