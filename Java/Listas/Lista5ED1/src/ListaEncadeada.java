/*		Classe Lista Encadeada
 * 	Autor: Luiz Fernando (Luizfcneto)
 * 	Email: Luizfcneto123@gmail.com
 * 		
 * 	Descrição:	Esta classe será responsavel pela implementação da estrutura Lista Encadeada.
 * 		Uma Lista encadeada começa com uma referencia ( "primeiro" ) para uma celula da memoria, 
 * 		que inicialmente deve ser nulo para que não tenhamos acesso a alguma celula de memoria ja 
 * 		utilizada ( para nao corromper esses dados ao fazer as manipulações ).
 * 		
 * 		Essa referencia apontará para uma outra classe aninhada denotada de Elo (ou No) da Lista que terá dois campos (atributos)
 * 		o conteudo, e uma referencia para o proximo Elo ( Elemento ).		
 * 
 *
 * 		Ao adicionarmos um Elo na lista, na pratica estamos criando um Elo e referenciando ele à primeira posição da Lista. 
 * 		( Ao Adicionarmos um elo, criamos um Elo, apontamos pro proximo de elo para o que o primeiro aponta, em seguida 
 * 		fazemos o primeiro apontar para o recem criado. (Adicionamos Elo no inicio da Lista)
 * 		
 * 
 * 	Atributos de ListaEncadeada:
 * 		- Elo primeiro;
 * 		- //int tamanho;
 * 		
 * 		Atributos de Elo:
 * 			- int dado;
 * 			- Elo proximo;
 * 	
 * 	Métodos de ListaEncadeada:
 * 		- listaVazia();							//verifica se lista está vazia, quando o primeiro referencia a nulo;
 * 		- tamanhoDaLista (); 
 * 		- insereNaLista ( Elo );	
 * 		- removeDaLista ( conteudo )			//Criterios podem ser posição da Lista, ou por conteudo dos Elos
 * 		- buscaConteudoNaLista ( conteudo )
 * 		- printaListaEncadeada 					//Para fins didádicos e termos uma melhor visualização dos Elementos da lista
 */


public class ListaEncadeada {
	
	//Referencia do inicio da Lista
	protected Elo primeiro;
	
	//Classe aninhada Elo
	protected class Elo{
		int conteudo;
		Elo proximo;
		
		//Construtor de Elo default (Sem conteudo)
		public Elo () {
			this.proximo = null;
		}
		
		//Construtor de Elo com conteudo Novo
		public Elo ( int conteudoNovo ) {
			this.conteudo = conteudoNovo;
			this.proximo = null;
		}
		
		//Construtor de Elo com conteudo novo e referencia para o proximo Elo
		public Elo ( int conteudoNovo, Elo proximoElo ) {
			this.conteudo = conteudoNovo;
			this.proximo = proximoElo;
		}
		
		
	}
	
	//construtor default, da classe lista encadeada
	public ListaEncadeada ( ) {
		this.primeiro = null;
	}
	
	//Verifica se lista encadeada está vazia
	public boolean listaVazia () {
		if ( this.primeiro == null )
			return true;
		
		else
			return false;
	}
	
	//Insere no inicio da Lista Encadeada
	public void insereNaLista ( int conteudoNovo ) {
		Elo novo = new Elo( conteudoNovo ); 
		
		//o elemento novo irá apontar para nulo, que é apontado por this.primeiro.proximo
		novo.proximo = this.primeiro;
		
		//a referencia do primeiro aponta para o elemento novo
		this.primeiro = novo;
		
	}
	
	//Remove um elemento da Lista Encadeada ( por conteudo! )
	public Elo removePorConteudoDaLista ( int conteudo ) {
		
		if ( !this.listaVazia() ) {
			boolean presente = false;
			Elo auxiliar = new Elo ( );			 
			Elo anterior = new Elo ( );			
			
			auxiliar = this.primeiro;
			auxiliar = auxiliar.proximo;			//auxiliar vai ser o elemento que vai percorrer a lista toda
			anterior = this.primeiro;				//o anterior vai ser o elemento anterior ao auxiliar [percorre a lista toda tbm]
			
			while ( auxiliar != null ) {
				if ( auxiliar.conteudo == conteudo ) {
					presente = true;
					anterior.proximo = auxiliar.proximo;
					break;
				}
				auxiliar = auxiliar.proximo;
				anterior = anterior.proximo;
				
			}
			if ( !presente ) {
				System.out.println( "Não existe nenhum elemento com o conteudo " + conteudo + " nesta Lista Encadeada" );
				return null;
			
			} else
				
				return auxiliar;				
		
		} else {
			System.out.println( "Lista Encadeada Vazia! ");
			return null;
			
		}
	}
	
	//busca na lista encadeada [por conteudo]
	public void buscaConteudoNaLista( int conteudo ) {
		
		if ( !this.listaVazia() ) {
			Elo auxiliar = new Elo ();
			auxiliar = this.primeiro;
			boolean presente = false;
			
			while ( auxiliar != null ) {
				if ( auxiliar.conteudo == conteudo ) {
					System.out.println( "Elemento: " + auxiliar.conteudo + " Endereco: [ " + auxiliar + " ] " );
					presente = true;
				}
				
				auxiliar = auxiliar.proximo;
			}
			if ( !presente )
				System.out.println( "Não existe nenhum elemento que contenha  o conteudo " + conteudo + " na lista!! "  );
			
			
		} else 
			System.out.println( "Lista Encadeada Vazia! " );
	}
	
	//Imprime a Lista Encadeada [para fins didaticos]
	public void printaListaEncadeada ( ) {
		
		if ( !this.listaVazia() ) { 
			
			int contador = 0;
			Elo auxiliar = new Elo( );
			auxiliar = this.primeiro;
			
			while ( auxiliar != null ) {
				System.out.println("Indice: " + contador + " Elemento: " + auxiliar.conteudo );
				auxiliar = auxiliar.proximo;
				contador++;
				
			}
		} else 
			System.out.println( "Lista Encadeada Vazia! " );
		
	}
	
}
