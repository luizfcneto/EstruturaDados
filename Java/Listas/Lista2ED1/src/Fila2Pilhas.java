/*		Classe Fila2Pilhas 
 * 	Autor: Luiz Fernando (Luizfcneto)
 * 	Email: Luizfcneto123@gmail.com
 * 	Descrição: 
 * 		Fila2Pilhas serve para utilizarmos os métodos push e pop de duas pilhas, para representarmos uma fila
 * 		
 * 		Exercicio02 da Lista 02
 * 		- pilha1 sera responsavel pela insercao dos valores
 * 		- pilha2 sera responsavel pela remocao dos valores
 * 		
 * 		Atributos: 
 * 			-Pilha pilha1;
 * 			-Pilha pilha2;
 * 			-Fila fila;	
 * 		
 * 		Métodos:
 * 			-public insere(int elemento);
 * 			-public remove(int elemento);
 * 
 */

public class Fila2Pilhas{
	Pilha pilha1;		//Insere os elementos
	Pilha pilha2;		//Faz uma copia invertida dos elementos para que ao remover saia o primeiro elemento
	
	//construtor Fila2Pilhas
	public Fila2Pilhas( Pilha pilha1, Pilha pilha2, int tamanhoFila ) {
		this.pilha1.tamanhoPilha = tamanhoFila;
		this.pilha2.tamanhoPilha = tamanhoFila;
		
	}
	
	//construtor Fila2Pilhas default
	public Fila2Pilhas() {
		this.pilha1.tamanhoPilha = 10;
		this.pilha2.tamanhoPilha = 10;
		
	}
	
	//insere elemento na Fila2Pilhas
	public void insere( int elemento ) {
		if ( !this.pilha1.verificaPilhaCheia() )
			this.pilha1.push( elemento );
		
		else 
			System.out.println( "Fila2Pilhas cheia!" );
	}
	
	//remove elemento da Fila2Pilhas (nesse caso ele vai eliminar o pilha2
	public int remove( int elemento ) {
		elemento = -1;
		invertePilha1NaPilha2();
		if ( !this.pilha2.verificaPilhaVazia() ) {
			elemento = this.pilha2.pop();
			return elemento;
			
		} else { 
			System.out.println("Fila2Pilhas Vazia!");
			return elemento;
		}
	}
	
	//pilha2 será pilha1 invertido
	public void invertePilha1NaPilha2() {
		this.pilha2.copiaInvertido( pilha1 );
		
	}
	
}