/*		Lista Encadeada Circular
 * 	Autor: Luiz Fernando ( Luizfcneto )
 * 	Email: Luizfcneto123@gmail.com
 * 	
 * 	Descrição: Lista Encadeada Circular é uma variante (extensao) da estrutura de dados de Lista Encadeada
 * 	 o que muda: o ultimo elemento apontará para o primeiro.
 * 
 * 	Atributos / Caracteristicas de ListaEncadeadaCircular:
 * 		- Elo primeiro (primeiro aponta para o primeiro elemento )
 *	 	- //int tamanho 
 * 	
 * 		Atributos de Elo:
 * 			- int dado;
 * 			- Elo proximo;
 * 
 * Métodos de ListaEncadeadaCircular:
 * 		- Lista5:
 * 			- Q01: listaEncadeadaCircular ( ListaEncadeada lista );
 * 			- Q02: transfereListaCircular ( ListaEncadeadaCircular l2 ); 
 * 
 * 		- void adicionaElemento( int conteudo )
 * 		- boolean removeElemento( int conteudo )
 * 		- void buscarElemento()
 * 		- boolean verificarListaVazia()
 * 		- imprimirLista()
 * 
 */

public class ListaEncadeadaCircular extends ListaEncadeada {

	
	
	//Questão 1 - Lista 5 Construtor de uma lista encadeada circular que transforma um parametro de uma lista encadeada em uma circular.
	public ListaEncadeadaCircular ( ListaEncadeada lista ) {
		if ( lista.listaVazia() ) {
			System.out.println( "Lista vazia!" );
			return;
			
		}else {
			Elo auxiliar, primeiroCircular;
			primeiroCircular = lista.primeiro;
			auxiliar = lista.primeiro;
			this.primeiro = auxiliar;
			
			while ( auxiliar.proximo != null ) 
				auxiliar = auxiliar.proximo;
			
			auxiliar.proximo = primeiroCircular;
			
		}
		
	}

	//Questão 02: transfere elementos de uma listaB para listaA apagando a listaB O(1) -> constante
	void transfereListaCircular( ListaEncadeadaCircular listaB ) {
		if ( listaB.listaVazia() ) {
			System.out.println( "Lista vazia");
			return;
		
		//Modo1: 
		}else {
			Elo auxiliarB, primeiroB, auxiliarA;
			auxiliarA = this.primeiro;
			primeiroB = listaB.primeiro;
			auxiliarB = listaB.primeiro;
			auxiliarB = auxiliarB.proximo;
			
			do {
				listaB.primeiro.proximo = auxiliarA.proximo; 
				auxiliarA.proximo = listaB.primeiro;
				listaB.primeiro = auxiliarB;
				auxiliarB = auxiliarB.proximo;
				
			} while ( auxiliarB != primeiroB.proximo );
			
			listaB.primeiro = null;
			
		}
		//MODO 2:
//		}else {
//			Elo auxiliarB = listaB.primeiro;
//			Elo parada = listaB.primeiro;
//			do {
//				this.adicionaElemento( auxiliarB.conteudo );
//				listaB.removeElemento( auxiliarB.conteudo );
//				auxiliarB = auxiliarB.proximo;
//			}while ( auxiliarB != parada );			
//			
//			parada = null;
//			auxiliarB = null;
//			listaB.primeiro = null;
//		}
		
	}
	
	public ListaEncadeadaCircular() {
		this.primeiro = null;
		
	}
	
	
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
				//remove o primeiro elemento
				if ( this.primeiro.conteudo == conteudo ) {
					Elo ultimo;
					do {
						auxiliar = auxiliar.proximo;
					}while ( auxiliar.proximo != this.primeiro );
					
					ultimo = auxiliar.proximo;
					auxiliar = this.primeiro;
					
					
					this.primeiro = auxiliar.proximo;
					ultimo.proximo = auxiliar.proximo;
					return true;
				}				
				
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
				System.out.println( "Indice: " + indice  + " Conteudo: " + auxiliar.conteudo );
				auxiliar = auxiliar.proximo;
				indice++;
				
			} while ( auxiliar != this.primeiro );
			
			System.out.println("___________________________________________FIM___________________________________________\n");
			
		}
		
	}
	
}
