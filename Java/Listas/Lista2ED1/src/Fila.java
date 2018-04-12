/*
 * 			Fila
 *	Autor: Luiz Fernando (Luizfcneto)
 *	Email: Luizfcneto123@gmail.com
 *	Descrição: Classe para implementar métodos da estrutura de dados de uma Fila;
 *		Lista 02 - Filas 
 *	
 *	1.a) Fazer método que receba dois parametros (duas outras filas) e adicionar os elementos
 *		respectivos dessas filas em uma outra, alternadamente. 
 *		
 *		- public void combinaFilas( Fila fila1, Fila fila2 )
 *
 *
 *
 *	Atributos:
 *		int tamanhoFila;
 *		int inicioFila;
 *		int fimFila;			//posicao em que iremos adicionar o proximo elemento na fila, quando chegar ao fim da fila deve retornar a posicao a partir de 0 (circular) formula: fim = ( inicioFila + quantidadeNaFila ) % tamanhoFila
 *		Vector vetorFila;		// fila estática -> usa-se vetor
 *		int quantidadeNaFila;
 *	
 *	Métodos: 
 * 		verificarCheia()
 * 		verificarVazia()
 * 		removeInicioDaFila()
 * 		adicionarNaFila()
 * 		1) combinaFilas()
 * 
 */

public class Fila {
	int tamanhoFila;
	int inicioFila;
	int fimFila;
	int quantidadeFila;
	int[] vetorFila;
	
	//Construtor com tamanho
	public Fila(int tamanho) {
		this.tamanhoFila = tamanho;
		this.vetorFila = new int[this.tamanhoFila];
		this.quantidadeFila = 0;
		this.inicioFila = 0;
		this.fimFila = 0;
	}
	
	//Construtor default
	public Fila() {
		this.tamanhoFila = 10;
		this.vetorFila = new int[10];
		this.quantidadeFila = 0;
		this.inicioFila = 0;
		this.fimFila = 0;
	}
	
	//verifica se a fila ta vazia
	public boolean verificaVazia() {
		//como a fila é circular para verificar se ela está vazia eu tenho que verificar a quantidade de elementos q estao na fila e não a posicao final ou inicial
		if ( this.quantidadeFila == 0 )
			return true;
		else
			return false;
	}
	
	
	//verifica se a fila está cheia
	public boolean verificaCheia() {
		//como a fila é circular para verificar se ela está cheia devo verificar se a quantidade de elementos é a mesma que o tamanho da fila.
		if ( this.quantidadeFila == this.tamanhoFila )
			return true;
		else 
			return false;
	}
	
	
	//adicionar elemento na Fila (no final da fila)
	public void adicionaNaFila( int elementoNovo ) {
		if ( !verificaCheia() ) {
			this.vetorFila[ this.fimFila ] = elementoNovo;
			this.quantidadeFila++;
			this.fimFila = (this.fimFila + 1) % this.tamanhoFila;
		
		} else {
			System.out.println("Fila Cheia!");
		}
				
	}
	
	//remove elemento da fila (no inicio)
	public int removeInicioDaFila() {
		int elemento;
		
		if ( !verificaVazia() ) {
			elemento = this.vetorFila[ this.inicioFila ];
			this.inicioFila = ( 1 + this.inicioFila ) % this.tamanhoFila;
			this.quantidadeFila--;
			return elemento;
			
		} else {
			//Fila Vazia
			System.out.println( "FILA VAZIA!" );
			return 0;
			
		}
		
	}
	
	//1) Adicionar numa Fila Mista que adicione os elementos da fila1 e fila2 alternadamente
	public Fila combinaFilas( Fila fila1, Fila fila2 ) {
		int tamanhoTotal = fila1.quantidadeFila + fila2.quantidadeFila;
		
		//se tamanho de fila1 + fila2 for superior ao tamanho total da fila mista.
		if ( tamanhoTotal > this.tamanhoFila ) 
			return null;
		
		else {
			while ( !this.verificaCheia() && tamanhoTotal > 0 ){
				
				//se fila1 nao fica vazia
				if ( !fila1.verificaVazia() ) 
					this.adicionaNaFila( fila1.removeInicioDaFila() );
				
				//se fila2 nao fica vazia
				if ( !fila2.verificaVazia() )
					this.adicionaNaFila( fila2.removeInicioDaFila() );
				
				tamanhoTotal--;
				
			}
			return this;
		}
		
			
	}
	
	//printa Fila apenas para visualização dos elementos dentro da Fila
	public void imprimeFila() {
		int percorreFila = 0;
		System.out.println( "__________________\t\tInicio Fila\t\t__________________" );
		for ( percorreFila = 0; percorreFila < this.tamanhoFila; percorreFila++ ) {
			System.out.println("Posicao: "+ percorreFila + " Elemento: " + this.vetorFila[ percorreFila ]);
		}
		System.out.println( "__________________\t\tFinal Fila\t\t__________________" );
	}

}