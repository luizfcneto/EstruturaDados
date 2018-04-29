/*		classe Main 
 * Autor:Luiz Fernando (Luizfcneto123)
 * Email: Luizfcneto123@gmail.com	
 * Descricao: 
 * 	Implantação da Classe Lista Encadeada Ordenada
 *
 */

public class Main {

	public static void main( String[] args ) {
		ListaEncadeadaOrdenada listaOrdenada = new ListaEncadeadaOrdenada();
		
		
		//insere ordenado na lista
		listaOrdenada.adicionaOrdenado( 5 );
		listaOrdenada.adicionaOrdenado( 10 );
		listaOrdenada.adicionaOrdenado( 2 );
		listaOrdenada.adicionaOrdenado( 8 );
		listaOrdenada.adicionaOrdenado( 20 );
		
		//Imprime a Lista Ordenada
		listaOrdenada.printaListaEncadeadaOrdenada();
		
		//Remove Ordenado existe
		listaOrdenada.removeOrdenado( 8 );
		listaOrdenada.removeOrdenado( 20 );
		
		//Remove Ordenado Nao existe
		listaOrdenada.removeOrdenado( 50 );
		
		//Busca na Lista ordenada
		listaOrdenada.buscaOrdenado( 10 );
		
		
	}
	
}
