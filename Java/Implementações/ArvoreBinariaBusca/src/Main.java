/*
 * 
 * 
 */

public class Main {
	
	public static void main( String[] args ) {
		ArvBinBusca arvore = new ArvBinBusca();
		int altura; 
		
		//inserindo na arvore de busca:
		arvore.insere( 6, 50 );
		arvore.insere( 8, 30 );
		arvore.insere( 2, 60 );
		arvore.insere( 1, 10 );
		arvore.insere( 4, 20 );
		arvore.insere( 3, 80 );
		
		//printa arvore:
		arvore.mostra();
		System.out.println();
		
		//Remove nó que tem chave 4 na Arvore:
//		arvore.remove( 3 );
		
		//printa arvore: 
		arvore.mostra();
		System.out.println();
		
		//calcula altura da arvore
		altura = arvore.altura();
		System.out.println( altura );
		
	}
	
}
