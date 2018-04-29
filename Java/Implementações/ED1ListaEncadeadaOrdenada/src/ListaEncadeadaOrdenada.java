/*	Lista Encadeada Ordenada
 * 
 * Descrição: Lista Encadeada Ordenada será literalmente uma Lista encadeada com elementos ordenados
 * 	para isso ela irá extender a classe ListaEncadeada para utilizar seus atributos e métodos
 * 
 * atributos: mesmo que ListaEncadeada
 * 	- Elo primeiro;
 * 	
 * 
 * métodos: mesmo que ListaEncadeada
 * 	- void adicionaOrdenado ( int novo );
 * 	- void buscaOrdenado ( int conteudo );
 * 	- void removeOrdenado ( int conteudo );
 * 	- void printaListaEncadeadaOrdenada ();
 */

public class ListaEncadeadaOrdenada extends ListaEncadeada {

	//adiciona Ordenado na lista encadeada Ordenada
	public void adicionaOrdenado( int novo ) {
		
		Elo auxiliar = new Elo();			//percorrerá a lista até encontrar um elemento maior que novo
		Elo anterior = new Elo();			//irá percorrer a lista antes do auxiliar
	
		auxiliar = this.primeiro;
		auxiliar = auxiliar.proximo;
		anterior = this.primeiro;				
		anterior.conteudo = novo;			
		
		//Problema [ quando so tiver um elemento na lista, deste modo ele ira adicionar um elemento maior no inicio ]
		while ( auxiliar != null && auxiliar.conteudo > novo ) {				
			auxiliar = auxiliar.proximo;
			anterior = anterior.proximo;
			
		}
		anterior.proximo = auxiliar;	
		
	}
	
	//remove da lista Encadeada ordenada 
	public boolean removeOrdenado ( int conteudo ) {
		
		if ( !this.listaVazia() ) {
			boolean presente = false;
			Elo auxiliar = new Elo();
			Elo anterior = new Elo();
			
			auxiliar = this.primeiro;
			auxiliar = auxiliar.proximo;
			anterior = this.primeiro;
			
			while ( auxiliar != null && auxiliar.conteudo > conteudo ) {
				
				if ( auxiliar.conteudo == conteudo ) {
					anterior.proximo = auxiliar.proximo;
					presente = true;
					break;
					
				}
								
				auxiliar = auxiliar.proximo;
				anterior = anterior.proximo;
			
			}
			
			if ( presente ) 
				return true;
			
			else {
				System.out.println( "Elemento não pertence a lista!" );
				return false;
			 
			}
			
		}else {
			System.out.println( "Lista Vazia!" );
			return false;
		}
		
	}
	
	//busca Ordenado na lista encadeada Ordenada
	public void buscaOrdenado( int conteudo ) {
		
		if ( !this.listaVazia() ) {
			boolean presente = false;
			int contador = 0;
			Elo auxiliar = new Elo();
			auxiliar = this.primeiro;
			
			while ( auxiliar != null ) {
				if ( auxiliar.conteudo == conteudo ) {
					System.out.println("[ "+ ( contador + 1 ) + " ] Elemento:" + auxiliar.conteudo );					
					presente = true;
				}
				
				contador++;
				auxiliar = auxiliar.proximo;
			
			}
			
			if( !presente )
				System.out.println("Elemento: "+ conteudo +" não pertence a lista" );
			
		}else 
			System.out.println( "Lista Vazia!" );
		
	}
	
	//printa lista encadeada Ordenada
	public void printaListaEncadeadaOrdenada() {
		
		if ( !this.listaVazia() ) { 
			
			int contador = 0;
			Elo auxiliar = new Elo( );
			auxiliar = this.primeiro;
			
			while ( auxiliar != null ) {
				System.out.println("Indice: " + contador + " Elemento: " + auxiliar.conteudo + " Hash: [ " + auxiliar + " ] " + " ---> " + auxiliar.proximo );
				auxiliar = auxiliar.proximo;
				contador++;
				
			}
		} else 
			System.out.println( "Lista Encadeada Vazia! " );
	
	}
	
}
