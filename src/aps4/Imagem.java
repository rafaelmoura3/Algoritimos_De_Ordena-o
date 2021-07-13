package aps4;

//importa classe de arquivos -> http://docs.oracle.com/javase/8/docs/api/java/io/File.html
import java.io.File;


public class Imagem{
	//variaveis do objeto
	private String nomeArquivo; //nome do arquivo da imagem (teste.jpg)
	private long tamanhoBytes,//tamanho do arquivo em bytes 
	data; //data de modificação do arquivo, em formato long 

	//método construtor (carrega o local do arquivo: Ex: "nomePasta/teste.jpg")
	public Imagem(String localArquivo){
		File arquivo = new File(localArquivo); //cria um objeto do tipo file
		if(arquivo.exists() && arquivo.isFile()){ //verifica se o arquivo existe e se ele nÃ£o Ã© uma pasta
			this.nomeArquivo = arquivo.getName(); //define nomeArquivo como o nome do arquivo carregado (teste.jpg)
			this.tamanhoBytes =arquivo.length(); //define tamanhoBytes como o tamanho do arquivos em bytes.
			this.data = arquivo.lastModified(); // define data como a ultima data de modificação do arquivo
		}else if(!arquivo.isFile()){}//caso o arquivo seja um pasta, ele mostra esse erro.
		else{	//caso o arquivo não exista, ele mostra esse erro.
			System.out.println("Arquivo nÃ£o pode ser carregado.");
		}
	}

	//getters
	public String getNome(){ //retorna no nome do arquivo (teste.jpg)
		return this.nomeArquivo;
	}
	public long getTamanhoBytes(){ //retorna o tamanho do arquio em bytes (324)
		return this.tamanhoBytes;
	}
	public long getDataModificacao(){
		return this.data;
	}

}
