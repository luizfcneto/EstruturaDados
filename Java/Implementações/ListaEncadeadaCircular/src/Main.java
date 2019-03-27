/*		Implantação de Lista Encadeada Circular
 * 	Autor: Luiz Fernando ( Luizfcneto )	
 * 	Email: Luizfcneto123@gmail.com
 * 	Descrição: Implantação de testes da estrutura de Dados: Lista Encadeada Circular
 * 	
 */


public class Main {

	public static void main( String[] args ) {
		ListaEncadeadaCircular lista = new ListaEncadeadaCircular();
		
		
		//adicionando na lista:
		lista.adicionaElemento( 10 );
		lista.adicionaElemento( 13 );
		lista.adicionaElemento( 11 );
		lista.adicionaElemento( 15 );
		lista.adicionaElemento( 16 );
		lista.adicionaElemento( 20 );
		lista.adicionaElemento( 19 );
		lista.adicionaElemento( 16 );
		lista.adicionaElemento( 14 );
		lista.adicionaElemento( 9 );
		
		
		
		//printando a lista:
		lista.printaListaEncadeadaCircular();
		
		//removendo da lista [Tem]:
		lista.removeElemento( 20 );
		lista.removeElemento( 16 );
		lista.removeElemento( 10 );
		
	
		//removendo da lista [N tem]:
		lista.removeElemento( 50 );
		lista.removeElemento( 100 );
		
		
		
		//printando a lista:
		lista.printaListaEncadeadaCircular();

		
		//buscando na lista [tem]:
		lista.buscaElemento( 13 );
		
		
		//buscando na lista [N tem]:
		lista.buscaElemento( 20 );
	}
	
}
