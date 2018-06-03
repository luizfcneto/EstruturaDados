/*		Implantação dos Exercicios da lista05
 * 	Autor: Luiz Fernando (Luizfcneto)
 * 	Email: Luizfcneto123@gmail.com
 * 	 
 */

public class Main {

	public static void main( String[] args ) {
		ListaEncadeada lista = new ListaEncadeada();
		
		
		//populando lista1 
		lista.insereNaLista( 5 );
		lista.insereNaLista( 1 );
		lista.insereNaLista( 3 );
		lista.insereNaLista( 4 );
		lista.insereNaLista( 7 );
		
		//printando lista1
		lista.printaListaEncadeada();
		
		ListaEncadeadaCircular listaC = new ListaEncadeadaCircular( lista );
		listaC.printaListaEncadeadaCircular();
		
		ListaEncadeadaCircular listaC2 = new ListaEncadeadaCircular();
		
		//populando listaC2
		listaC2.adicionaElemento( 8 );
		listaC2.adicionaElemento( 2 );
		listaC2.adicionaElemento( 6 );
		listaC2.adicionaElemento( 9 );
		listaC2.adicionaElemento( 10 );
		
		listaC2.printaListaEncadeadaCircular();
		
		listaC.transfereListaCircular( listaC2 );
	
		listaC.printaListaEncadeadaCircular();
		listaC2.printaListaEncadeadaCircular();
		
		ListaDuplamenteEncadeada lista2 = new ListaDuplamenteEncadeada();
		
		lista2.adiciona( 5 );
		lista2.adiciona( 2 );
		lista2.adiciona( 4 );
		lista2.adiciona( 3 );
		lista2.adiciona( 9 );
		lista2.adiciona( 8 );
		lista2.adiciona( 0 );
		lista2.adiciona( 1 );
		
		lista2.printaListaDuplamenteEncadeada();
		lista2.trocaElos( 6, 1);
		lista2.printaListaDuplamenteEncadeada();
		
	}
	
}
