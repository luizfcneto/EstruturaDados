package Fila;
/*
 * 			Fila Circular
 *	Autor: Luiz Fernando (Luizfcneto)
 *	Email: Luizfcneto123@gmail.com
 *	Descricao: Classe para implementar metodos da estrutura de dados de 
 *	uma Fila circular
 *
 *	Atributos:
 *		int tamanhoFila;
 *		int inicioFila;
 *		int fimFila;			//posicao em que iremos adicionar o proximo elemento na fila, quando chegar ao fim da fila deve retornar a posicao a partir de 0 (circular) formula: fim = ( inicioFila + quantidadeNaFila ) % tamanhoFila
 *		Vector vetorFila;		// fila estatica -> usa-se vetor
 *		int quantidadeNaFila;
 *	
 *	Metodos: 
 * 		verificarCheia()
 * 		verificarVazia()
 * 		removeInicioDaFila()
 * 		adicionarNaFila()
 * 
 * 
 */

//import java.util.Vector;

public class FilaCircular {
	int tamanhoFila;
	int inicioFila;
	int fimFila;
	int quantidadeFila;
	int[] vetorFila;
	
	//Construtor com tamanho
	public FilaCircular(int tamanho) {
		this.tamanhoFila = tamanho;
		this.vetorFila = new int[this.tamanhoFila];
		this.quantidadeFila = 0;
		this.inicioFila = 0;
		this.fimFila = 0;
	}
	
	//Construtor default
	public FilaCircular() {
		this.tamanhoFila = 10;
		this.vetorFila = new int[10];
		this.quantidadeFila = 0;
		this.inicioFila = 0;
		this.fimFila = 0;
	}
	
	//verifica se a fila ta vazia
	public boolean verificaVazia() {
		//como a fila eh circular para verificar se ela esta vazia eu tenho que verificar a quantidade de elementos q estao na fila e nao a posicao final ou inicial
		if ( this.quantidadeFila == 0 )
			return true;
		else
			return false;
	}
	
	
	//verifica se a fila esta cheia
	public boolean verificaCheia() {
		//como a fila eh circular para verificar se ela esta cheia devo verificar se a quantidade de elementos é a mesma que o tamanho da fila.
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