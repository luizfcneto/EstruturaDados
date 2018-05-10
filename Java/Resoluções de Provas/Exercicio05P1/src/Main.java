/*		Exercicio 05 
 * 	Autor: Luiz Fernando (Luizfcneto)
 * 	Email: Luizfcneto123@gmail.com
 * 	Descrição: Implantar o método void merge(ListaOrdenada l2) da classe ListaEncadeadaOrdenada que foi o exercicio 05 da Prova 1 de Estrutura de Dados
 * 		Basicamente a lista Ordenada (l1) que requisitou o método irá adicionar os elementos da Lista Ordenada l2
 * 		Mantendo a ordenação na lista resultante (na l1) 
 * 
 */

public class Main {

	public static void main( String[] args ) {
		ListaEncadeadaOrdenada lista1 = new ListaEncadeadaOrdenada();
		ListaEncadeadaOrdenada lista2 = new ListaEncadeadaOrdenada();
		
		
		//Populando a Lista1
		lista1.adicionaOrdenado( 2 );
		lista1.adicionaOrdenado( 7 );
		lista1.adicionaOrdenado( 9 );
		lista1.adicionaOrdenado( 0 );
		lista1.adicionaOrdenado( 8 );
		lista1.adicionaOrdenado( 1 );
		
		//printando Lista1
		lista1.printaListaEncadeadaOrdenada();
		
		//Populando a Lista2
		lista2.adicionaOrdenado( 6 );
		lista2.adicionaOrdenado( 3 );
		lista2.adicionaOrdenado( 4 );
		lista2.adicionaOrdenado( 5 );
		lista2.adicionaOrdenado( 11 );
		lista2.adicionaOrdenado( 10 );
		
		//printando Lista2
		lista2.printaListaEncadeadaOrdenada();
		
		//Aglutina lista1 com lista2
		lista1.merge( lista2 );
		
		//printando Lista1
		lista1.printaListaEncadeadaOrdenada();
		
		
		
	}
	
}
