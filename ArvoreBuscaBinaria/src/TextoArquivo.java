import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;


public class TextoArquivo {
	
	private String nomedoArquivo;
	
	TextoArquivo(String nomedoArquivo){
		String fileName = nomedoArquivo;
		try{
			File myobj = new File(fileName);
			myobj.createNewFile();
			this.nomedoArquivo = nomedoArquivo;
		}catch (IOException e) {
			System.out.println("Erro");
			e.printStackTrace();
		}
	}
	
	public void EscrevendoNoArquivo(String texto) {
		try {
			FileWriter myWriter = new FileWriter(this.nomedoArquivo, true);
			myWriter.write(texto + "\n");
			myWriter.close();
			System.out.println("Dados Enserido!!");
		} catch (IOException e){
			System.out.println("Erro");
		}
	}
	
	public String nomedoArquivo() {
		return this.nomedoArquivo;
	}
	
	
	public void criarArvoreUsandoArquivo(ArvoreBinariaBusca abb) throws NumberFormatException, IOException {
	    try {
	    	FileReader fr= new FileReader(this.nomedoArquivo);    
	    	BufferedReader br=new BufferedReader(fr);  
	        
	        String data;
	        while ((data = br.readLine()) != null) {
	        	int rgm = Integer.parseInt(data.substring(0, data.indexOf(" ")));
	        	String nome = data.substring(data.indexOf(" "));
	        	abb.add(rgm, nome);
	        }
	        br.close();
	      } catch (FileNotFoundException e) {
	        System.out.println("Erro");
	        e.printStackTrace();
	      }
	}
	
	public void reescreverArquivo(ArvoreBinariaBusca abb) throws FileNotFoundException {
		apagarDadosDoArquivo();
		try {
	        FileWriter myWriter = new FileWriter(this.nomedoArquivo, true);
	        myWriter.write(abb.dadosDaArvoreEmString());
	        myWriter.close();
		} catch (IOException e) {
	        System.out.println("Erro");
	        e.printStackTrace();
	     }
	}
	
	public void apagarDadosDoArquivo() throws FileNotFoundException {
		File file = new File(this.nomedoArquivo);
		PrintWriter writer = new PrintWriter(file);
		writer.print("");
		writer.close();
	}
	
}
