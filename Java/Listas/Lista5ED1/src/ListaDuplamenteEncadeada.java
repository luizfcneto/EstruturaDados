/*
 * 		Lista Duplamente Encadeada
 * 	Autor: Luiz Fernando (Luizfcneto)
 * 	Email: Luizfcneto123@gmail.com
 * 	
 * 	Descrição: Lista Duplamente Encadeada pois além de termos um ponteiro indicando o próximo elemento da Lista,
 * 		temos um ponteiro indicando seu elemento anterior. Dando mais facilidade na inserção de elementos e remoção
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
 * 		- Lista5:
 * 			-Q03: public void trocaElos( Elo elo1, Elo elo2 )
 * 			-Q04: public void trocaElos( int indiceElo1, int indiceElo2 )
 * 
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
	
	//verifica se ListaDuplamenteEncadeada está vazia
	private boolean vazia() {
		if( this.primeiro == null )	
			return true;
		
		else	
			return false;
	}
	
	//Exercicio 03 da Lista 05: troca de posicao o elo1 com o elo2.
	public void trocaElos( Elo elo1, Elo elo2 ) {
		Elo auxiliar = new Elo();
		
		// consecutivos -OK ( menos com troca em extremidade ) 
		if ( elo1.proximo == elo2 || elo2.anterior == elo1 ) {
			
			auxiliar.proximo = elo2.proximo;
			auxiliar.anterior = elo2;
			
			if ( elo2.proximo != null )
				auxiliar.proximo.anterior = elo2.proximo.anterior;
			
			
			auxiliar.anterior.proximo = elo2;
			
			elo2.anterior = elo1.anterior;
			elo2.proximo = elo1;
			
			if ( elo2.proximo != null )
				elo2.proximo.anterior = elo1;
			
			if ( elo2.anterior != null )
				elo2.anterior.proximo = elo1.anterior.proximo;
			
			elo1.anterior = auxiliar.anterior;
			elo1.proximo = auxiliar.proximo;
			
			if ( elo1.proximo != null )
				elo1.proximo.anterior = auxiliar.proximo.anterior;
			
			if ( elo1.anterior != null )
				elo1.anterior.proximo = auxiliar.anterior.proximo;
			
			auxiliar = null;
		}
		
		//separados - OK ( menos com troca em extremidade )
		else if ( elo1 != elo2.anterior || elo1 != elo2.proximo || elo1.proximo != elo2 || elo1.anterior != elo2 ) {
			
			
			auxiliar.proximo = elo2.proximo;
			auxiliar.anterior = elo2.anterior;
			
			if ( elo2.proximo != null )
				auxiliar.proximo.anterior = elo2.proximo.anterior;
			
			if ( elo2.anterior != null )
				auxiliar.anterior.proximo = elo2.anterior.proximo;
			
			if ( elo2.proximo != null )
				elo2.proximo.anterior = elo1;
		
			if ( elo2.anterior != null )
				elo2.anterior.proximo = elo1;
			
			
			elo2.anterior = elo1.anterior;
			elo2.proximo = elo1.proximo;
		
			elo1.proximo.anterior = elo2;
			elo1.anterior.proximo = elo2;
			elo1.proximo = auxiliar.proximo;
			elo1.anterior = auxiliar.anterior;
			
			auxiliar = null;
		
		}
		
		
		
		
		
	}
	
	//Exercicio 04 da Lista 05: troca de posicao o elo1 do indice1 com o elo2, do indice2;
	public void trocaElos( int indiceElo1, int indiceElo2 ) {
		int indice = 0;
		Elo auxiliar = new Elo();
		auxiliar = this.primeiro;
		while ( auxiliar != null ) {
			indice++;
			auxiliar = auxiliar.proximo;
		}
		
		//caso o indice esteja errado
		if ( indice < indiceElo1 || indice < indiceElo2 || indiceElo1 < 0 || indiceElo2 < 0 || indiceElo1 == indiceElo2) {
			System.out.println( "Algum indice está incorreto!");
			return;
		
		} else {
			Elo elo1 = new Elo();
			Elo elo2 = new Elo();
			auxiliar = this.primeiro;
			indice = 0;
			while ( auxiliar != null ) {
				
				if ( indice == indiceElo1 ) 
					elo1 = auxiliar;
					
				if ( indice == indiceElo2 )
					elo2 = auxiliar;
					
				
				indice++;
				auxiliar = auxiliar.proximo;
			}
			trocaElos( elo1, elo2 );			
			
		}
		
	}
	
	//adiciona Elemento na ListaDuplamenteEncadeada *Não ordenado!
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
	
	//remove Elemento da ListaDuplamenteEncadeada *Não ordenado!
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
					
					//se o elemento é o ultimo a ser removido
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
