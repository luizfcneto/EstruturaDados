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
	public void adicionaOrdenada( int elemento ) {
		Elo auxiliar = new Elo();
		auxiliar = this.primeiro;
		
		//primeiro elemento
		if ( this.verificaVazia() ) {
			Elo novo = new Elo( elemento );
			this.primeiro = novo;
			
		//adiciona no inicio da lista
		}else if ( elemento < auxiliar.dado ) {
			Elo novo = new Elo( elemento );
			novo.anterior = auxiliar.anterior;
			novo.proximo = auxiliar;
			auxiliar.anterior = novo;
			this.primeiro = novo;
			
		} else {
			Elo novo = new Elo( elemento );
			boolean adicionado = false;
			
			while ( auxiliar.proximo != null ) {							
				if ( elemento < auxiliar.dado ) {
					novo.proximo = auxiliar;
					novo.anterior = auxiliar.anterior;
					auxiliar.anterior.proximo = novo;
					auxiliar.anterior = novo;
					adicionado = true;
					break;
					
				}
				auxiliar = auxiliar.proximo;
				
			}
			if ( !adicionado ) {
				novo.anterior = auxiliar;
				novo.proximo = auxiliar.proximo;
				auxiliar.proximo = novo;
				
			}
			
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
			
			while ( auxiliar.dado != elemento && auxiliar != null ) {
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
