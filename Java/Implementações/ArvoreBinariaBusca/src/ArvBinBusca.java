/*		Implementação da Estrutura de Dados - Arvore Binaria de Busca - Ponteiro!
 * 	Autor: Luiz Fernando ( Luizfcneto )
 * 	Email: luizfcneto123@gmail.com	
 * 	Descrição: Implementação da estrutura de dados Arvore Binaria de Busca por ponteiros
 * 		Implementação de chaves com números inteiros
 * 
 */

public class ArvBinBusca {

	private No raiz;
	
	private class No{
		private int chave, valor, altura;
		private No esquerda, direita;
		
		//Construtor No 1
		public No ( int chave, int valor ) {
			this.chave = chave;
			this.valor = valor;
			this.esquerda = null;
			this.direita = null;
			this.altura = 0;
			
		}
		
		//Construtor No 2
		public No ( int chave, int valor, No esquerda, No direita ) {
			this.chave = chave;
			this.valor = valor;
			this.esquerda = esquerda;
			this.direita = direita;
			this.altura = 0;
			
		}
		
	}
	
	//construtor da Arvore binária de Busca
	public ArvBinBusca() {
		this.raiz = null;
		
	}
	
	//verifica se arvore está vazia
	public boolean vazia() {
		if ( this.raiz == null )
			return true;
		else
			return false;
		
	}
	
	public int getAltura( No aux ) {
		if ( aux == null )
			return 0;
		
//		System.out.println( " Aux: " + aux.chave );
		return aux.altura;
	}
	
	//Mostra nós da Arvore Binaria de Busca 
	public void mostra() {
		mostra ( this.raiz );
	}
	
	//Mostra toda Arvore a partir do nó desejado
	public void mostra( No aux ) {
		if ( aux == null ) 
			return;
		
		System.out.print( "( c:" + aux.chave + " v:" + aux.valor + " h:" + aux.altura + " " );
		
		if ( aux.esquerda != null ) 
			mostra( aux.esquerda );
		
		if ( aux.direita != null )
			mostra( aux.direita );
		
		System.out.print( " ) ");
	}
	
	//Busca na Arvore a chave desejada
	public int busca( int chave ) {
		return buscaChave( this.raiz , chave );
	}
	
	//Busca na Arvore a chave desejada
	private int buscaChave( No aux, int chave ) {
		
		//Quando a chave não pertence à arvore, retornará o valor -8000
		if ( aux == null )
			return -8000;
		
		//valor da chave do nó aux é maior que a chave 
		if ( aux.chave > chave )
			return buscaChave( aux.esquerda, chave );
		
		//valor da chave do nó aux é menor que a chave
		if ( aux.chave < chave )
			return buscaChave( aux.direita, chave );
			
		else
			return aux.valor;
		
	}
	
	//atualiza valor do nó, pela chave
	private void set( No aux, int valor ) {
		aux.valor = valor;
	}
	
	public void insere( int chave, int valor ) {
		raiz = insere( raiz, chave, valor );
	}
	
	private No insere( No aux, int chave, int valor ) {
		//Encontrou posição a ser inserido
		if ( aux == null ) 
			return new No( chave, valor );
						
		//Encontrou um nó com a mesma chave. Atualiza valor
		if ( aux.chave == chave ) 
			set( aux, valor );

		//valor da chave do nó aux é maior que a chave
		if ( aux.chave > chave ) {
//			if ( aux.esquerda == null ) {
//				aux.altura++;
//				aux.esquerda = insere( aux.esquerda, chave, valor );
//						
//			}else {
//				aux.altura = 1 + Math.max( getAltura( aux.direita ) , getAltura( aux.esquerda ) );
				aux.esquerda = insere( aux.esquerda, chave, valor );
					
//			}
		}
		//valor da chave do nó aux é menor que a chave
		else if ( aux.chave < chave ) {
//			if ( aux.direita == null ) {
//				aux.altura++;
//				aux.direita = insere( aux.direita, chave, valor );
//				
//			}else {
//				aux.altura = 1 + Math.max( getAltura ( aux.direita ), getAltura ( aux.esquerda ) );
				aux.direita = insere( aux.direita, chave, valor );
					
//			}
		}else 
			return aux;
		
		//atualiza altura dos nós ancestrais de aux. Funcionando! 
		aux.altura = 1 + Math.max( getAltura( aux.direita ) , getAltura( aux.esquerda ) );
		return aux;
		
	}
	
	public int minimo(){
		if ( this.vazia() ) {
			System.out.println( "Arvore Vazia!" );
			return 8000;
		}
		else
			return minimo( raiz ).chave;
	}
	
	//Retorna a chave de menor valor a partir de um nó desejado.
	private No minimo( No aux ) {
		if ( aux.esquerda == null )
			return aux;
		
		else
			return minimo( aux.esquerda );
	}
	
	//Chama método privado de remover o elemento minimo de um nó especifico
	public void removeMin() {
		raiz = removeMin( raiz );
	}
		
	//Remove elemento minimo de uma subarvore do do nó auxiliar específico
	private No removeMin( No aux ) {
		if ( aux.esquerda == null )
			return aux.direita;
		
		aux.esquerda = removeMin( aux.esquerda );
		return aux;
				
	}

	
	//Remove elemento com chave correspodente, caso exista na Arvore
	public boolean remove( int chave ) {
		if ( raiz == null )
			return false;
		
		if ( remove( raiz, chave ) != null )
			return true;
		
		else 
			return false;
	}
	
	//	Método que remove o Nó que contem o inteiro chave  
	private No remove( No aux, int chave ) {
		//Se percorrer e não encontrar o nó com chave desejada
		if ( aux == null )
			return null;
		
		//Procura nó que contenha a chave desejada
		if ( chave < aux.chave )
			aux.esquerda = remove( aux.esquerda, chave );
		
		else if ( chave > aux.chave )
			aux.direita = remove ( aux.direita, chave );
		
		//Nó que contém a chave que deve ser removido
		else {
			if ( aux.direita == null )
				return aux.esquerda;
			
			if ( aux.esquerda == null )
				return aux.direita;
			
			//Variavel temporaria para auxiliar com referencia
			No temp = aux;
			
			//auxiliar recebe o sucessor, que é o menor nó da subArvore direita
			aux = minimo( temp.direita );
			
			//Remove o menor nó da subArvore direita
			aux.direita = removeMin( temp.direita );
			
			//Mantém subArvore esquerda
			aux.esquerda = temp.esquerda;
			
		}
		
		return aux;
	}
	
	public int altura() {
		return altura( this.raiz );
	}
	
	private int altura( No aux ) {
		if ( aux == null ) 
			return -1;
		
		return 1 + Math.max( altura( aux.esquerda ), altura ( aux.direita ));
	}
	
	
}
