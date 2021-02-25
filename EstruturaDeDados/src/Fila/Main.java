package Fila;
/*		Implantacao da estrutura de dados de Fila Circular
 * 	Autor: Luiz Fernando (Luizfcneto)
 * 	Email: Luizfcneto123@gmail.com
 * 	Descricao: Fazer testes de implementacao de Fila circular
 * 	
 * 	
 * 	Entrada: parametros de entrada e saida da fila
 * 	
 * 	Saida: imprimir a fila apos insercoese remocoes
 * 
 */

public class Main {
	
	public static void main( String[] args ) {
		FilaCircular filaCircular = new FilaCircular();
		
		//adicionando elementos na fila:
		filaCircular.adicionaNaFila( 5 );
		filaCircular.adicionaNaFila( 10 );
		filaCircular.adicionaNaFila( 15 );
		filaCircular.adicionaNaFila( 20 );
		filaCircular.adicionaNaFila( 1 );
		
		
		//printando fila
		filaCircular.imprimeFila();
		
		System.out.println( filaCircular.fimFila + " " 
				+ filaCircular.inicioFila + " " 
				+ filaCircular.quantidadeFila );

		
		//removendo elementos na fila:
		filaCircular.removeInicioDaFila();	//vai remover o 5
		filaCircular.removeInicioDaFila();	//vai remover o 10
		
		//printaFila
		filaCircular.imprimeFila();
		
		System.out.println( filaCircular.fimFila + " " 
				+ filaCircular.inicioFila + " " 
				+ filaCircular.quantidadeFila );
		
		filaCircular.adicionaNaFila( 50 );
		filaCircular.adicionaNaFila( 30 );
		filaCircular.adicionaNaFila( 60 );
		filaCircular.adicionaNaFila( 80 );
		filaCircular.adicionaNaFila( 90 );
		filaCircular.adicionaNaFila( 35 );
		filaCircular.adicionaNaFila( 23 );
		filaCircular.adicionaNaFila( 29 );
		
		//imprimefila
		filaCircular.imprimeFila();
		
		filaCircular.removeInicioDaFila();
		filaCircular.removeInicioDaFila();
		
//		filaCircular.adicionaNaFila( 18 );
//		filaCircular.adicionaNaFila( 1 );
		
		filaCircular.imprimeFila();
	
		System.out.println( filaCircular.fimFila + " "
				+ filaCircular.inicioFila + " "
				+ filaCircular.quantidadeFila );
	}
	
}
