/*
 * 		Classe Pilha 
 *	Autor: Luiz Fernando (Luizfcneto)
 *	Email: Luizfcneto123@gmail.com	
 *	Descrição: Classe Pilha que tem implementado os métodos push e pop para fazer exercicio02
 *	da Lista02
 *	
 *		Classe filaDuasPilhas vai estender essa classe para utilizar os métodos push e pop	 
 */

public class Pilha {
	//variaveis necessárias para implementar a pilha
	public int topo, tamanhoPilha, elemento;
	private int vetor[];
	

	public Pilha( int tamanhoPilha ) {
		this.tamanhoPilha = tamanhoPilha;
		vetor = new int[this.tamanhoPilha];
		this.topo = -1;
	}
	
	public Pilha() {
		this.tamanhoPilha = 20;
		vetor = new int[this.tamanhoPilha];
		this.topo = -1;
	}
	
		
	//Verifica se pilha está vazia
	public boolean verificaPilhaVazia() {
		if( this.topo == -1 )
			return true;
		else
			return false;
	}
	
	
	//Verifica se pilha está cheia
	public boolean verificaPilhaCheia() {
		if ( this.topo == this.tamanhoPilha )
			return true;
		else 
			return false;
	}
	
	//pop() => remover elemento do topo da lista, caso esta não esteja vazia. Lembrando que essa Pilha manipula inteiros, portanto retorna inteiro
	public int pop() {
		
		if ( !verificaPilhaVazia() ) {
			int numeroRetiradoPilha;
			
			numeroRetiradoPilha = this.vetor[this.topo];
			this.topo -= 1;
			return numeroRetiradoPilha; 
		
		} else 
			System.out.println( "Erro, Pilha Vazia" );
			return 0;
	
	}
	
	
	//push() => adiciona um elemento na pilha, caso ela não esteja cheia.
	public void push( int elemento ) {
		this.elemento = elemento;
		
		if( !this.verificaPilhaCheia() ) {
			this.topo += 1;
			this.vetor[this.topo] = this.elemento;
			
		}else 
			System.out.println(" ERRO, Pilha Cheia" );
		
	}
	
	
	//Metodo para retornar o ultimo elemento inserido, primeiro a sair : [topo]
	public int retornaTopoPilha() {
		int elementoDaPilha = -1;
		
		if ( !verificaPilhaVazia() ) {
			elementoDaPilha = this.vetor[this.topo];
			return elementoDaPilha;
			
		}else 
			return elementoDaPilha;
		
	}
		
	//Metodo para copiar pilha1 na pilha2 invertido
	public Pilha copiaInvertido( Pilha original ) {
		Pilha pilhaInvertida = new Pilha( original.tamanhoPilha );
		
		for ( int contador = 0; contador <= original.topo ; contador++) {
			pilhaInvertida.vetor[ contador ] =  original.vetor[ original.topo - contador];
		
		}
		
		return pilhaInvertida;
	}
	
	//metodo desnecessário, só para fins didáticos: Impressão de Pilha (irá imprimir todos os elementos da Pilha)
	public void printaPilha() {
		
		if ( !verificaPilhaVazia() ) {
			int contador;
			System.out.println("_____________________________\tImpressao Pilha\t___________________________________________________\n");
			
			for ( contador = this.vetor.length - 1; contador >= 0; contador-- ) {
				System.out.println( " ( " + this.vetor[contador] + " )" );
				
			}
			System.out.println("_____________________________\tImpressao Pilha\t___________________________________________________\n");
		}else 
			System.out.println( "ERRO, pilha está vazia, não foi possivel imprimi-la " );
			
	}
	
	
}