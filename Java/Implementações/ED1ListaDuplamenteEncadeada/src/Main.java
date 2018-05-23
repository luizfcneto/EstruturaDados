/*
 * 		Implantação da Estrutura de Dados ListaDuplamenteEncadeada
 * 	Autor: Luiz Fernando (Luizfcneto)
 * 	Email: Luizfcneto123@gmail.com
 * 	Descrição: Implantação da ListaDuplamenteEncadeada para verificar se os seus respectivos métodos 
 * 		estão funcionando
 * 
 * 
 */

public class Main {

	public static void main( String[] args ) {
		ListaDuplamenteEncadeada lista = new ListaDuplamenteEncadeada();
		
		
		//testando impressão sem elementos:
		lista.printaListaDuplamenteEncadeada();
		
		//testando busca sem elementos:
		lista.busca( 15 );
		
		//testando remoção sem elementos:
		lista.remove( 15 );
		
		
		//testando adicionar elementos:
		lista.adiciona( 5 );
		lista.adiciona( 4 );
		lista.adiciona( 9 );
		lista.adiciona( 7 );
		lista.adiciona( 2 );
		lista.adiciona( 6 );
		lista.adiciona( 8 );
		
		//imprime a lista:
		lista.printaListaDuplamenteEncadeada();
		
		//busca na lista:
		lista.busca( 7 );
		
		//remove da lista:
		lista.remove( 4 );
		lista.remove( 5 );
		lista.remove( 8 );
		
		//imprime a lista:
		lista.printaListaDuplamenteEncadeada();
	}
	
}
