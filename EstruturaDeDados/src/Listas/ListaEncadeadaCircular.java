package Listas;
/*		Lista Encadeada Circular
 * 	Autor: Luiz Fernando ( Luizfcneto )
 * 	Email: Luizfcneto123@gmail.com
 * 	
 * 	Descricao: Lista Encadeada Circular eh uma variante da estrutura de dados de Lista Encadeada
 * 	 o que muda: o ultimo elemento apontara para o primeiro.
 * 
 * 	Atributos / Caracteristicas:
 * 		- Elo primeiro (primeiro aponta para o primeiro elemento
 *	 	- tamanho
 * 
 * 
 * Metodos:
 * 		- void adicionaElemento( int conteudo )
 * 		- boolean removeElemento( int conteudo )
 * 		- void buscarElemento()
 * 		- boolean verificarListaVazia()
 * 		- imprimirLista()
 * 
 */

public class ListaEncadeadaCircular extends ListaEncadeada {

	//adiciona Elemento novo ( NO FINAL DA LISTA ) 
	void adicionaElemento( int conteudo ) {
		Elo novo = new Elo( conteudo );
				
		//lista vazia
		if ( this.listaVazia() ) {
			this.primeiro = novo;
			novo.proximo = novo;
		
		}else {
			
			// percorremos ate o final da fila para adicionar o elemento novo no fim da fila.
			Elo auxiliar = new Elo();
			auxiliar = this.primeiro;
			
			while ( auxiliar.proximo != this.primeiro ) {
				
				auxiliar = auxiliar.proximo;
			}
			novo.proximo = auxiliar.proximo;
			auxiliar.proximo = novo;
			
		}
		
	}
	
	//remove Elemento da Lista Encadeada Circular
	boolean removeElemento( int conteudo ) {
		
		//lista vazia
		if ( this.listaVazia() ) {
			System.out.println ( "O elemento:" + conteudo + " não consta na Lista" );
			return false;
			
		}else {
			
			Elo auxiliar = new Elo();
			auxiliar = this.primeiro;
			
			//lista com um elemento
			if ( auxiliar.proximo == null ) {
				
				this.primeiro = null;
				return true;
			
			}else {
				
				//lista com mais de um elemento
				Elo anterior = new Elo();
				boolean pertence = false;
				
				anterior = this.primeiro;
				auxiliar = this.primeiro;
				
				auxiliar = auxiliar.proximo;
				
				do {
					
					if ( auxiliar.conteudo == conteudo ) {
						pertence = true;
						anterior.proximo = auxiliar.proximo;
						break;
					}
					
					auxiliar = auxiliar.proximo;
					anterior = anterior.proximo;
				}while ( auxiliar.proximo != this.primeiro );
				
				if ( !pertence )
					return false;
				
				else 
					return true;
			}
		}	
		
	}
	
	//busca Elemento na Lista Encadeada Circular
	void buscaElemento( int conteudo ) {
		
		if ( this.listaVazia() ) {
			System.out.println( "Lista Vazia!\n" );
			
		}else {
			Elo auxiliar = new Elo();
			auxiliar = this.primeiro;
			boolean presente = false;
			int indice = 0;
			
			while ( auxiliar.proximo != this.primeiro ) {
				
				if ( auxiliar.conteudo == conteudo ) {
					System.out.println( "Indice: " + ( indice + 1 ) + " Conteudo: " + auxiliar.conteudo + "\n" );
					presente = true;
					break;
				}
				indice++;
				auxiliar = auxiliar.proximo;
			}
			if ( !presente ) 
				System.out.println( "O elemento:" + conteudo + " não consta na lista! \n");
			
		}
		
	}
	
	//printa Lista Encadeada Circular
	void printaListaEncadeadaCircular( ) {
		
		if ( this.listaVazia() )
			System.out.println( "Lista Vazia!\n" );
			
		else {
			Elo auxiliar = new Elo();
			auxiliar = this.primeiro;
			int indice = 0;
			System.out.println("___________________________________________INICIO___________________________________________");
			do {
				System.out.println( "Indice: " + ( indice + 1 ) + " Endereco: [ " + auxiliar  + " ] Conteudo: " + auxiliar.conteudo + " -----> [ " + auxiliar.proximo + " ]\n" );
				auxiliar = auxiliar.proximo;
				indice++;
			} while ( auxiliar != this.primeiro );
			System.out.println("___________________________________________FIM___________________________________________\n");
			
		}
		
	}
	
}
