/*		Classe principal
 * 	Autor: Luiz Fernando (Luizfcneto)
 * 	Email: Luizfcneto123@gmail.com
 * 	
 * 	Descrição: Classe principal será responsavel pela manipulação 
 * 	 de informação utilizando uma implementação de Lista Encadeada
 * 	
 * 	
 * 
 * 
 * 
 */


public class Main {

	public static void main( String[] args ) {
		ListaEncadeada lista = new ListaEncadeada();
		
		//testando inserindo na lista:
		lista.insereNaLista( 15 );
		lista.insereNaLista( 10 );
		lista.insereNaLista( 5 );
		lista.insereNaLista( 40 );
		lista.insereNaLista( 100 );
		
		//printa Lista
		lista.printaListaEncadeada();
		
		
		
		//testando remover:		[com conteudo na lista]
		lista.removePorConteudoDaLista( 15 );
		
		//testando remover: 	[sem conteudo na lita]
		lista.removePorConteudoDaLista( 90 );
		
		//buscando um elemento na lista [ que esteja na lista ]
		lista.buscaConteudoNaLista( 10 );
		
		//buscando um elemento 			[ que nao esteja na lista]
		lista.buscaConteudoNaLista( 90 );
		
		System.out.println( "____________________________________________________________________________________" );
		lista.printaListaEncadeada();
	
	}
	
}
