
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
tRaiz* criaLista ( )
{
	printf ("Criou a lista \n");
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
		tElemento *noh;		//noh vai armazenar cada elemento da lista(*referenciaRaiz) e referenciaRaiz vai percorrer a lista
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
		noh = *referenciaRaiz;
		if ( noh == NULL )	printf ("ERRO - Noh nao criado com Sucesso! \n");
			while ( noh->proximo != NULL ) {
				noh = noh->proximo;
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
void adicionaOrdenadoLista ( tRaiz* referenciaRaiz, taluno* rap )
{
	if ( referenciaRaiz != NULL ) {

		tElemento *noh, *novo;
		noh = ( tElemento* ) malloc ( sizeof ( tElemento ) );
		novo = ( tElemento* ) malloc ( sizeof ( tElemento ) );
		if ( noh == NULL || novo == NULL )	printf ("ERRO - Noh e novo nao criados com sucesso!\n");

		else {
			printf ("Elemento Adicionado ordenadamente com sucesso! \n");
			noh = *referenciaRaiz;

			int ajuda = -1;
			while ( noh != NULL ) {
				if ( noh->info.matricula < rap->matricula && noh->proximo->info.matricula > rap->matricula ) {
					novo->info.matricula = rap->matricula;
					novo->anterior = noh;
					novo->proximo = noh->proximo;
					noh->proximo->anterior = novo;
					noh->proximo = novo;
					ajuda = 1;
					break;
				}
				noh = noh->proximo;
			}
			if ( ajuda == -1 ) {
				novo->proximo = noh;
				novo->anterior = noh->anterior;
				noh->proximo = novo;
			}
		}
	} else {
		printf ("ERRO - Lista Invalida! \n");
	}
}

//Adiciona no final da Lista
void adicionaFinalLista ( tRaiz* referenciaRaiz, taluno* rap )
{
	if ( referenciaRaiz != NULL ){
		tElemento *noh,*novo;
		novo = ( tElemento* ) malloc ( sizeof (tElemento ) );
		novo->info.matricula = rap->matricula;

		noh = ( tElemento* ) malloc ( sizeof (tElemento ) );

		if ( novo == NULL || noh == NULL )	printf ("ERRO - Noh e novo nao criados com sucesso! \n");
		else {
			noh = *referenciaRaiz;

			//ListaVazia
			if ( noh == NULL ){
				novo->proximo = noh;
				novo->anterior = noh;
				*referenciaRaiz = novo;
			}else {
				while ( noh->proximo != NULL ){
					noh = noh->proximo;
				}
				novo->proximo = noh->proximo;
				novo->anterior = noh;
				noh->proximo = novo;
			}
			printf ("Elemento adicionado no final com sucesso! \n");
		}

	} else {
		printf ("ERRO - Lista Invalida! \n");
	}
}

//Adiciona no Inicio da Lista
void adicionaInicioLista ( tRaiz* referenciaRaiz, taluno* rap )
{
	if ( referenciaRaiz != NULL ) {
		tElemento *novo, *noh;
		novo = ( tElemento* ) malloc ( sizeof ( tElemento ) );
		noh = ( tElemento* ) malloc ( sizeof ( tElemento ) );

		if ( novo == NULL || noh == NULL ) 	printf ("ERRO - Novo ou noh nao criado com sucesso!");

		else {
			noh = *referenciaRaiz;

			novo->info.matricula = rap->matricula;
			novo->anterior = NULL;
			novo->proximo = noh;
			noh->anterior = novo;
			*referenciaRaiz = novo;

			printf ("Elemento adicionado no inicio com sucesso! \n");
		}
	} else {
		printf ("ERRO - Lista Invalida! \n");
	}
}

//Remover elemento por posicao
void removerPosicaoLista ( tRaiz* referenciaRaiz, int indice )
{
	if ( indice > tamanhoLista ( referenciaRaiz ) || indice < 0 )	printf ("ERRO - Indice Invalido! \n");
	else {
		if ( referenciaRaiz == NULL )	printf ("ERRO - Lista Invalida! \n");
		else {
			tElemento *noh, *sucessor;
			noh = ( tElemento* ) malloc ( sizeof ( tElemento ) );
			sucessor = ( tElemento* ) malloc ( sizeof ( tElemento ) );
			if ( noh == NULL || sucessor == NULL ) 	printf ("ERRO - Noh ou auxiliar invalido!\n");
			else {
				int i = 0;
				sucessor = *referenciaRaiz;
				noh = *referenciaRaiz;
				sucessor = sucessor->proximo;
				printf ("Elemento removido na posicao [ %d ] com sucesso! \n", indice);
				while ( noh->proximo != NULL ) {
					if ( i == indice ) {
						noh->anterior->proximo = sucessor;
						sucessor->anterior = noh->anterior;
					}
					noh = noh->proximo;
					sucessor = sucessor->proximo;
					i++;
				}

			}
		}
	}
}

//Remover elemento por conteudo [matricula]
void removerConteudoLista ( tRaiz* referenciaRaiz, taluno* rap )
{
	if ( referenciaRaiz == NULL )	printf ("ERRO - Lista Invalida! \n");
	else {
		if ( listaVazia ( referenciaRaiz ) != 0 )	printf ("ERRO - Lista Vazia! \n");
		else {
			tElemento *noh;
			noh = ( tElemento* ) malloc ( sizeof ( tElemento ) );
			if ( noh == NULL )	printf ("ERRO - Noh nao criado com sucesso! \n");
			else {
				int tem = -1;
				noh = *referenciaRaiz;
				while ( noh != NULL ) {
					if ( noh->info.matricula == rap->matricula ) {
						noh->anterior->proximo = noh->proximo;
						noh->proximo->anterior = noh->anterior;
						tem = 1;
						break;
					}
					noh = noh->proximo;
				}
				if ( tem == -1 )	printf ("ERRO - Elemento não consta na lista! \n");
				else {
					printf ("Elemento do conteudo [ %d ] removido com sucesso! \n",rap->matricula);
				}
			}
		}
	}
}

//Busca por indice
void buscaPosicaoLista ( tRaiz* referenciaRaiz, int indice )
{
	if ( referenciaRaiz == NULL ) printf ("ERRO - Lista Invalida! \n");
	else {
		if ( indice > tamanhoLista ( referenciaRaiz ) || indice < 0 )	puts ("ERRO - Indice Invalido, menor ou maior que tamanho da Lista!\n");
		else {
			tElemento *noh;
			noh = ( tElemento* ) malloc ( sizeof ( tElemento ) );
			if ( noh == NULL )	puts ("ERRO - Noh nao criado com sucesso! \n");
			else {
				int i = 0;
				noh = *referenciaRaiz;
				while ( noh != NULL ){
					if ( i == indice ) {
						printf ("Indice: [ %d ]  \tConteudo (Matricula): [ %d ] \n", indice, noh->info.matricula );
						break;
					}
					i++;
					noh = noh->proximo;
				}
			}
		}
	}
}

//Busca por Conteudo [matricula]
void buscaConteudoLista ( tRaiz* referenciaRaiz, taluno* rap )
{
	if ( referenciaRaiz == NULL )	printf ("ERRO - Lista Invalida! \n");
	else {
		tElemento *noh;
		if ( listaVazia ( referenciaRaiz ) == 1 )	printf ("ERRO - Lista Vazia! \n");
		else {
			noh = ( tElemento* ) malloc ( sizeof( tElemento ) );
			if ( noh == NULL ) 	puts ("ERRO - Noh nao criado com Sucesso! \n");
			else {
				noh = *referenciaRaiz;
				int tem = -1, indice = 0;
				while ( noh != NULL ) {
					if ( noh->info.matricula == rap->matricula ) {
						tem = 1;
						printf ("Indice: [ %d ]  \tConteudo (Matricula): [ %d ] \n", indice, noh->info.matricula );
						break;
					}
					noh = noh->proximo;
					indice++;
				}
				if ( tem == -1 )	puts ("ERRO - Elemento nao consta na Lista! \n");
			}
		}
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
				printf (" Indice: [ %d ]   \tEndereco: [ %p ] \tConteudo (Matricula): [ %d ] \tAponta: [ %p ] \n", indice, noh, noh->info.matricula, noh->proximo );
				indice++;
				noh = noh->proximo;
			}
		}
		printf ("_____________________________________________________________________________________________________________________________ \n");
	} else {
		puts ( "ERRO - Lista Invalida! \n");
	}
}
