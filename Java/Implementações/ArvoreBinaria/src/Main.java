/*		Classe Main para testar classe de ArvBin
 * 	Autor: Luiz Fernando (luizfcneto)
 * 	Email: luizfcneto123@gmail.com
 * 	Descrição: Classe para testar se implementação de ArvBin está correta.
 * 	Entrada: n numeros inteiros
 * 	 
 * 
 */

import java.util.Scanner;

public class Main {
	
	public static void main( String[] args ) {
		Scanner entrada = new Scanner( System.in );
		int n, h, elemento;
		Boolean presente = false;
		
		
		System.out.println( "Defina o tamanho da entrada: " );
		//tamanho da entrada
		n = entrada.nextInt();
		ArvBin arvore = new ArvBin();	
		
		
		//entrada da arvore binaria
		System.out.println( "Informe os valores que deseja inserir na Arvore, digite um negativo para sair: " );
		while ( n > 0 ) {
			arvore.addNaArvBin( entrada.nextInt() );
			n--;
		
		}
		
		//Printa arvore:
		arvore.printaArvBin();
		
		h = arvore.retornaAlturaArvore();
		
		System.out.println( "\n Altura da Arvore: " + h );
		
		System.out.println( "Informe o valor que deseja buscar na arvore: " );
		elemento = entrada.nextInt();
		presente = arvore.busca( elemento );
		if ( presente == null )
			System.out.println( elemento + " NÃO ESTA PRESENTE ");
		
		else 
			System.out.println( elemento + " Está presente ");
		
		
		entrada.close();
	
	}
	
}
