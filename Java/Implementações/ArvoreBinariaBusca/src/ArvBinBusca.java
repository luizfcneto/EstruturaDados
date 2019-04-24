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
		private int chave, valor;
		private No esquerda, direita;
		
		//Construtor No 1
		public No ( int chave, int valor ) {
			this.chave = chave;
			this.valor = valor;
			this.esquerda = null;
			this.direita = null;
			
		}
		
		//Construtor No 2
		public No ( int chave, int valor, No esquerda, No direita ) {
			this.chave = chave;
			this.valor = valor;
			this.esquerda = esquerda;
			this.direita = direita;
			
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
	
	//Mostra nós da Arvore Binaria de Busca 
	public void mostra() {
		mostra ( this.raiz );
	}
	
	//Mostra toda Arvore a partir do nó desejado
	public void mostra( No aux ) {
		if ( aux == null ) 
			return;
		
		System.out.print( "( " + aux.chave + " " );
		
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
		raiz = insere( this.raiz, chave, valor );
	}
	
	private No insere( No aux, int chave, int valor ) {
		
		//Encontrou posição a ser inserido
		if ( aux == null )
			return new No( chave, valor );
		
		//Encontrou um nó com a mesma chave. Atualiza valor
		if ( aux.chave == chave )
			set( aux, valor );
		
		//valor da chave do nó aux é maior que a chave
		if ( aux.chave > chave ) 
			aux.esquerda = insere( aux.esquerda, chave, valor );
		
		//valor da chave do nó aux é menor que a chave
		if ( aux.chave < chave )
			aux.direita = insere( aux.direita, chave, valor );
		
		else 
			aux.valor = valor;
		
		return aux;
		
	}
//	
//	public int minimo(){
//		if ( this.vazia() ) {
//			System.out.println( "Arvore Vazia!" );
//			return 8000;
//		}
//		else
//			return minimo( this.raiz ).chave;
//	}
//	
//	//Retorna a chave de menor valor a partir de um nó desejado.
//	private No minimo( No aux ) {
//		if ( aux.esquerda == null )
//			return aux;
//		
//		else
//			return minimo( aux.esquerda );
//	}
//	
//	//Chama método privado de remover o elemento minimo de um nó especifico
//	public void removeMin() {
//		raiz = removeMin( this.raiz );
//	}
//		
//	//Remove elemento minimo de uma subarvore do do nó auxiliar específico
//	private No removeMin( No aux ) {
//		if ( aux.esquerda == null )
//			return aux.direita;
//		
//		aux.esquerda = removeMin( aux.esquerda );
//		return aux;
//				
//	}
//
//	
//	//Remove elemento com chave correspodente, caso exista na Arvore
//	public boolean remove( int chave ) {
//		if ( this.raiz == null )
//			return false;
//		
//		if ( remove( this.raiz, chave ) != null )
//			return true;
//		
//		else 
//			return false;
//	}
//	
//	//Retorna o nó que deve ser removido
//	private No remove( No aux, int chave ) {
//		if ( aux == null )
//			return null;
//		
//		if ( aux.chave > chave )
//			aux.esquerda = remove( aux.esquerda, chave );
//		
//		if ( aux.chave < chave )
//			aux.direita = remove ( aux.direita, chave );
//		
//		//Nó que deve ser removido
//		else {
//			if ( aux.direita == null )
//				return aux.esquerda;
//			
//			if ( aux.esquerda == null )
//				return aux.direita;
//			
//			No temp = aux;
//			
//			//encontrar sucessor de aux, que é o minimo da subArvore direita. Referenciá-lo
//			aux = minimo( temp.direita );
//			
//			//
//			aux.direita = removeMin( temp.direita );
//			
//			aux.esquerda = temp.esquerda;
//			
//		}
//		
//		return aux;
//	}
//	
	public int altura() {
		return altura( this.raiz );
	}
	
	private int altura( No aux ) {
		if ( aux == null ) 
			return -1;
		
		return 1 + Math.max( altura( aux.esquerda ), altura ( aux.direita ));
	}
	
	
}
