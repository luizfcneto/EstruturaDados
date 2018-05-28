/*
 *		Implantação da Lista Duplamente Encadeada Ordenada
 *	Autor: Luiz Fernando (Luizfcneto)
 *	Email: Luizfcneto123@gmail.com
 *	
 *	
 * 
 * 
 */

public class Main {

	public static void main( String[] args ) {
		ListaDuplamenteEncadeadaOrdenada lista = new ListaDuplamenteEncadeadaOrdenada();
		
		
		//testando impressão sem elementos:
		lista.printaListaDuplamenteOrdenada();
		
		//testando busca sem elementos:
		lista.buscaOrdenada( 15 );
		
		//testando remoção sem elementos:
		lista.removeOrdenada( 15 );
		
		
		//testando adicionar elementos:
		lista.adicionaOrdenada( 5 );
		lista.adicionaOrdenada( 4 );
		lista.adicionaOrdenada( 9 );
		lista.adicionaOrdenada( 7 );
		lista.adicionaOrdenada( 2 );
		lista.adicionaOrdenada( 6 );
		lista.adicionaOrdenada( 8 );
		
		//imprime a lista:
		lista.printaListaDuplamenteOrdenada();
		
		//busca na lista:
		lista.buscaOrdenada( 7 );
		
		//remove da lista:
		lista.removeOrdenada( 4 );
		lista.removeOrdenada( 5 );
		lista.removeOrdenada( 8 );
		
		//imprime a lista:
		lista.printaListaDuplamenteOrdenada();
		
		
	}
	
	
}
