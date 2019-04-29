/*	Implementação Arvore AVL
 * 	Autor: Luiz Fernando ( luizfcneto )
 * 	Email: luizfcneto123@gmail.com
 * 	Descrição: Classe main para testar implementação da Árvore AVL por ponteiros.
 * 
 */

public class Main {

	public static void main( String[] args ) {
		ArvBinAVL arvoreAVL = new ArvBinAVL();
		ArvBinBusca arvoreBUSCA = new ArvBinBusca();
		
		//Teste 1: inserindo na arvore, desbalanceamento para testar RSE
//		arvoreAVL.insere( 6 , 6 );
//		arvoreAVL.insere( 3 , 3 );
//		arvoreAVL.insere( 9 , 9 );
//		arvoreAVL.insere( 12 , 12 );
//		arvoreAVL.insere( 15 , 15 );
//		
//		arvoreBUSCA.insere( 6, 6);
//		arvoreBUSCA.insere( 3, 3);
//		arvoreBUSCA.insere( 9, 9);
//		arvoreBUSCA.insere( 12, 12);
//		arvoreBUSCA.insere( 15, 15);
		
		//teste 2: inserindo na arvore, desbalanceamento para testar RSD
//		arvoreAVL.insere( 6 , 6 );
//		arvoreAVL.insere( 3 , 3 );
//		arvoreAVL.insere( 8 , 8 );
//		arvoreAVL.insere( 2 , 2 );
//		arvoreAVL.insere( 1 , 1 );
//		
//		arvoreBUSCA.insere( 6, 6);
//		arvoreBUSCA.insere( 3, 3);
//		arvoreBUSCA.insere( 9, 9);
//		arvoreBUSCA.insere( 12, 12);
//		arvoreBUSCA.insere( 15, 15);
		
		//teste 3:
		arvoreAVL.insere( 10, 10 );
		arvoreAVL.insere( 6, 6 );
		arvoreAVL.insere( 15, 15 );
		arvoreAVL.insere( 8, 8 );
		arvoreAVL.insere( 21, 21 );
		arvoreAVL.insere( 2, 2 );
		arvoreAVL.insere( 12, 12 );
		arvoreAVL.insere( 13, 13 );
		arvoreAVL.insere( 1, 1 );
		arvoreAVL.insere( 4, 4 );
		arvoreAVL.insere( 3, 3 );
		
		arvoreBUSCA.insere( 10, 10 );
		arvoreBUSCA.insere( 6, 6 );
		arvoreBUSCA.insere( 15, 15 );
		arvoreBUSCA.insere( 8, 8 );
		arvoreBUSCA.insere( 21, 21 );
		arvoreBUSCA.insere( 2, 2 );
		arvoreBUSCA.insere( 12, 12 );
		arvoreBUSCA.insere( 13, 13 );
		arvoreBUSCA.insere( 1, 1 );
		arvoreBUSCA.insere( 4, 4 );
		arvoreBUSCA.insere( 3, 3 );
		
		
		//Imprime Arvore sem rotação:
		System.out.println( "Arvore de Busca:" );
		arvoreBUSCA.mostra();
		
		System.out.println("\n");
		//Imprime Arvore AVL com rotação:
		System.out.println( "Arvore AVL:" );
		arvoreAVL.mostra();
		
		System.out.println();
		
	}
	
}
