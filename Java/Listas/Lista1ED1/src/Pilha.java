/*
 * 		Classe de estrutura de dados: Pilha
 * 	Autor: Luiz Fernando (Luizfcneto)
 * 	Email: luizfcneto123@gmail.com	
 * 	Descrição: Implementação da classe Pilha e seus métodos para manipulação de dados (nesta classe inteiros)
 * 		para fazer a lista 1 de Ed1
 * 
 * 		"Implementado" apenas a letra: 
 * 		
 * 			a) void ordenaPilha();	-> "implementado de forma incorreta, manipulando por vetores, nao consegui fazer
 * 				de outra forma.
 * 	
 * 	Entrada: tamanhoPilha (int) ou NULL (construtor default)
 *	Saida: NULL (Pilha Ordenada);
 */


public class Pilha {
	//variaveis necessárias para implementar a pilha
	private int topo, tamanhoPilha, elemento;
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
	
	public void ordenaPilha() {
		Pilha nova = new Pilha(this.tamanhoPilha);
		int maiorElemento = 0, contadorAntiga = 0, contadorNova = 0, indiceMarcado  = 0;
		
		
		//copiando elementos da pilha antiga para pilha nova
		for ( contadorAntiga = 0; contadorAntiga < this.topo + 1 ; contadorAntiga++ ) {
			nova.vetor[contadorAntiga] = this.vetor[contadorAntiga]; 
			
		}
		nova.topo = this.topo;
		
		
		//ordenacao na pilha, para inserir o maior na base da pilha "antiga"(desordenada)
		for ( contadorAntiga = 0; contadorAntiga < this.topo + 1; contadorAntiga++ ) {
			maiorElemento = 0;
			
			for ( contadorNova = 0 ; contadorNova < nova.topo + 1; contadorNova++ ) {
				if ( maiorElemento <= nova.vetor[contadorNova] ) {
					maiorElemento = nova.vetor[contadorNova];
					indiceMarcado  = contadorNova;
				}	
				
			}
			nova.vetor[indiceMarcado] = 0;
			this.vetor[contadorAntiga] = maiorElemento;
			
		}
		
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
