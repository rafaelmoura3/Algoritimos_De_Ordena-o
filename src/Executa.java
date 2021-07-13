/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author megas
 */
public class Executa {
    
    public void Executa (){
     
            
            
            
            
            
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
		Executa.arquivoResumo.salvarArquivo();
    
    
    }
    
}
