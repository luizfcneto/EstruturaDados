package Listas;
/*		Implementacao: Lista Duplamente Encadeada Circular
 * 	Autor: Luiz Fernando (Luizfcneto)
 * 	Email: Luizfcneto123@gmail.com
 * 	Descricao: E uma extensao de lista duplamente encadeada 
 * 	so que circular, o ultimo elemento aponta para o primeiro
 * 
 *  Atributos da ListaDuplamenteEncadeadaCircular:
 * 		- Elo primeiro;
 * 		
 * 		Atributos de Elo:
 * 			- int dado;
 * 			- Elo proximo;
 * 			- Elo anterior;
 * 	
 * 	Metodos da ListaDuplamenteEncadeadaCircular:
 * 		- public ListaDuplamenteEncadeadaCircular()
 * 		- public ListaDuplamenteEncadeadaCircular( int novo )
 * 		- private boolean verificaVazia()
 * 		- public adiciona( int novo )
 * 		- public remove( int valor )
 * 		- public busca( int valor )
 * 		- public printaListaDuplamenteEncadeada()
 * 
 */

public class ListaDuplamenteEncadeadaCircular extends ListaDuplamenteEncadeada{
	
	Elo primeiro;
	
	public ListaDuplamenteEncadeadaCircular() {
		super();
	}
	
	public boolean verificaVazia() {
		if ( this.primeiro == null )	
			return true;
		else 
			return false;
	}
	
	//adiciona Elemento na lista duplamente encadeada circular
	public void adicionaCircular( int novo ) {
		//Lista inicialmente Vazia
		if ( this.primeiro != null ) {
			Elo auxiliar = new Elo( novo );
			Elo ultimo;
			ultimo = this.primeiro.anterior;
			
			auxiliar.proximo = this.primeiro;
			auxiliar.anterior = ultimo;
			ultimo.proximo = auxiliar;
			this.primeiro.anterior = auxiliar;
			this.primeiro = auxiliar;		
			
		}else {
			Elo auxiliar = new Elo( novo );
			auxiliar.proximo = auxiliar;
			auxiliar.anterior = auxiliar;
			this.primeiro = auxiliar;
			
		}		
		
	}


	//remove um elemento da Lista Duplamente encadeada Circular
	public void removeCircular( int valor ) {
		if ( !this.verificaVazia() ) {
			//se o elemento a ser removido for o primeiro da lista:
			if ( this.primeiro.dado == valor ) {
				Elo auxiliar = new Elo();
				auxiliar = this.primeiro;
				auxiliar.anterior.proximo = auxiliar.proximo;
				auxiliar.proximo.anterior = auxiliar.anterior;
				auxiliar = auxiliar.proximo;
				this.primeiro = auxiliar;
				
			}else {
				Elo auxiliar = new Elo();
				auxiliar = this.primeiro;
				boolean presente = false;
				
				do {
					if ( auxiliar.dado == valor  ) {
						presente = true;
						break;
					}
					auxiliar = auxiliar.proximo;
					
				}while( auxiliar != this.primeiro ); 
				
				if ( presente ) {
					auxiliar.anterior.proximo = auxiliar.proximo;
					auxiliar.proximo.anterior = auxiliar.anterior;					
					System.out.println( "Elemento: "+ valor +" removido com sucesso!\n" );
				}else 
					System.out.println( "Elemento: "+ valor +" não encontrado na Lista! \n" );
			}
		}else 
			System.out.println( "Lista Vazia!" );

	}
	
	//Busca pelo elemento na ListaDuplamenteEncadeadaCircular 
	public void buscaCircular( int valor ) {
		if ( !this.verificaVazia() ) {
			int indice = 0;
			Elo auxiliar = new Elo();
			auxiliar = this.primeiro;
			
			do {
				if ( auxiliar.dado == valor ) {
					System.out.println( "Indice: [ "+ indice +" ] Elemento: "+ auxiliar.dado );
					break;
				}
				auxiliar = auxiliar.proximo;
				indice++;
			}while ( auxiliar != this.primeiro );			
		}else 
			System.out.println( "Lista Vazia!" );

	}	
	
	
	public void printaListaDuplamenteEncadeadaCircular() {
		if ( !this.verificaVazia() ) {
			int indice = 0;
			Elo auxiliar = new Elo();
			auxiliar = this.primeiro;
			System.out.println( "_______________________________________INICIO_______________________________________" );
			do {
				System.out.println( "Indice: [ "+ indice +" ] Elemento: "+ auxiliar.dado );
				auxiliar = auxiliar.proximo;
				indice++;
			}while ( auxiliar != this.primeiro );
			System.out.println( "_______________________________________FINAL_______________________________________\n" );
		}else 
			System.out.println( "Lista Vazia!" );
	}
	
}