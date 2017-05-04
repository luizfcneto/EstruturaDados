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
	int indice = 0;
	if ( referenciaRaiz != NULL )	{
		tElemento *noh;
		noh = ( tElemento* ) malloc ( sizeof ( tElemento ) );
		if ( noh == NULL )	printf ("ERRO - Noh nao criado com Sucesso! \n");
			while ( noh != NULL ) {
				indice++;
			}
	} else {
		puts ("ERRO - Lista Invalida! \n");
	}
	return indice;
}

//Lista Vazia
int listaVazia ( tRaiz* referenciaRaiz )
{
	if ( referenciaRaiz == NULL ) return 1;
	if ( *referenciaRaiz == NULL ) return 1;
	else return 0;
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
	if ( referenciaRaiz != NULL ) {
		if ( indice > tamanhoLista ( referenciaRaiz ) || indice < 0 )	puts ("ERRO - Indice Invalido, menor ou maior que tamanho da Lista!\n");
		else { 
			tElemento *noh;
			noh = ( tElemento* ) malloc ( sizeof ( tElemento ) );
			if ( noh == NULL )	puts ("ERRO - Noh nao criado com sucesso! \n");
			else {
				int i = 0;
				while ( noh != NULL ){
					if ( i == indice ) {
						printf ("Indice: [ %d ] \tConteudo (Matricula): [ %d ] \n", indice, noh->info.matricula );
						break;
					}
					i++;
					noh = noh->proximo;
				}
			}
		}
	} else {
		printf ("ERRO - Lista Invalida! \n");
	}
}

//Busca por Conteudo [matricula]
void buscaConteudoLista ( tRaiz* referenciaRaiz, taluno* rap )
{
	if ( referenciaRaiz != NULL ) {
		tElemento *noh;
		if ( listaVazia ( referenciaRaiz ) != 1 ){
			noh = ( tElemento* ) malloc ( sizeof( tElemento ) );
			if ( noh == NULL ) 	puts ("ERRO - Noh nao criado com Sucesso! \n");
			else {
				int tem = -1, indice = 0;
				while ( noh != NULL ) {
					if ( noh->info.matricula == rap->matricula ) {
						tem = 1;
						printf ("Indice: [ %d ] \tConteudo (Matricula): [ %d ] \n", indice, noh->info.matricula );
						break;
					}
					noh = noh->proximo;
					indice++;
				}
				if ( tem == -1 )	puts ("ERRO - Elemento nao consta na Lista! \n");
			}
		} else puts ("ERRO - Lista Vazia! \n");
	} else {
		puts ("ERRO - Lista Invalida! \n");
	}

}

//Printa lista na tela
void printaListaDuplamenteEncadeada ( tRaiz* referenciaRaiz )
{
	if ( referenciaRaiz != NULL )	{
		tElemento *noh;
		noh = ( tElemento* ) malloc ( sizeof ( tElemento ) );
		if( noh == NULL)	printf ("ERRO - Noh nao criado com Sucesso! \n");
		else {
			noh = *referenciaRaiz;
			int indice = 0;
			while ( noh != NULL )	{
				printf (" Indice: [ %d ] \tEndereco: [ %p ] \tConteudo (Matricula): [ %d ] \tAponta: [ %p ] \n", indice, noh, noh->info.matricula, noh->proximo );
				indice++;
				noh = noh->proximo;
			}
		}
		printf ("__________________________________________________________________________________________________________________  \n");
	} else {
		puts ( "ERRO - Lista Invalida! \n");
	}
}