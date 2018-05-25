/*
 * 		Lista Duplamente Encadeada Ordenada
 * Autor: Luiz Fernando (Luizfcneto)
 * Email: Luizfcneto123@gmail.com
 * 
 * Descrição: Lista Duplamente Encadeada Ordenada é uma extensão de lista enceada
 * 	mas mantendo os seus dados ordenados por algum criterio comparavel.
 * 
 * 	Atributos da ListaDuplamenteEncadeada:
 * 		- Elo primeiro;
 * 		- //int tamanho;
 * 		
 * 		Atributos de Elo:
 * 			- int dado;
 * 			- Elo proximo;
 * 			- Elo anterior;
 * 	
 * 	Métodos da ListaDuplamenteEncadeada:
 * 		- public ListaDuplamenteEncadeadaOrdenada()
 * 		- public ListaDuplamenteEncadeadaOrdenada( int novo )
 * 		- private boolean vaziaOrdenada()
 * 		- public adicionaOrdenada( int novo )
 * 		- public removeOrdenada( int valor )
 * 		- public buscaOrdenada( int valor )
 * 		- public printaListaDuplamenteEncadeadaOrdenada()
 
 * 
 */

public class ListaDuplamenteEncadeadaOrdenada extends ListaDuplamenteEncadeada {

	Elo primeiro;
	
	public ListaDuplamenteEncadeadaOrdenada() {
		super();
	}
	
	//verifica se a lista está vazia
	public boolean verificaVazia() {
		if ( this.primeiro == null )
			return true;
		
		else 
			return false;
		
	}
	
	
	//adiciona ordenadamente o elemento na lista
	public void adicionaOrndenada( int elemento ) {
		
		//primeiro elemento
		if ( this.verificaVazia() ) {
			Elo novo = new Elo( elemento );
			this.primeiro = novo;
						
		}else {
			Elo auxiliar = new Elo();
			auxiliar = this.primeiro;
			Elo novo = new Elo( elemento );
			
			while ( auxiliar.dado < elemento && auxiliar.proximo != null ) {		
				auxiliar = auxiliar.proximo;
				
			}			
			novo.proximo = auxiliar;
			auxiliar.anterior.proximo = novo;				
			
		}		
				
	}
	
	//remove elemento da lista ordenada
	public void removeOrdenada( int elemento ) {
		if ( !this.verificaVazia() ) {
			Elo auxiliar = new Elo();
			auxiliar = this.primeiro;
			
			while( auxiliar.dado < elemento && auxiliar != null ) {
				auxiliar = auxiliar.proximo;
				
			}
			if ( auxiliar == null ) 
				System.out.println( "Elemento: "+ elemento +" não esta contido na lista!" );
			else {
				auxiliar.anterior.proximo = auxiliar.proximo;
				auxiliar.proximo.anterior = auxiliar.anterior; 
				System.out.println( "Elemento: "+ elemento +" removido com sucesso!\n" );
				
			}
			
		}else {
			System.out.println( "Lista Vazia!" );
			
		}
		
	}
	
	//busca elemento na lista
	public void buscaOrdenada( int elemento ) {
		if ( !this.verificaVazia() ) {
			int indice = 0;
			Elo auxiliar = new Elo();
			auxiliar = this.primeiro;
			
			while ( auxiliar.dado < elemento && auxiliar != null ) {
				
				indice++;
				auxiliar = auxiliar.proximo;
				
			}
			if ( auxiliar.dado == elemento ) 
				System.out.println (" \t\tBUSCA: \nIndice: [ "+ indice +" ]: Elemento:"+ auxiliar.dado );
			
			else
				System.out.println( "Elemento: "+ elemento + " não pertence a lista! " );
							
		}else 
			System.out.println( "Lista Vazia!" );
		
	}
	
	//printa a lista duplamente encadeada ordenada
	public void printaListaDuplamenteOrdenada() {
		if ( !this.verificaVazia() ) {
			int indice = 0;
			Elo auxiliar = new Elo();
			auxiliar = this.primeiro;
			System.out.println( "_______________________________________INICIO_______________________________________" );
			
			while ( auxiliar != null ) {
				
				System.out.println ("Indice: [ "+ indice +" ]: Elemento:"+ auxiliar.dado );			
				indice++;
				auxiliar = auxiliar.proximo;
			}
			System.out.println( "_______________________________________FINAL_______________________________________\n" );
			
		}else 
			System.out.println( "Lista Vazia!" );
		
		
	}
	
	
}
