/*
 * 		Classe de estrutura de dados: Pilha Genérica
 * 	Autor: Luiz Fernando (Luizfcneto)
 * 	Email: Luizfcneto123@gmail.com
 * 	Descrição: Implementação do algoritmo de manipulação de uma pilha generica, 
 * 		Implementando metodos necessários para resolução da lista 01:
 * 		
 * 		b) i- void transferePilha( PilhaGenerica<T> pilhaNova )					-> Elimina os elementos da pilha antiga
 * 		   ii- void transferePilhaRecursivo ( pilhaGenerica<T> pilhaNova )		-> Elimina os elementos da pilha antiga
 * 			
 * 		c) função pra reverter a ordem da pilha, void revertePilha () ;
 * 
 * 		d) i- void copiaPilha( PilhaGenerica<T> pilhaNova );
 * 		   ii- void copiaPilhaRecursivo ( PilhaGenerica<T> pilhaNova );
 * 		
 * 	
 * 	Entrada: tamanhoPilha (int), valoresEntrada (Qualquer Objeto - T)
 *
 */

//import java.util.ArrayList;
import java.util.Vector;

public class PilhaGenerica<T> {
	private int topo, tamanhoPilhaGenerica;
	private Vector<T> vetorPilhaGenerica;
	
	
	//Construtor de Pilha Generica
	public PilhaGenerica( int tamanho ) {
		this.tamanhoPilhaGenerica = tamanho;
		this.topo = -1;
		vetorPilhaGenerica = new Vector<T>();
	}
	
	//Construtor sem parametro
	public PilhaGenerica() {
		this.tamanhoPilhaGenerica = 20;
		this.topo = -1;
		vetorPilhaGenerica = new Vector<T>();

	}
	
	//verifica se pilha está cheia:
	public boolean verificaPilhaCheia() {
		if ( this.topo == ( this.tamanhoPilhaGenerica - 1 ) ) {
			return true;
		
		}else 
			return false;

	}

	//Verifica se pilha está vazia:
	public boolean verificaPilhaVazia() {
		if ( this.topo == -1 ) {
			return true;
			
		} else 
			return false;
	
	}
	
	//decrementa topo:
	public T pop() {
		T elemento;
		if ( !verificaPilhaVazia() ) {
			elemento = this.vetorPilhaGenerica.get( this.topo );
			this.topo--;
			return elemento;
			
		} else { 
			System.out.println( "PILHA VAZIA!" );
			return null;
		}
		
	}
	
	//adiciona elemento ao topo e topo incrementa:
	public boolean push(T elemento) {
		if ( !verificaPilhaCheia() ) {
			
			for ( int contador = 0; contador < this.tamanhoPilhaGenerica; contador++ ) {
				if ( contador == this.topo ) {
					this.topo++;
					vetorPilhaGenerica.add( elemento );
				
				}
				
			}
			return true;
			
		} else {
			System.out.println( "PILHA CHEIA!" );
			return false;
			
		}
	}
	
	//Retorna o elemento do topo
	public boolean retornaTopo( T elemento ) {	
		if ( !verificaPilhaVazia() ) {
			elemento = this.vetorPilhaGenerica.get( this.topo );		//elemento por ser um objeto, é passado por referencia, então tudo que for alterado nele será passado para variavel na main
			return true;
			
		} else {
			System.out.println( "ERRO PILHA VAZIA!" );
			return false;
			
		}
		
	}
	
	
	//1) bi- Fazer uma transferencia[Pilha Antiga -> Vazia, Pilha Nova -> elementos da Pilha Antiga] da pilha que solicitou este método para uma pilhaNova (supondo que pilhaNova tenha o mesmo tamanho ou maior que antiga)
	public void transferePilha( PilhaGenerica<T> pilhaNova ) {
		if ( !this.verificaPilhaVazia() ) {
			int contador;
			
			for ( contador = this.topo; contador >= 0; contador-- ) {
				pilhaNova.push( this.pop() );
			
			}
			
		} else 
			System.out.println( "Não foi possivel realizar transferencia! Pilha Vazia! " );
		
	}	
	
	//1) bii - Fazer uma transferencia de uma pilha por recursividade
	public void transferePilhaRecursivo( PilhaGenerica<T> pilhaNova ) {
		
		//condição de parada: pilha antiga tem que estar vazia
		if ( this.verificaPilhaVazia() ) 
			System.out.println( "Transferencia realizada com sucesso!" );
		
		else {
			pilhaNova.push( this.pop() );
			transferePilhaRecursivo( pilhaNova );
			
		}
		
		
	}
	
	//1) c - Reverter a ordem da pilha que solicitou o metodo
	public void revertePilha() {
		PilhaGenerica<T> pilhaNova = new PilhaGenerica<T>( this.tamanhoPilhaGenerica );
		if ( !this.verificaPilhaVazia() ) {
			
			//transferindo para pilha nova, ao contrario
			for( int contadorPilha = this.topo; contadorPilha >= 0; contadorPilha-- ) {
				pilhaNova.push(  this.pop() );
				
			}
			copiaPilha ( this );
		} else 
			System.out.println( "Pilha Vazia, não pode ser revertida!" );

	}
	
	
	//1) di - Fazer uma cópia da pilha antiga na nova, mantendo assim as duas com os mesmos elementos
	public void copiaPilha( PilhaGenerica<T> pilhaNova ) {
		int contador;
		
		for ( contador = this.tamanhoPilhaGenerica; contador >= 0; contador-- ) {
			pilhaNova.push( this.vetorPilhaGenerica.get( contador ) ); 
			
		}
		pilhaNova.topo = this.topo;
		
	}
	
	//1) dii - Fazer uma copia da pilha antiga na nova, por recursividade
	public void copiaPilhaRecursivo ( PilhaGenerica<T> pilhaNova ) {
		
		//condição de parada, topo da pilha nova tem que ser igual a pilha antiga
		if ( pilhaNova.topo == this.topo ) 
			System.out.println( "Transferencia concluida!" );
		
		else {
			pilhaNova.push( this.vetorPilhaGenerica.elementAt( pilhaNova.topo ) );
			transferePilhaRecursivo ( pilhaNova );
		}
	}
	
	
	//Metodo para facilitar visualização: Printar toda a pilha
	public void printaPilhaGenerica() {
		if ( !verificaPilhaVazia() ) {
			System.out.println("_____________________________\tInicio\t___________________________________________________\n");
			
			for ( int contador = 0; contador < this.tamanhoPilhaGenerica; contador++ ) {
				if ( contador == this.topo ) {
					System.out.println( " Topo > Posicao: "+ ( contador + 1 ) + " - Elemento: [ " + this.vetorPilhaGenerica.get( contador ) + " ]" );
				}else {
					System.out.println( " Posicao: "+ ( contador + 1 ) + " - Elemento: [ " + this.vetorPilhaGenerica.get( contador )  + " ]" );
				}
				
			}
			System.out.println("______________________________\tFim\t___________________________________________________ \n");
		
		}else 
			System.out.println( "PILHA VAZIA!!" );
				
	}	
	
}
