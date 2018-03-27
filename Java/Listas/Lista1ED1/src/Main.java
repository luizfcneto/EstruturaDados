/*		Exercicio 1- a) da lista de exercicios 1 de ED1
 * 	Autor: Luiz Fernando (luizfcneto)
 * 	Email: Luizfcneto123@gmail.com
 * 	Descrição: Classe de entrada dos valores da estrutura da pilha, implementados na Classe pilha, realizando 
 * 	 uma ordenação de forma ascendente dos valores inseridos na pilha
 * 	
 * 	Entrada: n elementos (int)
 * 	Saida: pilha Ordenada (NULL)
 * 	
 */

import java.util.Scanner;

public class Main {
	
	public static void main( String[] args ) {
		Scanner entrada = new Scanner( System.in );
		int elemento = -1;
		
		//Pilha inicializada sem tamanho, para visualizar implementação da ordenação, sem se preocupar com o tamanho da pilha
		Pilha pilha = new Pilha(10);
		
		
		while ( elemento != 0 ) {
			System.out.println( "Digite um numero positivo ou 0 para terminar:" );
			elemento = entrada.nextInt();
			
			if ( elemento == 0 ) break;
			pilha.push( elemento );
		}
		
		
		pilha.printaPilha();
		pilha.ordenaPilha();
		pilha.printaPilha();
		
		
		
		entrada.close();
	}
	

}
