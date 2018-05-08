/*	Lista Encadeada Ordenada
 * 
 * Descrição: Lista Encadeada Ordenada será literalmente uma Lista encadeada com elementos ordenados
 * 	para isso ela irá extender a classe ListaEncadeada para utilizar seus atributos e métodos
 * 
 * atributos: mesmo que ListaEncadeada
 * 	- Elo primeiro;
 * 	- int tamanho ( extendido de ListaEncadeada );
 * 	
 * 
 * métodos: mesmo que ListaEncadeada
 * 	- void adicionaOrdenado ( int novo );
 * 	- void buscaOrdenado ( int conteudo );
 * 	- boolean removeOrdenado ( int conteudo );
 * 	- void printaListaEncadeadaOrdenada ();
 * 
 * Lista 04 alterações:
 *	Exercicio03: 
 *		- Criar um construtor de uma Lista Ordenada
 *			que receba como parametro uma outra lista 
 *			desordenada para ordena-la.	
 */

public class ListaEncadeadaOrdenada extends ListaEncadeada {

	//Exercicio03 
	public ListaEncadeadaOrdenada( ListaEncadeada listaAntiga ) {
		
		if ( listaAntiga.listaVazia() ) {
			System.out.println( "Lista Vazia!" );
			return ;
		
		}else {
			
			Elo auxiliar = new Elo();
			auxiliar = listaAntiga.primeiro;
			
			while ( auxiliar != null ) {
				this.adicionaOrdenado( auxiliar.conteudo );
				auxiliar = auxiliar.proximo;
				
			}
			
		}
		
	}
	
	
	//adiciona Ordenado na lista encadeada Ordenada
	public void adicionaOrdenado( int elementoNovo ) {
		Elo novo = new Elo( elementoNovo );
		
		//lista vazia
		if ( this.listaVazia() ) {
			novo.proximo = this.primeiro;
			this.primeiro = novo;
		
			
		}else {
			Elo auxiliar = new Elo();
			Elo anterior = new Elo();
			auxiliar = this.primeiro;
			
			
			//um elemento apenas:
			if ( auxiliar.proximo == null ) {
				
				if ( novo.conteudo > auxiliar.conteudo ) {
					novo.proximo = auxiliar.proximo;
					auxiliar.proximo = novo;
				
				}else {
					novo.proximo = auxiliar;
					this.primeiro = novo;
					
				}
				
			}
			
			//comparando com o primeiro elemento
			if ( auxiliar.conteudo > novo.conteudo ) {
				novo.proximo = auxiliar;
				this.primeiro = novo;
			
			}else {										//Comparando todos
							
				auxiliar = auxiliar.proximo;
				anterior = this.primeiro;
				
			
				while ( auxiliar != null ) {
					if ( auxiliar.conteudo > novo.conteudo )
						break;
					
					auxiliar = auxiliar.proximo;
					anterior = anterior.proximo;
					
				}
				anterior.proximo = novo;
				novo.proximo = auxiliar;
			}
		}
		
	}
	
	//remove da lista Encadeada ordenada 
	public boolean removeOrdenado ( int conteudo ) {
		
		if ( !this.listaVazia() ) {
			
			Elo auxiliar = new Elo();
			Elo anterior = new Elo();
			auxiliar = this.primeiro;
			
			//comparando o primeiro elemento:
			if ( auxiliar.conteudo == conteudo ) {
				this.primeiro = auxiliar.proximo;
				System.out.println( "Elemento " + conteudo + " Removido com sucesso!" );
				return true;
			
				
			//Comparando todos da lista menos o primeiro elemento
			}else {
				
				
				//caso queira remover o primeiro elemento:
				if ( auxiliar.conteudo == conteudo ) {
					this.primeiro = auxiliar.proximo;
					System.out.println( "Elemento " + conteudo + " Removido com sucesso!" );
					return true;
					
				}
				
				auxiliar = auxiliar.proximo;
				anterior = this.primeiro;
				boolean presente = false;
				
				while ( auxiliar != null ) {
					
					if ( auxiliar.conteudo == conteudo ) {
						anterior.proximo = auxiliar.proximo;
						presente = true;
						break;
						
					}
					
					if ( auxiliar.conteudo > conteudo ) 
						break;
									
					auxiliar = auxiliar.proximo;
					anterior = anterior.proximo;
				
				}
				
				if ( presente ) {
					System.out.println( "Elemento " + conteudo + " Removido com sucesso!" );
					return true;
				
				}else {
					System.out.println( "Elemento " + conteudo + " não pertence a lista!" );
					return false;
				 
				}
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
			System.out.println("___________________________________________INICIO___________________________________________");
			while ( auxiliar != null ) {
				System.out.println("Indice: " + contador + " Elemento: " + auxiliar.conteudo );
				auxiliar = auxiliar.proximo;
				contador++;
				
			}
			System.out.println("___________________________________________FIM___________________________________________\n");
		} else 
			System.out.println( "Lista Encadeada Vazia! " );
	
	}
	
}
