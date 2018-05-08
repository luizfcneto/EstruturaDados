/*		Classe Main para implantação da Lista04 - ED1
 * 	Autor: Luiz Fernando ( Luizfcneto )
 * 	Email: Luizfcneto123@gmail.com
 * 	 
 * 
 */

public class Main {

	public static void main( String[] args ) {
		ListaEncadeada lista = new ListaEncadeada();
		
		
		
		lista.insereNaLista( 2 );
		lista.insereNaLista( 7 );
		lista.insereNaLista( 5 );
		lista.insereNaLista( 8 );
		lista.insereNaLista( 1 );
		lista.insereNaLista( 9 );
		
		lista.printaListaEncadeada(); 
		
		ListaEncadeadaOrdenada listaOrdenada = new ListaEncadeadaOrdenada( lista );
		
		listaOrdenada.printaListaEncadeadaOrdenada();
		
		
	}
	
}
