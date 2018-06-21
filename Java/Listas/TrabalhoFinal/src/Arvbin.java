/* Nessa implementação, os conceitos de "nó" e "árvore" se misturam. */
public class Arvbin {
	
	private char simbolo; 				/* Símbolo armazenado na raiz. */
	private int frequencia; 			/* Frequência do símbolo armazenado na raiz. */
	private Arvbin esq, dir; 			/* Referências para subárvores esquerda e direita. */
	
	/* Construtor de árvore sem subárvores (dir = esq = null). São fornecidos
	 * apenas o símbolo e a frequência da raiz. */
	public Arvbin( char simbolo, int frequencia ) {
		/* O grupo deve preencher a implementação */
		
		
		
	}
	
	/* Construtor de árvore com subárvores. Além de símbolo e frequência da raiz,
	 * são fornecidas as subárvores, que devem ter sido construídas previamente. */
	public Arvbin( char simbolo, int frequencia, Arvbin esq, Arvbin dir ) {
		/* O grupo deve preencher a implementação */
		
		
	}
	
	/* Imprime o conteúdo da árvore em pré-ordem. */
	public void mostra() {
		/* O grupo deve preencher a implementação */
		
		
		
	}
	
	/* Novo método para imprimir os códigos de Huffman de cada símbolo na árvore. */
	public void mostraCodigo() {
		/* O grupo deve preencher a implementação */
		
	}
	
	/* Caso necessário, o grupo pode definir novos métodos. */
}