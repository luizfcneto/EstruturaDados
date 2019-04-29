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
	
	/*
	 * 
	 * Node deleteNode(Node root, int key)  
    {  
        // STEP 1: PERFORM STANDARD BST DELETE  
        if (root == null)  
            return root;  
  
        // If the key to be deleted is smaller than  
        // the root's key, then it lies in left subtree  
        if (key < root.key)  
            root.left = deleteNode(root.left, key);  
  
        // If the key to be deleted is greater than the  
        // root's key, then it lies in right subtree  
        else if (key > root.key)  
            root.right = deleteNode(root.right, key);  
  
        // if key is same as root's key, then this is the node  
        // to be deleted  
        else
        {  
  
            // node with only one child or no child  
            if ((root.left == null) || (root.right == null))  
            {  
                Node temp = null;  
                if (temp == root.left)  
                    temp = root.right;  
                else
                    temp = root.left;  
  
                // No child case  
                if (temp == null)  
                {  
                    temp = root;  
                    root = null;  
                }  
                else // One child case  
                    root = temp; // Copy the contents of  
                                // the non-empty child  
            }  
            else
            {  
  
                // node with two children: Get the inorder  
                // successor (smallest in the right subtree)  
                Node temp = minValueNode(root.right);  
  
                // Copy the inorder successor's data to this node  
                root.key = temp.key;  
  
                // Delete the inorder successor  
                root.right = deleteNode(root.right, temp.key);  
            }  
        }  
  
	 */
	
	
}
