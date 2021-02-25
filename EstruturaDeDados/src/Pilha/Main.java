package Pilha;
/*
 * 	Implementacao da Classe Pilha
 *	Autor: Luiz Fernando (Luizfcneto)
 *	Email: Luizfcneto123@gmail.com
 *	Descricao: Implementacao da Classe Pilha, manipulando inteiros
 *
 * 	Entrada: tamanhoPilha (int), n valoresInsercao (int);
 * 	Saida: 
 * 
 */

import java.util.Scanner;

public class Main {
	
	public static void main( String[] args ) {
		Scanner scan = new Scanner( System.in );
		int elemento = 0, ultimo;

		//variavel de entrada(requisito) da Classe Pilha
		int tamanhoPilha;
		
		System.out.println("Informe o tamanho da Pilha: ");
		tamanhoPilha = scan.nextInt();
		
		//Criacao da Pilha
		Pilha pilha = new Pilha( tamanhoPilha );
		
		//elementos de insercao na pilha:
		System.out.println( "Informe o elemento que deseja inserir na Pilha: [-1, para]" );
		elemento = scan.nextInt();
		while ( elemento != -1 ) {
			
			pilha.push( elemento );
			elemento = scan.nextInt();
		}
		
		//printa pilha completa (fins didaticos)
		pilha.printaPilha();
		
		//testando metodo retornaTopoPilha();
		ultimo = pilha.retornaTopoPilha();
		System.out.print(" Topo: " + ultimo + "\n");
		
		//elimina topo
		pilha.pop();
		pilha.pop();
		
		pilha.printaPilha();
		
		ultimo = pilha.retornaTopoPilha();
		System.out.print(" Topo: " + ultimo + "\n");
		
		scan.close();
	}
	
}
