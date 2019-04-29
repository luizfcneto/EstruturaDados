/*		Implementação da Estrutura de Dados - Arvore Binaria Balanceada AVL - Ponteiro!
 * 	Autor: Luiz Fernando ( luizfcneto )
 * 	Email: luizfcneto123@gmail.com
 * 	Descrição: Implementação da estrutura de dados Arvore Binaria de Busca Balanceada AVL por ponteiros
 * 
 * 	- Atributos:
 * 		- No esquerda, direita, raiz;
 * 		- int valor;				//Arvore contendo valor do tipo inteiro.
 * 		- int altura;
 * 		- int balanco;	he - hp = pertence { -1, 0, 1 }
 * 		
 * 	- Métodos:
 * 		- No rotacaoSimplesEsquerda();
 * 		- No rotacaoDuplaEsquerda();
 * 		- No rotacaoSimplesDireita();
 * 		- No rotacaoDuplaDireita();
 *  	- insere();
 *  	- remove();
 */

public class ArvBinAVL extends ArvBinBusca{
	private No raiz;
	
	private int getBalanco( No aux ) {
		if ( aux == null )	return 0;
		
		else
			return getAltura( aux.esquerda ) - getAltura( aux.direita );
	}
	
	private No rotacaoSimplesEsquerda( No p ) {
		No u = p.direita;
		No t2 = u.esquerda;
		
		//Rotação:
		u.esquerda = p;
		p.direita = t2;
		
		//Atualiza alturas
		p.altura = 1 + Math.max( getAltura (p.esquerda ), getAltura( p.direita ) );
		u.altura = 1 + Math.max( getAltura( u.esquerda ), getAltura( u.direita ) );
		
		return u;
	}
	
	private No rotacaoSimplesDireita( No p ) {
		No u = p.esquerda;
		
		No t2 = u.direita;
		
		//rotação:
		u.direita = p;
		p.esquerda = t2;
		
		//Atualiza alturas
		p.altura = 1 + Math.max( getAltura( p.esquerda ), getAltura( p.direita ) );
		u.altura = 1 + Math.max( getAltura( u.esquerda ), getAltura( u.direita ) );
		return u;
	}
	
	private void set( No aux, int valor ) {
		aux.valor = valor;
	}
	
	
	public void insere( int chave, int valor ) {
		raiz = insere( raiz, chave, valor );
	}
	
	private No insere( No aux, int chave, int valor ) {
		if ( aux == null ) 
			return new No( chave, valor );
						
		if ( aux.chave == chave ) 
			set( aux, valor );

		if ( aux.chave > chave ) {
//			aux.altura = 1 + Math.max( getAltura( aux.direita ) , getAltura( aux.esquerda ) );
			aux.esquerda = insere( aux.esquerda, chave, valor );
					
		} else if ( aux.chave < chave ) {
//			aux.altura = 1 + Math.max( getAltura ( aux.direita ), getAltura ( aux.esquerda ) );
			aux.direita = insere( aux.direita, chave, valor );
							
		}
		else 
			return aux;		
		
		//atualiza altura:
		aux.altura = 1 + Math.max( getAltura( aux.direita ) , getAltura( aux.esquerda ) );
		
		int balanco = getBalanco( aux );
		
		//Caso de desbalanceamento rotacao simples a direita ou dupla a direita
		if ( balanco > 1 ) {
			
			//u = aux.esquerda, he(u) > hd(u) == rotacao simples a direita 
			if ( getAltura( aux.esquerda.esquerda ) > getAltura( aux.esquerda.direita ) ) 				
				return rotacaoSimplesDireita( aux );
			
			//Rotacao dupla a direita: RSE( aux.esq )  + RSD( aux );
			else if ( getAltura ( aux.esquerda.esquerda ) < getAltura ( aux.esquerda.direita ) ) {
				aux.esquerda = rotacaoSimplesEsquerda( aux.esquerda );
				return rotacaoSimplesDireita( aux );
			}
			
		}
		if ( balanco < -1 ) {
			
			// u = aux.direita he(u) < hd (u) == rotacao simples a esquerda
			if ( getAltura( aux.direita.esquerda ) < getAltura( aux.direita.direita ) ) 
				return rotacaoSimplesEsquerda( aux );
			
			//Rotacao dupla a esquerda: RSD ( aux.dir ) + RSE( aux );
			else if ( getAltura ( aux.direita.esquerda ) < getAltura( aux.direita.direita ) ) {
				aux.direita = rotacaoSimplesDireita ( aux.direita );
				return rotacaoSimplesEsquerda( aux );
				
			}
		}
		
		return aux;
	}
	
	public void mostra( ) {
		super.mostra( raiz );
	}
	public int minimo(){
		if ( this.vazia() ) {
			System.out.println( "Arvore Vazia!" );
			return 8000;
		}
		else
			return minimo( raiz ).chave;
	}
	
	//Retorna a chave de menor valor a partir de um nó desejado.
	protected No minimo( No aux ) {
		if ( aux.esquerda == null )
			return aux;
		
		else
			return minimo( aux.esquerda );
	}
	
	//Chama método privado de remover o elemento minimo de um nó especifico
	public void removeMin() {
		raiz = removeMin( raiz );
	}
		
	//Remove elemento minimo de uma subarvore do do nó auxiliar específico
	protected No removeMin( No aux ) {
		if ( aux.esquerda == null )
			return aux.direita;
		
		aux.esquerda = removeMin( aux.esquerda );
		return aux;
				
	}
	
	//Remove elemento com chave correspodente, caso exista na Arvore
	public boolean remove( int chave ) {
		if ( raiz == null )
			return false;
		
		if ( remove( raiz, chave ) != null )
			return true;
		
		else 
			return false;
	}
	public No remove( No aux, int chave ){ 
		//Se percorrer e não encontrar o nó com chave desejada
		if ( aux == null )
			return null;
				
		//Procura nó que contenha a chave desejada
		if ( chave < aux.chave )
			aux.esquerda = remove( aux.esquerda, chave );
				
		else if ( chave > aux.chave )
			aux.direita = remove ( aux.direita, chave );
				
		//Nó que contém a chave que deve ser removido
		else {
			if ( aux.direita == null )
				return aux.esquerda;
					
			if ( aux.esquerda == null )
				return aux.direita;
			
			//Variavel temporaria para auxiliar com referencia
			No temp = aux;
					
			//auxiliar recebe o sucessor, que é o menor nó da subArvore direita
			aux = minimo( temp.direita );
					
			//Remove o menor nó da subArvore direita
			aux.direita = removeMin( temp.direita );
			
			//Mantém subArvore esquerda
			aux.esquerda = temp.esquerda;
					
		}

        // Atualiza a altura do nó  
        aux.altura = 1 + Math.max( getAltura( aux.esquerda ), getAltura( aux.direita ));  
  
        // Recebe o balanceamento do nó   
        int balanco = getBalanco( aux );  
  
        // Rotação simples a direita
        if ( balanco > 1 && getBalanco( aux.esquerda ) >= 0 )  
            return rotacaoSimplesDireita( aux );  
  
        // Rotação dupla a direita 
        if ( balanco > 1 && getBalanco( aux.esquerda ) < 0 ) {  
            aux.esquerda = rotacaoSimplesEsquerda( aux.esquerda );  
            return rotacaoSimplesEsquerda( aux );  
        }  
  
        // Rotação simples a direita
        if ( balanco < -1 && getBalanco( aux.direita ) <= 0)  
            return rotacaoSimplesDireita( aux );  
  
        // Rotação dupla a esquerda
        if ( balanco < -1 && getBalanco( aux.direita ) > 0) {  
            aux.direita = rotacaoSimplesDireita( aux.direita );  
            return rotacaoSimplesEsquerda( aux );  
        }  
		
		return aux;
	}	
}
