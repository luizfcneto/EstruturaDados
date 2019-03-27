/*
 * 		Implantação da Estrutura de Dados ListaDuplamenteEncadeadaCircular
 * 	Autor: Luiz Fernando (Luizfcneto)
 * 	Email: Luizfcneto123@gmail.com
 * 	Descrição: Implantação da ListaDuplamenteEncadeadaCircular para verificar se os seus respectivos métodos 
 * 		estão funcionando
 * 
 */

public class Main {

	public static void main( String[] args ) {
		ListaDuplamenteEncadeadaCircular lista = new ListaDuplamenteEncadeadaCircular();
		
		
		//testando impressão sem elementos:
		lista.printaListaDuplamenteEncadeadaCircular();
		
		//testando busca sem elementos:
		lista.buscaCircular( 15 );
		
		//testando remoção sem elementos:
		lista.removeCircular( 15 );
		
		
		//testando adicionar elementos:
		lista.adicionaCircular( 5 );
		lista.adicionaCircular( 4 );
		lista.adicionaCircular( 9 );
		lista.adicionaCircular( 7 );
		lista.adicionaCircular( 2 );
		lista.adicionaCircular( 6 );
		lista.adicionaCircular( 8 );
		
		//imprime a lista:
		lista.printaListaDuplamenteEncadeadaCircular();
		
		//busca na lista:
		lista.buscaCircular( 7 );
		
		//remove da lista:
		lista.removeCircular( 4 );
		lista.removeCircular( 5 );
		lista.removeCircular( 8 );
		
		//imprime a lista:
		lista.printaListaDuplamenteEncadeadaCircular();
	}
	
}
