package Listas;
/*
 * 		Lista Duplamente Encadeada
 * 	Autor: Luiz Fernando (Luizfcneto)
 * 	Email: Luizfcneto123@gmail.com
 * 	
 * 	Descricao: Lista Duplamente Encadeada pois alem de termos um 
 * 		ponteiro indicando o proximo elemento da Lista,
 * 		temos um ponteiro indicando seu elemento anterior. 
 * 		Dando mais facilidade na insercao de elementos e remocao
 * 	
 * 	Atributos da ListaDuplamenteEncadeada:
 * 		- Elo primeiro;
 *  		
 * 		Atributos de Elo:
 * 			- int dado;
 * 			- Elo proximo;
 * 			- Elo anterior;
 * 	
 * 	Metodos da ListaDuplamenteEncadeada:
 * 		- public ListaDuplamenteEncadeada()
 * 		- public ListaDuplamenteEncadeada( int novo )
 * 		- private boolean vazia()
 * 		- public adiciona( int novo )
 * 		- public remove( int valor )
 * 		- public busca( int valor )
 * 		- public printaListaDuplamenteEncadeada()
 */

public class ListaDuplamenteEncadeada {

	protected Elo primeiro;
	
	//Classe aninhada Elo
	protected class Elo{
		int dado;
		Elo proximo;
		Elo anterior;
		
		protected Elo() {
			this.proximo = null;
			this.anterior = null;
		}
		
		protected Elo( int dadoNovo ) {
			this.dado = dadoNovo;
			this.proximo = null;
			this.anterior = null;
		}
		
		protected Elo( int dado, Elo proximo ) {
			this.dado = dado;
			this.proximo = proximo;
			this.anterior = null;
		}
		
		protected Elo( int dado, Elo proximo, Elo anterior ) {
			this.dado = dado;
			this.proximo = proximo;
			this.anterior = anterior;
		}
		
	}
	
	//Construtor da ListaDuplamenteEncadeada
	public ListaDuplamenteEncadeada() {
		this.primeiro = null;
	}
	
	//verifica se ListaDuplamenteEncadeada esta vazia
	private boolean vazia() {
		if( this.primeiro == null )	
			return true;
		
		else	
			return false;
	}
	
	//adiciona Elemento na ListaDuplamenteEncadeada *NAO ordenado!
	public void adiciona( int novo ) {
		Elo auxiliar = new Elo( novo );
		
		//Se Lista estiver inicialmente vazia
		if ( this.vazia() ) {
			auxiliar.proximo = null;
			auxiliar.anterior = null;
			this.primeiro = auxiliar;
			
		} else {
			auxiliar.proximo = this.primeiro;
			auxiliar.anterior = null;
			this.primeiro.anterior = auxiliar;
			this.primeiro = auxiliar;
		}	
		
	}
	
	//remove Elemento da ListaDuplamenteEncadeada *NAO ordenado!
	public void remove( int valor ) {		
		
		//Verifica Lista Vazia
		if ( !this.vazia() ) {
			Elo auxiliar = new Elo();
			auxiliar = this.primeiro;
			
			//Se primeiro elemento, deve ser removido:
			if ( auxiliar.dado == valor ) {
				this.primeiro = auxiliar.proximo;
				auxiliar = this.primeiro;
				auxiliar.anterior = null;
				System.out.println( "Elemento: "+ valor +" removido com sucesso!\n" );
				
			}else {
				//procura na lista se o elemento pertence a ela e remova-o
				boolean presente = false;
				while ( auxiliar != null ) {
					auxiliar = auxiliar.proximo;
					if ( auxiliar.dado == valor ) {
						presente = true;
						break;
						
					}
					
				}
				if ( presente ) {		
					
					//se o elemento e o ultimo a ser removido
					if ( auxiliar.proximo == null ) {
						auxiliar.anterior.proximo = null;
						System.out.println( "Elemento: "+ valor +" removido com sucesso!\n" );
						
					}else {
						auxiliar.proximo.anterior = auxiliar.anterior;
						auxiliar.anterior.proximo = auxiliar.proximo;
						System.out.println( "Elemento: "+ valor +" removido com sucesso!\n" );
					}
					
				}else 
					System.out.println( "Elemento: "+ valor +" não encontrado na Lista! \n" );
		
			}
			
		} else 										
			System.out.println( "Lista Vazia! \n" );
		
	}
	
	//busca elemento na ListaDuplamenteEncadeada:
	public void busca( int valor ) {
		if ( !this.vazia() ) {
			int indice = 0;
			Elo auxiliar = new Elo();
			auxiliar = this.primeiro;
			
			while ( auxiliar.dado == valor && auxiliar != null ) {
				auxiliar = auxiliar.proximo;
				indice++;
			}
			if ( auxiliar != null ) 
				System.out.println (" \t\tBUSCA: \nIndice: [ "+ indice +" ]: Elemento:"+ auxiliar.dado +" \n");
			
			else
				System.out.println( "Elemento: "+ valor +" não pertence a lista! \n" );
		
		}else {
			System.out.println( "Lista Vazia!\n" );
			return;
		}
		
	}
	
	
	//Imprime na tela todos os elementos da ListaDuplamenteEncadeada
	public void printaListaDuplamenteEncadeada() {
		if ( !this.vazia() ) {
			int indice = 0;
			Elo auxiliar = new Elo();
			auxiliar = this.primeiro;
			System.out.println( "_______________________________________INICIO_______________________________________" );
			while ( auxiliar != null ) {
				System.out.println ("Indice: [ "+ indice +" ]: Elemento:"+ auxiliar.dado );
				auxiliar = auxiliar.proximo;
				indice++;
			}
			System.out.println( "_______________________________________FINAL_______________________________________\n" );
					
		} else {
			System.out.println( "Lista Vazia!\n" );
			return;
		}
		
	}
	
}
