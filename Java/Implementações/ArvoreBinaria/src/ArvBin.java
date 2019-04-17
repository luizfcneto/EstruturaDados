/*		Implementação da Estrutura de Dados - Arvore Binaria
 * 	Autor: Luizfcneto
 * 	Email: luizfcneto123@gmail.com
 * 	Descrição: Implementação da Estrutura de dados - Arvore binária através de ponteiros!
 * 	
 * 	- Atributos:
 * 		- ArvBin esquerda;
 * 		- ArvBin direita;
 * 		- int valor;				//Arvore contendo valor do tipo inteiro.
 * 		- int altura;
 * 		
 * 	- Métodos:
 * 		- boolean busca ( int valor );			
 * 		- ArvBin busca( int valor );			
 * 		- int retornaValor ();					
 * 		- ArvBin retornaEsquerda();				
 * 		- ArvBin retornaDireita();				
 * 		- boolean arvoreVazia();				
 * 		- void defineEsquerda( ArvBin filho );	
 * 		- void defineDireita ( ArvBin filho );	
 * 		- void retornaAlturaArvore ();			
 * 		- void printaArvBin ();					
 * 	
 */

public class ArvBin {

	//Atributos
	ArvBin esquerda, direita;
	int valor;
	int altura = -1;		//-1 = vazia; 
	
	//Construtor 1
	public ArvBin ( int valor, ArvBin direita, ArvBin esquerda ) {
		this.valor = valor;
		this.direita = direita;
		this.esquerda = esquerda;
		this.altura = 0;
		
	}
	
	//Construtor 2
	public ArvBin ( int valor ) {
		this.valor = valor;
		this.esquerda = null;
		this.direita = null;
		this.altura = 0;
		
	}
	
	//Construtor 3;
	public ArvBin ( ) {
		this.esquerda = null;
		this.direita = null;
		this.altura = -1;
		
	}
	
	// Retorna o valor contido no nó da árvore.
	public int retornaValor () {
		return this.valor;
		
	}
	
	//Retorna a referencia da raiz da subArvore direita
	public ArvBin retornaDireita() {
		return this.direita;
		
	}
	
	//Retorna a referencia da raiz da subArvore esquerda
	public ArvBin retornaEsquerda() {
		return this.esquerda;
		
	}
	
	//Define Filho da Esquerda
	public void defineEsquerda( ArvBin filho ) {
		this.esquerda = filho;
		
	}
	
	//Define Filho da Direita
	public void defineDireita ( ArvBin filho ) {
		this.direita = filho;
		
	}
	
	//verifica se arvore está vazia
	public boolean arvoreVazia() {
		if( this.altura == -1 )
			return true;
		
		else 
			return false;
	}
	
	//Método para atualizar Altura da arvore
	public int alturaArvore( ) {
		
		if ( this.direita == null && this.esquerda == null )
			return 0;
		
		int altEsq = 0;
		int altDir = 0;
		
		if ( this.esquerda != null ) 
			altEsq = esquerda.alturaArvore();			
		
		if ( this.direita != null ) 
			altDir = direita.alturaArvore();
		
		if ( altEsq >= altDir )
			return 1 + altEsq;
		
		else 
			return 1 + altDir;
		
	}

	//Método para buscar nó na arvore retorna Boolean
//	public Boolean busca ( int numero ) {
//		
//		if ( !this.arvoreVazia() ) {
//			
//			if ( this.valor == numero )
//				return true;
//			
//			if ( this.esquerda != null && this.valor > numero ) 
//				return this.esquerda.busca( numero );
//			
//			if ( this.esquerda == null && this.valor > numero )
//				return false;
//			
//			if ( this.direita != null && this.valor < numero )
//				return this.direita.busca( numero );
//				
//			if ( this.direita == null && this.valor < numero );
//				return false;
//				
//		}else 
//			return false;
//	
//	}
	
	//Método para buscar elemento na arvore, retornando o nó.
	public ArvBin busca ( int numero ) {
		if ( !this.arvoreVazia() ) {
			if ( this.valor == numero ) 
				return this;
			
			if ( this.esquerda != null && this.valor > numero ) 
				return this.esquerda.busca( numero );
			
			if ( this.esquerda == null && this.valor > numero )
				return null;
			
			if ( this.direita != null && this.valor < numero )
				return this.direita.busca( numero );
				
			if ( this.direita == null && this.valor < numero );
				return null;
				
		}else 
			return null;
	}
	
	//Método para adicionar elemento novo na Árvore. 
		public void adiciona ( int numero ) {
			
			//Se arvore estiver vazia: não tem como comparar com valor algum
			if ( this.altura == -1) {
				this.valor = numero;
				this.altura++;
			
			}else {
				// numero menor que valor do "pai" da subArvore
				if ( numero < this.valor ) {
					if ( this.esquerda != null ) 
						this.esquerda.adiciona( numero );
					
					else {
						ArvBin nova = new ArvBin ( numero );
						this.esquerda = nova;
						nova.altura = this.altura+1;
					
					}
				}
				
				// numero maior que valor do "pai" da subArvore
				if ( numero > this.valor ) {
					if ( this.direita != null ) 
						this.direita.adiciona ( numero );
					
					else {
						ArvBin nova = new ArvBin ( numero );
						this.direita = nova;
						nova.altura = this.altura+1;
					
					}	
				}
			}
		}
			
	//Método para imprimir elementos da Árvore
	public void printaArvBin () {
		
		if ( this.altura > -1 ) {
			System.out.print( "( " + this.valor + " h: "+ this.altura);
			
			if ( this.esquerda != null ) 
				esquerda.printaArvBin();
			
			if ( this.direita != null )
				direita.printaArvBin();
			
			System.out.print( " ) ");			
			
		}else 
			System.out.println("Arvore Vazia!");
		
	}
}
