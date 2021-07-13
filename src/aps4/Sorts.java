package aps4;

 import java.util.Arrays;
 import java.util.ArrayList;

public class Sorts{
  private long quantidadeOperacoes;
  public Sorts(){
    quantidadeOperacoes=0;
  }

  public ArrayList<Imagem> sort(String nomeSort,String tipoSort, ArrayList<Imagem>imagensRandomizadas){
    int tipo;
    switch(tipoSort){
      case "tamanho": tipo = 1;break;
      case "nome": tipo = 2;break;
      case "data": tipo = 3;break;
      default:tipo = 0;
    }

    switch(nomeSort){
      case "Arquivos Desordenados":
        return Main.lista.carregaImagens();
      case "selection":
        return selectionSort(imagensRandomizadas,tipo);
      case "shell":
        return shellSort(imagensRandomizadas,tipo);
      case "bubble":
        return bubbleSort(imagensRandomizadas,tipo);
      case "insertion":
        return insertionSort(imagensRandomizadas,tipo);
      case "anchor":
        return anchorSort(imagensRandomizadas,tipo);
      default:
        System.out.println("Não foi possível executar o algoritimo de ordenação.");
        return imagensRandomizadas;
    }

  }

  
  public ArrayList<Imagem> exemploSort(ArrayList<Imagem> imagens){ //retorna um ArrayList de Imagem, mas usa 'imagens' como parametro
    
    imagens.get(0).getNome(); ////retorna o parametro nome para ordenação
    imagens.get(0).getTamanhoBytes(); ///retorna o parametro tamanho para ordenação
    return imagens;
  }
////selectionSort
  public ArrayList<Imagem> selectionSort(ArrayList<Imagem> imagens, int tipo){


      for (int fixo = 0; fixo < imagens.size() - 1; fixo++) {
        int menor = fixo;
        for (int i = menor + 1; i < imagens.size(); i++){
          this.quantidadeOperacoes++;
          boolean checarMenor;
          if(tipo==2) checarMenor = checarSeArquivoEhAntes(imagens.get(menor),imagens.get(i));
          else if(tipo==1) checarMenor = imagens.get(i).getTamanhoBytes() < imagens.get(menor).getTamanhoBytes();
          else checarMenor = imagens.get(i).getDataModificacao() < imagens.get(menor).getDataModificacao();
          if(checarMenor){
              menor = i;
          }
        }
        if (menor != fixo) {
          // Troca
          Imagem t = imagens.get(fixo);
          imagens.set(fixo,imagens.get(menor));

          imagens.set(menor,t);
        }
      }
    return imagens;
  }


 

  // Shellsort 
  public ArrayList<Imagem> shellSort(ArrayList<Imagem> imagens,int tipo){
	  // cria laço de repetição para calcular o valor dos "pulos" (gap)
	  for(int gap = imagens.size()/2; gap > 0; gap /= 2){

		  // laço de repetição para comparar e organizar os valores
		  for (int i = gap; i < imagens.size(); i++){ // percorrendo a lista
        this.quantidadeOperacoes++;
			  Imagem tempVal = imagens.get(i); // recebe o valor temporÃ¡rio que vai ser comparado

			  int j; // variavel utilizada para procurar o valor a ser comparado

        if(tipo==2){
          // comparando os elementos por nome
          for (j = i; j >= gap && checarSeArquivoEhAntes(imagens.get(j - gap),tempVal); j -= gap){
            imagens.set(j, imagens.get(j - gap)); // troca
          }
        }else if(tipo==1){
  			  // comparando os elementos por tamanho
  			  for (j = i; j >= gap && tempVal.getTamanhoBytes() < imagens.get(j - gap).getTamanhoBytes(); j -= gap){
  				  imagens.set(j, imagens.get(j - gap)); // troca
  			  }
        }else{
  			  // comparando os elementos por tamanho
  			  for (j = i; j >= gap && tempVal.getDataModificacao() < imagens.get(j - gap).getDataModificacao(); j -= gap){
  				  imagens.set(j, imagens.get(j - gap)); // troca
  			  }
        }
			  imagens.set(j, tempVal); // troca
		  }
	  }
	  return imagens;
}
  /////bubbleSort
  public ArrayList<Imagem> bubbleSort(ArrayList<Imagem> imagens,int tipo){
  {
        imagens.get(0).getTamanhoBytes();

        boolean troca = true;
        Imagem aux;
        while (troca) {
            troca = false;
            for (int i = 0; i < imagens.size() - 1; i++)
            {
                this.quantidadeOperacoes++;
                boolean checarMenor;
                if(tipo==2) checarMenor = checarSeArquivoEhAntes(imagens.get(i),imagens.get(i + 1));
                else if(tipo==1) checarMenor = imagens.get(i).getTamanhoBytes() > imagens.get(i + 1).getTamanhoBytes();
                else checarMenor = imagens.get(i).getDataModificacao() > imagens.get(i + 1).getDataModificacao();
                if (checarMenor)
                {
                   aux = imagens.get(i);
                   imagens.set(i,imagens.get(i + 1));
                   imagens.set(i + 1,aux);
                   troca = true;
                }
            }
        }
  }
    return imagens;
  }
/////insertionSort
  public ArrayList<Imagem> insertionSort(ArrayList<Imagem> imagens, int tipo){
    for (int fixo = 0; fixo < imagens.size() - 1; fixo++) {
      int menor = fixo;

      for (int i = menor + 1; i < imagens.size(); i++){
        this.quantidadeOperacoes++;
        boolean checarMenor;
        if(tipo==2) checarMenor = checarSeArquivoEhAntes(imagens.get(menor),imagens.get(i));
        else if(tipo==1) checarMenor = imagens.get(i).getTamanhoBytes() < imagens.get(menor).getTamanhoBytes();
        else checarMenor = imagens.get(i).getDataModificacao() < imagens.get(menor).getDataModificacao();
        if (checarMenor){
    		    menor = i;
        }
      }
      if (menor != fixo) {
      	// Troca
        Imagem t = imagens.get(fixo);
        imagens.set(fixo,imagens.get(menor));
        imagens.set(menor,t);
      }
    }
    return imagens;
  }

    //AnchorSort
  
  
    public ArrayList<Imagem> anchorSort(ArrayList<Imagem> imagens,int tipo){
      for (int fixo = 0; fixo < imagens.size() - 1; fixo++) {
        int menor = fixo;

        for (int i = menor + 1; i < imagens.size(); i++){
          this.quantidadeOperacoes++;
          boolean checarMenor;
          if(tipo==2) checarMenor = checarSeArquivoEhAntes(imagens.get(menor),imagens.get(i));
          else if(tipo==1) checarMenor = imagens.get(i).getTamanhoBytes() < imagens.get(menor).getTamanhoBytes();
          else checarMenor = imagens.get(i).getDataModificacao() < imagens.get(menor).getDataModificacao();
          if (checarMenor){
              menor = i;
          }
        }
        if (menor != fixo) {
          // Troca
          Imagem t = imagens.get(fixo);
          imagens.set(fixo,imagens.get(menor));
          imagens.set(menor,t);
        }
      }
      return imagens;
    }

  /*****************************************************************************
   * Compara dois objetos Imagem com relação ao nome do arquivo.
   * Se o segundo arquivo deveria estar organizado antes do primeiro,
   * O método retorna true,
   * se não, retorna false.
   ****************************************************************************/
  public boolean checarSeArquivoEhAntes(Imagem primeiro, Imagem segundo){
    int compare = primeiro.getNome().compareTo(segundo.getNome());
    if(compare > 0) return true;
    else return false;
  }
  public long getQuantidadeOperacoes(){
    return this.quantidadeOperacoes;
  }

}
