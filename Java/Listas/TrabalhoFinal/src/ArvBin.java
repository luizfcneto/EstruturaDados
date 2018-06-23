// Nessa implementação, os conceitos de "nó" e "árvore" se misturam. 
public class ArvBin {
	
	private char simbolo; 				// Símbolo armazenado na raiz.
	private int frequencia; 			// Frequência do símbolo armazenado na raiz.
	private ArvBin esquerda, direita; 	// Referências para subárvores esquerda e direita. 
	
	/* Construtor de árvore sem subárvores (direita = esquerda = null). 
	 São fornecidos apenas o símbolo e a frequência da raiz. */
	public ArvBin( char simbolo, int frequencia ) {
		// O grupo deve preencher a implementação */
		
		
		
	}
	
	/* Construtor de árvore com subárvores. Além de símbolo e frequência da raiz,
	  são fornecidas as subárvores, que devem ter sido construídas previamente. */
	public ArvBin( char simbolo, int frequencia, ArvBin esquerda, ArvBin direita ) {
		// O grupo deve preencher a implementação 
		
		
	}
	
	// Imprime o conteúdo da árvore em pré-ordem.
	public void mostra() {
		// O grupo deve preencher a implementação 
		
		
		
	}
	
	// Novo método para imprimir os códigos de Huffman de cada símbolo na árvore.
	public void mostraCodigo() {
		// O grupo deve preencher a implementação 
		
	}
	
	// Caso necessário, o grupo pode definir novos métodos.
}