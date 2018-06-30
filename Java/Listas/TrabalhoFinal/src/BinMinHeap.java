import java.util.Scanner;

public class BinMinHeap {
	private int n; 					// Numero de elementos no heap 
	private int tamanho; 			// Tamanho do heap 
	private	ArvBin[] vetor; 		// Vetor com elementos, elementos serão arvores binarias de conteudo caracteres e chave frequencia( int ). 
	
	// Constrói heap vazio a partir dos elementos ( caracteres ). 
	public BinMinHeap( int tamanho ) {
		this.n = 0;
		this.tamanho = tamanho;
		this.vetor = new ArvBin[ this.tamanho + 1 ];
		
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
		ArvBin x = vetor[ i ];

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
			
			simbolo = scan.next().charAt(0);
			frequencia = scan.nextInt();
			ArvBin nova = new ArvBin( simbolo, frequencia );
			this.insere( nova );		
			numeroEntradas--;
			
		}
		scan.close();
		
	}
	
	// Executa o algoritmo de Huffman.
	public void aplicaHuffman() {
		// O grupo deve preencher a implementação.
		
		
	}
	
	// Chama o método mostra códigos da classe Arvbin.
	public void mostraCodigos() {
		// O grupo deve preencher a implementação. 
		
		
	}
	
	// Insere elem na heap. 
	public void insere( ArvBin elem ) {
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
	public ArvBin removeMin( ArvBin elem ) {
		
		if( this.vazia() ) {
			System.out.println( "Fila de prioridade Vazia!! " );
			return null;
		}
		
		ArvBin retirada = new ArvBin( vetor[ 1 ].getSimbolo() ,vetor[ 1 ].getFrequencia() );
		vetor [ 1 ] = vetor [ n ];
		this.n --;
		refaz( 1 );
		
		return retirada;
		
	}
	
	// Imprime o conteúdo da heap.
	public void imprime() {
		
		for( int i = 1; i <= n; i++ )
			System.out.print( "v["+ i + "] = " + this.vetor[ i ].getSimbolo() + "\t" + this.vetor[ i ].getFrequencia() );

		System.out.println();
		
	}
}
