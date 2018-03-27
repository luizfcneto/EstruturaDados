/*
 * 		Classe de estrutura de dados: Pilha Genérica
 * 	Autor: Luiz Fernando (Luizfcneto)
 * 	Email: Luizfcneto123@gmail.com
 * 	Descrição: Implementação do algoritmo de manipulação de uma pilha generica
 * 	Entrada: tamanhoPilha (int), valoresEntrada (Qualquer Objeto - T)
 *
 */

import java.util.ArrayList;
//import java.util.Vector;

public class PilhaGenerica<T> {
	private int topo, tamanhoPilhaGenerica;
	private ArrayList<T> vetorPilhaGenerica;
	
	
	//Construtor de Pilha Generica
	public PilhaGenerica(int tamanho) {
		this.tamanhoPilhaGenerica = tamanho;
		this.topo = -1;
		vetorPilhaGenerica = new ArrayList<T>();
	}
	
	//Construtor sem parametro
	public PilhaGenerica() {
		this.tamanhoPilhaGenerica = 20;
		this.topo = -1;
		vetorPilhaGenerica = new ArrayList<T>();

	}
	
	//verifica se pilha está cheia:
	public boolean verificaPilhaCheia() {
		if (this.topo == ( this.tamanhoPilhaGenerica - 1 ) ) {
			return true;
		
		}else 
			return false;

	}

	//Verifica se pilha está vazia:
	public boolean verificaPilhaVazia() {
		if ( this.topo == -1 ) {
			return true;
			
		} else 
			return false;
	
	}
	
	//decrementa topo:
	public boolean pop() {
		if ( !verificaPilhaVazia() ) {
			this.topo--;
			return true;
			
		} else { 
			System.out.println( "PILHA VAZIA!" );
			return false;
		}
		
	}
	
	//adiciona elemento ao topo e topo incrementa:
	public boolean push(T elemento) {
		if ( !verificaPilhaCheia() ) {
			
			for ( int contador = 0; contador < this.tamanhoPilhaGenerica; contador++ ) {
				if ( contador == this.topo ) {
					this.topo++;
					vetorPilhaGenerica.add(elemento);
				
				}
				
			}
			return true;
			
		} else {
			System.out.println( "PILHA CHEIA!" );
			return false;
			
		}
	}
	
	//Retorna o elemento do topo
	public boolean retornaTopo(T elemento) {	
		if ( !verificaPilhaVazia() ) {
			elemento = this.vetorPilhaGenerica.get( this.topo );		//elemento por ser um objeto, é passado por referencia, então tudo que for alterado nele será passado para variavel na main
			return true;
			
		} else {
			System.out.println( "ERRO PILHA VAZIA!" );
			return false;
			
		}
		
	}
	
	//Metodo para facilitar visualização: Printar toda a pilha
	public void printaPilhaGenerica() {
		if ( !verificaPilhaVazia() ) {
			System.out.println("_____________________________\tInicio\t___________________________________________________\n");
			
			for ( int contador = 0; contador < this.tamanhoPilhaGenerica; contador++ ) {
				if ( contador == this.topo ) {
					System.out.println( " Topo > Posicao: "+ ( contador + 1 ) + " - Elemento: [ " + this.vetorPilhaGenerica.get( contador ) + " ]" );
				}else {
					System.out.println( " Posicao: "+ ( contador + 1 ) + " - Elemento: [ " + this.vetorPilhaGenerica.get( contador )  + " ]" );
				}
				
			}
			System.out.println("______________________________\tFim\t___________________________________________________ \n");
		
		}else 
			System.out.println( "PILHA VAZIA!!" );
				
	}	
	
}
