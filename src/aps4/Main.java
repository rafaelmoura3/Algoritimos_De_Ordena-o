package aps4;

//import das classes de array e array list
//import java.util.Arrays;
import java.util.ArrayList;

//import exception (Necessária para a biblioteca de arquivos)
import java.io.IOException;

//importando biblioteca de leitura de arquivos
import java.io.File;

//importando biblioteca de escrita de arquivos
import java.io.PrintWriter;
import java.io.FileWriter;

//importando biblioteca para converter valores em long para data;
import java.text.SimpleDateFormat;

public class Main{
	 public static Janela j = new Janela();
	public static ListaImagens lista;
	public static Resumo arquivoResumo;
	public static void main(String[] args) throws IOException{ 
            
            
		String pastaImagens = "imagens";
		lista = new ListaImagens(pastaImagens);
		new File("relatorios").mkdir(); //cria a pasta relatorios, se já não foi criada.
		arquivoResumo = new Resumo();
		salvarArquivo("Arquivos Desordenados","",lista.imagens);
		System.out.println("Quantidade de imagens na pasta \""+pastaImagens+"\": "+lista.imagens.size()); //Imprime na tela apenas a quantidade de arquivos que existem na pasta (Essa linha não faz nada no sistema apenas mostra informação para deixar mais fácil o debug.)

		System.out.println();

		//Inicio das ordenações por tamanho da imagem
		System.out.println("\n Ordenações por tamanho do arquivo:");
			//selection sort 
			salvarArquivo("selection","tamanho",lista.imagens); 
			//fim selection sort

			//shell sort
			salvarArquivo("shell","tamanho",lista.imagens);
			//fim shell sort

			//insertion sort
			salvarArquivo("bubble","tamanho",lista.imagens);
			//insertion sort

			//bubble sort
			salvarArquivo("insertion","tamanho",lista.imagens);
			//bubble sort

			
		//Fim das ordenações por tamanho da imagem



		//Inicio da ordenações por nome da imagem
		System.out.println("\nOrdenações por nome do arquivo:");
			//selection sort - Nome Imagem
			salvarArquivo("selection","nome",lista.imagens);
			//selection sort - Nome Imagem

			//shell sort
			salvarArquivo("shell","nome",lista.imagens);
			//fim shell sort

			//insertion sort
			salvarArquivo("bubble","nome",lista.imagens);
			//insertion sort

			//bubble sort
			salvarArquivo("insertion","nome",lista.imagens);

			//bubble sort

			
		//Fim das ordenações por nome da imagem


		//Inicio das ordenações por data de modificação da imagem
		System.out.println("\nOrdenações por data do arquivo:");
			//selection sort - Nome Imagem
			salvarArquivo("selection","data",lista.imagens);
			//selection sort - Nome Imagem

			//shell sort
			salvarArquivo("shell","data",lista.imagens);
			//shell sort

			//insertion sort
			salvarArquivo("bubble","data",lista.imagens);
			//insertion sort

			//bubble sort
			salvarArquivo("insertion","data",lista.imagens);

			//bubble sort


		//Fim das ordenações por data de modificação da imagem


		System.out.println("\nPor favor, verifique a pasta relatorios para visualizar todos os dados.");
		Main.arquivoResumo.salvarArquivo();
	}

	private static void salvarArquivo(String nomeMetodo,String tipoOrdenacao, ArrayList<Imagem> imagensDesordenadas)  throws IOException{
		Sorts sorts = new Sorts();
		long tempoInicio = System.nanoTime();
		ArrayList<Imagem> imagens = sorts.sort(nomeMetodo,tipoOrdenacao,imagensDesordenadas);
		float tempoGasto =((float) (System.nanoTime() - tempoInicio))/1000000000;
		

		Main.arquivoResumo.escreverResumoMetodo(nomeMetodo,tipoOrdenacao,tempoGasto,sorts.getQuantidadeOperacoes());


		FileWriter arquivo = new FileWriter("relatorios/"+nomeMetodo+(!tipoOrdenacao.isEmpty()?" - "+tipoOrdenacao:"")+".txt"); //Cria um novo arquivo (se o arquivo já existir, ele será subistituido)
		PrintWriter gravarArquivo = new PrintWriter(arquivo); //um objeto feito para "Grava coisas no arquivo"


		gravarArquivo.println("Método "+nomeMetodo);
		gravarArquivo.printf("Tempo gasto: %.9f segundos.", tempoGasto);
		gravarArquivo.println();
		gravarArquivo.println("Quantidade de operações: "+sorts.getQuantidadeOperacoes());
		gravarArquivo.println();
		gravarArquivo.println();
		gravarArquivo.println("Arquivos ordenados:");
		System.out.printf("Tempo gasto "+nomeMetodo+": %.9f segundos.\n",tempoGasto);
		SimpleDateFormat conversorData = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

		for(int x=0;x<imagens.size();x++){
			gravarArquivo.printf("| %s |",conversorData.format(imagens.get(x).getDataModificacao()));
			gravarArquivo.printf(" %9d Bytes |",imagens.get(x).getTamanhoBytes());
			gravarArquivo.printf(" %-36s |",imagens.get(x).getNome());
			gravarArquivo.println();
		}

		arquivo.close(); 
	}

}
