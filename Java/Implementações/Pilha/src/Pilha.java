/*
 * 		Classe de estrutura de dados: Pilha
 * 	Autor: Luiz Fernando (Luizfcneto)
 * 	Email: luizfcneto123@gmail.com	
 * 	Descrição: Implementação da classe Pilha e seus métodos para manipulação de dados (nesta classe inteiros)
 * 	Entrada: tamanhoPilha (int) ou NULL (construtor default)
 *
 */


public class Pilha {
	//variaveis necessárias para implementar a pilha
	private int topo, tamanhoPilha;
	private int vetor[];
	

	public Pilha( int tamanhoPilha ) {
		this.tamanhoPilha = tamanhoPilha;
		vetor = new int[this.tamanhoPilha];
		this.topo = -1;
	}
	
	public Pilha() {
		this.tamanhoPilha = 10;
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
			return -1;
	
	}
	
	
	//push() => adiciona um elemento na pilha, caso ela não esteja cheia.
	public void push( int elemento ) {
		
		if( !this.verificaPilhaCheia() ) {
			this.topo += 1;
			this.vetor[this.topo] = elemento;
			
		}else 
			System.out.println(" ERRO, Pilha Cheia" );
		
	}
	
	//Metodo para retornar o ultimo elemento inserido, primeiro a sair : [topo]
	public int retornaTopoPilha() {
		
		if ( !verificaPilhaVazia() ) {
			int elementoDaPilha;
			elementoDaPilha = this.vetor[this.topo];
			return elementoDaPilha;
			
		}else 
			return -1;
		
	}
	
	
	//metodo desnecessário, só para fins didáticos: Impressão de Pilha (irá imprimir todos os elementos da Pilha)
	public void printaPilha() {
		
		if ( !verificaPilhaVazia() ) {
			int contador = 0;
			System.out.println("_____________________________\tInicio\t___________________________________________________\n");
			
			for (; contador < this.vetor.length; contador++ ) {
				if (contador == this.topo ) {
					System.out.println( " Topo > Posicao: "+ ( contador + 1 ) + " - Elemento: [ " + this.vetor[contador] + " ]" );
				}else 
					System.out.println( "Posicao: "+ ( contador + 1 ) + " - Elemento: [ " + this.vetor[contador] + " ]" );
				
				
				
			}
			System.out.println("______________________________\tFim\t___________________________________________________ \n");
			
		}else 
			System.out.println( "ERRO, pilha está vazia, não foi possivel imprimi-la " );
			
	}
	
	
}
