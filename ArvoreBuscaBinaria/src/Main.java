import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException, InterruptedException {
		
		ArvoreBinariaBusca abb = new ArvoreBinariaBusca();
		TextoArquivo txt = new TextoArquivo("lista.txt");
		
		Menu menu = new Menu();
		Scanner sc = new Scanner(System.in);
		NoAluno aluno;
		txt.criarArvoreUsandoArquivo(abb);
			    
		boolean sair = true;
		
		while(sair) {
			
			menu.mostrarMenu();
			
			int captura = sc.nextInt();
			menu.LimpandoConsole();
			switch (captura) {
				case 1 : 
					System.out.println("Opcao escolhida 1 - INSERIR");
					int rgm = menu.validandoRGM(abb);
					String nome = menu.validandoNome();
					abb.add(rgm, nome);
					txt.EscrevendoNoArquivo(rgm + " " + nome);
					break;
					
				case 2 :
					System.out.println("Opcao escolhida 2 - REMOVER UM NO");
					aluno = menu.procurarRgm(abb);
					if(aluno == null) System.out.println("Aluno Não encontrado!");
					else {
						System.out.println("Aluno removido com sucesso!!!\n" + aluno);
						abb.deletar(aluno.rgm);
						txt.reescreverArquivo(abb);
					}
					break;
					
				case 3 : 
					System.out.println("Opcao escolhida 3 - PESQUISAR");
					aluno = menu.procurarRgm(abb);
					if(aluno == null) System.out.println("Aluno  encontrado!");
					else System.out.println("Aluno encontrado!\n" + aluno);
					break;
					
				case 4 :
					System.out.println("Opcao escolhida 4 - ESVAZIAR �RVORE");
					abb.esvaziarArvoreRecursivo();
					txt.apagarDadosDoArquivo();
					System.out.println("Arvore esvaziada com sucesso!");
					break;
					
				case 5 :
					System.out.println("Opcao escolhida 5 - EXIBIR ARVORE");
					menu.mostrarArvore(abb);
					break;
				default : sair = false;
			}
			
		}
		System.out.println("APLICACAO FINALIZADA, OBRIGADO!");
	    
	}
	
}
