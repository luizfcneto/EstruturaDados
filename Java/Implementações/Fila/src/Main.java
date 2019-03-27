/*		Implantação da estrutura de dados de Fila
 * 	Autor: Luiz Fernando (Luizfcneto)
 * 	Email: Luizfcneto123@gmail.com
 * 	Descrição: Fazer testes de implementação de Fila circular
 * 	
 * 	
 * 	Entrada: parametros de entrada e saida da fila
 * 	
 * 	Saida: imprimir a fila apos insercoese remocoes
 * 
 */


//import java.util.Scanner;
public class Main {
	
	public static void main( String[] args ) {
		Fila fila = new Fila();
		
		//adicionando elementos na fila:
		fila.adicionaNaFila( 5 );
		fila.adicionaNaFila( 10 );
		fila.adicionaNaFila( 15 );
		fila.adicionaNaFila( 20 );
		fila.adicionaNaFila( 1 );
		
		
		//printando fila
		fila.imprimeFila();
		
		System.out.println( fila.fimFila + " " + fila.inicioFila + " " + fila.quantidadeFila );

		
		//removendo elementos na fila:
		fila.removeInicioDaFila();	//vai remover o 5
		fila.removeInicioDaFila();	//vai remover o 10
		
		//printaFila
		fila.imprimeFila();
		
		System.out.println( fila.fimFila + " " + fila.inicioFila + " " + fila.quantidadeFila );
		
		fila.adicionaNaFila( 50 );
		fila.adicionaNaFila( 30 );
		fila.adicionaNaFila( 60 );
		fila.adicionaNaFila( 80 );
		fila.adicionaNaFila( 90 );
		fila.adicionaNaFila( 35 );
		fila.adicionaNaFila( 23 );
		fila.adicionaNaFila( 29 );
		
		//imprimefila
		fila.imprimeFila();
		
		fila.removeInicioDaFila();
		fila.removeInicioDaFila();
		
//		fila.adicionaNaFila( 18 );
//		fila.adicionaNaFila( 1 );
		
		fila.imprimeFila();
	
		System.out.println( fila.fimFila + " " + fila.inicioFila + " " + fila.quantidadeFila );

	}
	
}
