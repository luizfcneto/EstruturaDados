import java.util.Scanner;

public class BinMinHeap {
	private int n; 					// Numero de elementos no heap 
	private int tamanho; 			// Tamanho do heap 
	private	ArvBin[] vetor; 		// Vetor com elementos, elementos serão arvores binarias de conteudo caracteres e chave frequencia( int ). 
	
	// Constrói heap vazio a partir dos elementos ( caracteres ). 
	public BinMinHeap( int tamanho ) {
		this.n = 0;
		this.tamanho = tamanho;
		this.vetor = new ArvBin[ this.tamanho ];
		
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
		// O grupo deve preencher a implementação. 
		
		
	}

	// Constrói a heap (build heap). 
	public void constroiHeap() {
		// O grupo deve preencher a implementação. 
		
		
	}

	//Lê dados via teclado e insere na heap.
	public void carregaDados() {
		char simbolo;
		int numeroEntradas = this.tamanho;
		int frequencia;
		Scanner scan = new Scanner( System.in );
				
		while ( numeroEntradas > 0 ) {
			System.out.println( " Digite o símbolo e a frequência, respectivamente: " );
			
			//Ver como pegar entrada de um char
			//simbolo = scan.
			frequencia = scan.nextInt();
			ArvBin nova = new ArvBin( simbolo, frequencia );
			this.insere( nova );
			
		}
		
	}
	
	// Executa o algoritmo de Huffman.
	public void aplicaHuffman() {
		// O grupo deve preencher a implementação.
		
		
	}
	
	// Chama o método mostra códigos da classe Arvbin.
	public void mostraCodigos() {
		// O grupo deve preencher a implementação. 
		
		
	}
	
	// Insere x na heap. 
	public void insere( ArvBin x ) {
		// O grupo deve preencher a implementação. 
		
		
	}
	
	// Remove e retorna o menor item. 
	public void removeMin( ArvBin x ) {
		// O grupo deve preencher a implementação.
		
		
		
	}
	
	// Imprime o conteúdo da heap.
	public void imprime() {
		// O grupo deve preencher a implementação.
		
		
		
	}
}