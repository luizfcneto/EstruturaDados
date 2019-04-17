// Nessa implementação, os conceitos de "nó" e "árvore" se misturam. (Nó = Arvbin)
public class ArvBin {
	
	private char simbolo; 						// Símbolo armazenado na raiz.
	private int frequencia; 					// Frequência do símbolo armazenado na raiz.
	private ArvBin esquerda, direita; 			// Referencia para subárvores esquerda e direita. 
	
	/* Construtor de árvore sem subárvores (direita = esquerda = null). 
	 São fornecidos apenas o símbolo e a frequência da raiz. */
	public ArvBin( char simbolo, int frequencia ) {
		this.simbolo = simbolo;
		this.frequencia = frequencia;
		this.esquerda = null;
		this.direita = null;
		
	}
	
	/* Construtor de árvore com subárvores. Além de símbolo e frequência da raiz,
	  são fornecidas as subárvores, que devem ter sido construídas previamente. */
	public ArvBin( char simbolo, int frequencia, ArvBin esquerda, ArvBin direita ) {
		this.simbolo = simbolo;
		this.frequencia = frequencia;
		this.esquerda = esquerda;
		this.direita = direita;
		
	}
	
	// Imprime o conteúdo da árvore (em pré-ordem).
	public void mostraPre() {
		System.out.print("(" + this.frequencia + this.simbolo);
		if ( this.esquerda != null )
			this.esquerda.mostraPre();		
		
		if ( this.direita != null )
		 	 this.direita.mostraPre();
		System.out.print(")");
				
	}
	
	public void mostraPos() {
		System.out.print( "(" );
		
		if ( this.esquerda != null )
			this.esquerda.mostraPos();		
		
		if ( this.direita != null )
		 	 this.direita.mostraPos();
		System.out.print( this.frequencia + " " + this.simbolo);
		System.out.print(")");
	}
	
	public void mostraSimetrico() {
		
		System.out.print( "(" );
		if ( this.esquerda != null )
			this.esquerda.mostraSimetrico();		
		
		System.out.print(this.frequencia + " " + this.simbolo);
		
		if ( this.direita != null )
		 	 this.direita.mostraSimetrico();
		
		System.out.print(")");
	}
	
	// Novo método para imprimir os códigos de Huffman de cada símbolo na árvore.
	public void mostraCodigo( int[] vetor, int sentinela ) {
		
		if( this.esquerda == null && this.direita == null ) {
			System.out.println("\nSimbolo: " + this.simbolo + " - Frequência: " + this.frequencia + " Código: " );
			
			for( int i = 0; i < sentinela ; i++ ) 
				System.out.print( vetor[ i ] + " " );
			
			return;
		}
		
		if( this.esquerda != null) {
			vetor[ sentinela ] = 0;
			this.esquerda.mostraCodigo( vetor, sentinela + 1 );	
		}
		
		if( this.direita != null) {
			vetor[ sentinela ] = 1;
			this.direita.mostraCodigo( vetor, sentinela + 1 );
		}
		
	}
	
	// Caso necessário, o grupo pode definir novos métodos.
	
	//retorna frequencia da arvore
	public int getFrequencia() {
		return this.frequencia;

	}
	
	//retorna o simbolo da arvore
	public char getSimbolo() {
		return this.simbolo;
		
	}
	
	//retorna subarvore esquerda
	public ArvBin getEsquerda() {
		return this.esquerda;
		
	}
	
	//retorna subarvore direita
	public ArvBin getDireita() {
		return this.direita;
	}
	
}
