import java.util.Scanner;

public class BinMinHeap {
	private int n; 					// Numero de elementos no heap 
	private int tamanho; 			// Tamanho do heap 
	private	Arvbin[] vetor; 		// Vetor com elementos, elementos serão arvores binarias de conteudo caracteres e chave frequencia( int ). 
	
	// Constrói heap vazio a partir dos elementos ( caracteres ). 
	public BinMinHeap( int tamanho ) {
		this.n = 0;
		this.tamanho = tamanho;
		this.vetor = new Arvbin[ this.tamanho + 1 ];
		
	}
	
	// Testa se a heap está vazia. 
	public boolean vazia() {
		if ( this.n == 0 )
			return true;
		else
			return false;
		
	}
	
	// Refaz a condição de heap ( heapify ).
	public void refaz( int i ) {
		 
		int filho;
		Arvbin x = vetor[ i ];

		for( ; i * 2 <= n; i = filho ) {
			filho = i * 2;
			if( ( filho != n ) && ( vetor[ filho + 1 ].getFrequencia() < vetor[ filho ].getFrequencia() ) )
				filho++;
			
			if( vetor[ filho ].getFrequencia() < x.getFrequencia() )
				vetor[ i ] = vetor[ filho ];
			
			else
				break;
			
		}
		vetor[ i ] = x;
		
	}

	// Constrói a heap (build heap). 
	public void constroiHeap() {
		for( int i = this.n / 2; i > 0; i-- )
			refaz( i );
		
	}

	//Lê dados via teclado e insere na heap.
	public void carregaDados() {
		char simbolo;
		int numeroEntradas = this.tamanho;
		int frequencia;
		Scanner scan = new Scanner( System.in );
				
		while ( numeroEntradas > 0 ) {
			System.out.println( "Informe o simbolo e a frequencia, respectivamente: " + numeroEntradas );
			simbolo = scan.next().charAt(0);
			frequencia = scan.nextInt();
			Arvbin nova = new Arvbin( simbolo, frequencia );
			this.insere( nova );		
			numeroEntradas--;
			
		}
		scan.close();
		
	}
	
	// Executa o algoritmo de Huffman.

	public void aplicaHuffman(){
		// O grupo deve preencher a implementação.
		
		while ( this.n > 1 ) { 			
			Arvbin x1 = new Arvbin ( this.vetor[ 1 ].getSimbolo() , vetor [ 1 ].getFrequencia(), this.vetor[ 1 ].getEsquerda(), this.vetor[ 1 ].getDireita() );
			this.removeMin();
			
			Arvbin x2 = new Arvbin ( this.vetor[ 1 ].getSimbolo() , vetor [ 1 ].getFrequencia(), this.vetor[ 1 ].getEsquerda(), this.vetor[ 1 ].getDireita() );
			this.removeMin();
		
			Arvbin xn = new Arvbin ( ' ', ( x1.getFrequencia() + x2.getFrequencia() ) , x1 , x2  );

			this.insere( xn );
		
		}
		this.vetor[ 1 ].mostra();
	}
	
	
	// Chama o método mostra códigos da classe Arvbin.
	public void mostraCodigos()
	{
		/* O grupo deve preencher a implementação. */
		
		Arvbin aux = vetor[1];
		
		int sentinela = 0;
		int[] codigo = new int[tamanho];
		
		aux.mostraCodigo( codigo, sentinela );
		
	}
	
	// Insere elem na heap. 
	public void insere( Arvbin elem ) {
		int dir;
		
		if ( this.tamanho == this.n ){
			System.out.println("Não há mais posições livres na fila de prioridades");
			return;
		
		}
	
		vetor[ 0 ] = elem;   
		dir = ++this.n;
		
		for( ;  elem.getFrequencia() < vetor[ dir/2 ].getFrequencia() ; dir /= 2 )
			vetor[ dir ] = vetor[ dir/2 ];
				   
		vetor[ dir ] = elem;
				   
	}
	
	// Remove e retorna o menor item. 
	public Arvbin removeMin() {
		
		if( this.vazia() ) {
			System.out.println( "Fila de prioridade Vazia!! " );
			return null;
		}
		
		Arvbin retirada = new Arvbin( vetor[ 1 ].getSimbolo() ,vetor[ 1 ].getFrequencia() );
		vetor [ 1 ] = vetor [ n ];
		this.n --;
		refaz( 1 );
		
		return retirada;
		
	}
	
	// Imprime o conteúdo da heap.
	public void imprime() {
		
		for( int i = 1; i <= n; i++ )
			System.out.println( "v["+ i + "] = " + this.vetor[ i ].getSimbolo() + " frequencia: " + this.vetor[ i ].getFrequencia() );

		System.out.println();
		
	}
}
