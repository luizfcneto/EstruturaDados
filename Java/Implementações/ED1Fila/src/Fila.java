/*
 * 			Fila
 *	Autor: Luiz Fernando (Luizfcneto)
 *	Email: Luizfcneto123@gmail.com
 *	Descrição: Classe para implementar métodos da estrutura de dados de uma Fila
 *
 *	Atributos:
 *		int tamanhoFila;
 *		int inicioFila;
 *		Vector vetorFila;		// fila estática -> usa-se vetor
 *		int quantidadeNaFila;
 *	
 *	Métodos: 
 * 		verificarCheia()
 * 		verificarVazia()
 * 		removerFinalDaFila()
 * 		adicionarNaFila()
 * 
 * 
 */

import java.util.Vector;

public class Fila {
	int tamanhoFila;
	int inicioFila;
	int quantidadeFila;
	Vector vetorFila;
	
	//Construtor com tamanho
	public Fila(int tamanho) {
		this.tamanhoFila = tamanho;
		this.vetorFila = new Vector( this.tamanhoFila );
		this.quantidadeFila = 0;
		this.inicioFila = 0;
	}
	
	//Construtor default
	public Fila() {
		this.tamanhoFila = 10;
		this.vetorFila = new Vector( 10 );
		this.quantidadeFila = 0;
		this.inicioFila = 0;
	}
	
	
	//verifica se a fila ta vazia
	public boolean verificaVazia() {
		if ( this.inicioFila == 0 )
			return true;
		else
			return false;
	}
	
	
	//verifica se a fila está cheia
	public boolean verificaCheia() {
		if ( this.inicioFila == this.tamanhoFila )
			return true;
		else 
			return false;
	}
	
	
	//adicionar elemento na Fila (no final da fila)
	public void adicionaNaFila( int elementoNovo ) {
		
	}
	
	//remove elemento da fila (no inicio)
	public void removeFinalDaFila() {
		
		
	}
	
	
	//printa Fila apenas para visualização dos elementos dentro da Fila
	public void imprimeFila() {
		
	}

}