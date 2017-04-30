/*
Descrição: Implementação e declaração das funcoes de lista duplamente encadeada


Nome: Luiz Fernando (luizfcneto)
*/

//Declaração da estrutura Aluno, pra simplificar iremos manipular somente com matricula
typedef struct tAluno
{
	int matricula;
	//int idade;
	//char nome[50];
	//float nota1, nota2, nota3;
}taluno;

struct _tElemento
{
	struct _tElemento *anterior;
	struct _tElemento *proximo;
	taluno info;
};

typedef struct _tElemento *tRaiz;
typedef struct _tElemento tElemento;

//Criar Lista
tRaiz* criaLista ( tRaiz* referenciaRaiz )
{
	tRaiz *listaNova;
	listaNova = (tRaiz*) malloc ( sizeof ( tRaiz ) );
	if ( listaNova == NULL ) printf("ERRO - Lista Nova Invalida! \n");
	return listaNova;
}	

//Liberar Lista
void liberaLista ( tRaiz* referenciaRaiz )
{
	if ( referenciaRaiz != NULL )
	{
		tRaiz *noh;		//noh vai armazenar cada elemento da lista(*referenciaRaiz) e referenciaRaiz vai percorrer a lista 
		noh = *referenciaRaiz;
		while ( referenciaRaiz != NULL ){
			noh = *referenciaRaiz;
			*referenciaRaiz = (*referenciaRaiz)->proximo;
			free ( noh );
		}
		free ( referenciaRaiz );
	}else {
		puts ("ERRO - Lista Vazia \n");
	}
}

//Tamanho Lista
int tamanhoLista ( tRaiz* referenciaRaiz )
{

}

//Lista Vazia
int listaVazia ( tRaiz* referenciaRaiz )
{

}

//Lista Cheia -> Não faz sentido em listas dinamicas, o limite de alocação é a quantidade de memoria disponivel pra rodar o programa

//Adiciona na Lista Ordenado
void adicionaOrdenadoLista ( tRaiz* referenciaRaiz )
{

}

//Adiciona no final da Lista 
void adicionaFinalLista ( tRaiz* referenciaRaiz )
{

}

//Adiciona no Inicio da Lista
void adicionaInicioLista ( tRaiz* referenciaRaiz )
{

}

//Remover elemento por posicao
void removerPosicaoLista ( tRaiz* referenciaRaiz, int indice )
{

}

//Remover elemento por conteudo [matricula]
void removerConteudoLista ( tRaiz* referenciaRaiz, taluno* rap )
{



}

//Busca por indice
void buscaPosicaoLista ( tRaiz* referenciaRaiz, int indice )
{

}

//Busca por Conteudo [matricula]
void buscaConteudoLista ( tRaiz* referenciaRaiz, taluno* rap )
{

}

//Printa lista na tela
void printaListaDuplamenteEncadeada ( tRaiz* referenciaRaiz )
{

}