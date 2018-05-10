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
 * 
 * Exercicio 05:
 * 	- void merge( ListaEncadeadaOrdenada l2); 
 */

public class ListaEncadeadaOrdenada extends ListaEncadeada {

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
	
	//Exercicio05: lista1 merge lista2, aglutina a lista 2 na lista1 mantendo ordenação dos elementos
	public void merge( ListaEncadeadaOrdenada lista2 ) {
		//se lista requisitadora esta vazia ou lista2.
		if ( this.listaVazia() || lista2.listaVazia() ) {
			System.out.println( "Uma das Listas está vazia" );
			return;
		
		}else {
			
			//Verifica se primeiro elemento da lista2 é menor que lista1.
			if ( lista2.primeiro.conteudo < this.primeiro.conteudo ) {
				Elo novo = new Elo( lista2.primeiro.conteudo );
				novo.proximo = this.primeiro;
				this.primeiro = novo;
			}
			Elo auxiliar1 = new Elo();		//percorre a lista1 a partir do segundo elemento da lista1
			Elo auxiliar2 = new Elo();		//percorre a lista2 a partir do segundo elemento da lista2
			Elo anterior1 = new Elo();		//percorre a lista1 a partir do primeiro elemento da lista1
			
			auxiliar1 = this.primeiro;
			auxiliar1 = auxiliar1.proximo;
			
			auxiliar2 = lista2.primeiro;			
			anterior1 = this.primeiro;
			
			//percorre a lista1 até encontrar null porque os elementos da lista2 serão adicionados na lista1
			while ( auxiliar1 != null ) {
						
				//percorre a lista2 até encontrar um elemento maior que auxiliar1.conteudo
				while ( auxiliar2.conteudo < auxiliar1.conteudo ) {					
					Elo novo = new Elo( auxiliar2.conteudo );
					novo.proximo = auxiliar1;
					anterior1.proximo = novo;
					auxiliar2 = auxiliar2.proximo;
					anterior1 = novo;
					auxiliar1 = novo.proximo;
				}
				 
				//auxiliar1.conteudo <= auxiliar2.conteudo		a1= 1	an1= 0 	a2=4	an2= 3  
				if ( auxiliar1.conteudo <= auxiliar2.conteudo  ) {
					auxiliar1 = auxiliar1.proximo;
					anterior1 = anterior1.proximo;					
				
				}
											
			}
			//se auxiliar1 chegou ao seu final e auxiliar2 != null
			if ( auxiliar2 != null ) {
				anterior1.proximo = auxiliar2;		
			}
				
		}
		
	}
	
	
	//printa lista encadeada Ordenada
	public void printaListaEncadeadaOrdenada() {
		
		if ( !this.listaVazia() ) { 
			
			int contador = 0;
			Elo auxiliar = new Elo( );
			auxiliar = this.primeiro;
			System.out.println("___________________________________________INICIO___________________________________________");
			while ( auxiliar != null ) {
				System.out.println("Indice: " + contador + " Elemento: " + auxiliar.conteudo + " Hash: [ " + auxiliar + " ] " + " ---> " + auxiliar.proximo );
				auxiliar = auxiliar.proximo;
				contador++;
				
			}
			System.out.println("___________________________________________FIM___________________________________________\n");
		} else 
			System.out.println( "Lista Encadeada Vazia! " );
	
	}
	
}
