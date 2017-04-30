/*
Descrição: Implementação e declaração das funcoes implementadas em lista2.c (lista encadeada)
1-	Inicia-se uma lista encadeada com um ponteiro da lista apontando pra um elemento com conteudo nulo.
2-	Quando um ponteiro de um elemento aponta para nulo, quer dizer que esse elemento é o ultimo.

Notação: tRaiz = ponteiro do ponteiro tElementoDaListaEncadeada; tRaiz vai armazenar o endereço do endereço do primeiro elemento  
*tRaiz = conteudo do ponteiro tRaiz que vai ser o endereço do primeiro elemento
‘->’ = '(*variavel).'
*/


//Para fazer algo simples e demonstrativo irei deixar a estrutura aluno apenas com matricula
typedef struct tAluno 
{
	int matricula;
	//char nome[50];
	//int idade;
	//float nota1, nota2, nota3, media;
} taluno;



struct _tElementoDaListaEncadeada 
{
	struct _tElementoDaListaEncadeada *proximo;	//é um ponteiro para o mesmo tipo de variavel
	taluno info; 	//(*taluno).info.matricula
};

typedef struct _tElementoDaListaEncadeada *tRaiz;	//primeiro elemento, raiz é um ponteiro de ponteiro (**) defini outra variavel, a tRaiz para faciliar compilação
typedef struct _tElementoDaListaEncadeada tElementoDaListaEncadeada;

/*
//Outra Forma de implementar lista encadeada:
typedef struct _tElementoDaListaEncadeada
{
	struct _tElementoDaListaEncadeada *proximo;
	taluno info;
} tRaiz;

*/

//Cria a lista Encadeada
tRaiz* criaLista () 
{
	tRaiz *listaEncadeada;
	listaEncadeada = ( tRaiz* ) malloc ( sizeof( tRaiz ) );
	if ( listaEncadeada != NULL ) *listaEncadeada = NULL;		//Tenho que devolver o primeiro ponteiro com conteudo que aponte pra Nulo;
	return listaEncadeada;
}

//Libera o espaço utilizado pela lista 
void liberaListaEncadeada ( tRaiz* referenciaRaiz )
{
	if ( referenciaRaiz != NULL )	{				//Se o ponteiro estiver apontando pra algum endereço existente
		tElementoDaListaEncadeada *noh;				//noh é auxiliar, note que é de outro tipo(tElementoDaListaEncadeada) então possui campo proximo(tElementoDaListaEncadeada) e matricula(tAluno)
		noh = ( tElementoDaListaEncadeada* ) malloc ( sizeof ( tElementoDaListaEncadeada ) );
		while ( *referenciaRaiz != NULL )	{		//Enquanto o conteudo do ponteiro da raiz não for nulo					
			noh = *referenciaRaiz;
			*referenciaRaiz = (*referenciaRaiz)->proximo;			//Aqui não tem problema eu usar a referencia pra percorrer a lista pois estarei eliminando toda a lista.
			free ( noh );
		}
		free ( referenciaRaiz );
	}
}

//Tamanho da list
int tamanhoListaEncadeada	( tRaiz* referenciaRaiz )
{
	if ( referenciaRaiz == NULL)	return 0;		//Verifica se Raiz aponta pra algum endereço com conteudo(não nulo)
	
	int contador = 0;
	tElementoDaListaEncadeada *noh;
	noh = ( tElementoDaListaEncadeada* ) malloc ( sizeof ( tElementoDaListaEncadeada ) );
	noh = *referenciaRaiz;		//noh vai receber o endereço do primeiro elemento, que é o conteudo do ponteiro raiz
	
	while	( noh != NULL ){
		contador++;
		noh = noh->proximo;	//foi utilizado (*noh)->proximo, pois noh recebe o endereço do conteudo da variavel "proximo" (do proximo elemento)
	}
	return contador;
}

//Lista cheia não faz sentido ter em listas dinamicas porque o limite é a própria memória

//Lista Vazia
int listaEncadeadaVazia	( tRaiz* referenciaRaiz )	
{
	if ( referenciaRaiz == NULL )	return 1;		//se o endereço de Raiz não esta apontando pra nenhum outro endereço lista está vazia(true)
	
	if ( *referenciaRaiz == NULL )	return 1;		//se o conteudo não esta apontando pra nenhum endereço lista está vazia(true)
	
	return 0;
}

//Adiciona elemento novo no final da lista encadeada
void adicionaElementoFinal ( tRaiz* referenciaRaiz, taluno* rap )
{
	//Caso não tenha endereco apontando para o primeiro ponteiro
	if ( referenciaRaiz == NULL )	puts ( "ERRO - Raiz Invalida! \n" );
	else {
		tElementoDaListaEncadeada *noh;
		noh = ( tElementoDaListaEncadeada* ) malloc ( sizeof ( tElementoDaListaEncadeada ) );

		//Verifica se um novo elemento(noh) foi criado
		if ( noh == NULL )	puts ( "ERRO - Lista Invalida! \n" );
		else {
			noh->info.matricula = rap->matricula;
			noh->proximo = NULL;

			//Verifica se o inicio é vazio
			if ( *referenciaRaiz == NULL )	*referenciaRaiz = noh;		//caso seja, vai apontar pro primeiro elemento(que eu criei: noh)
			else {

				//caso ja exista ponteiro apontando para elementos:
				tElementoDaListaEncadeada *aux;
				aux = ( tElementoDaListaEncadeada* ) malloc ( sizeof ( tElementoDaListaEncadeada ) );
				aux = *referenciaRaiz;	// aponta para o primeiro elemento
				while ( aux->proximo != NULL )	aux = aux->proximo;	

				aux->proximo = noh;	
			}

		}
	}
}

//Adiciono um elemento novo no inicio
void adicionaElementoInicio ( tRaiz* referenciaRaiz, taluno* rap )
{
	//Caso não tenha ponteiro apontando para o primeiro ponteiro
	if ( referenciaRaiz == NULL )	puts ( "ERRO - Raiz Invalida! \n" );
	tElementoDaListaEncadeada *noh;
	noh = ( tElementoDaListaEncadeada* ) malloc ( sizeof ( tElementoDaListaEncadeada ) ); 	//Cria noh novo
	
	//Verifica se um novo elemento(noh) foi criado
	if ( noh == NULL ) puts ( "ERRO - Noh Invalido! \n" );

	//Funciona tanto para como o primeiro elemento a ser criado, como para caso ja exista elemento nessa lista
	noh->info.matricula = rap->matricula;
	noh->proximo = *referenciaRaiz;				//nó novo aponta pro endereço que apontava pro primeiro(que agora sera o segundo)
	*referenciaRaiz = noh;		//endereço do inicio aponta pro novo primeiro noh	
}

//adiciono um elemento novo em qualquer lugar *dando errado... corrigir!
void adicionaElementoPosicaoOrdenada ( tRaiz* referenciaRaiz, taluno* rap )
{
	if ( referenciaRaiz == NULL )	puts ( "ERRO - Raiz Invaldia!\n" );
	else{
		tElementoDaListaEncadeada *noh;			//para percorrer a lista
		noh = ( tElementoDaListaEncadeada* ) malloc ( sizeof ( tElementoDaListaEncadeada ) );
		if ( noh == NULL )	puts ( "ERRO - Noh Invalido! \n" );
		else {
			tElementoDaListaEncadeada *aux, *novo;		//aux (saber em que posicao elemento novo sera inserido)
			aux = ( tElementoDaListaEncadeada* ) malloc ( sizeof ( tElementoDaListaEncadeada ) );
			novo = ( tElementoDaListaEncadeada* ) malloc ( sizeof ( tElementoDaListaEncadeada ) );

			if ( aux == NULL || novo == NULL )	puts ( "ERRO - aux ou novo invalidos! \n" );
			else {
				printf ("\n Adicionando elemento ordenado: %d \n",rap->matricula);
				novo->info.matricula = rap->matricula;
				//lista Vazia
				if ( *referenciaRaiz == NULL ) 	{		
					novo->proximo = *referenciaRaiz;
					*referenciaRaiz = novo;
				
				}else {
					aux = *referenciaRaiz;					
					aux = aux->proximo;
					noh = *referenciaRaiz;
					//verifica se a matricula de aluno é menor que o que possui no primeiro elemento [deve ser o primeiro elemento]
					if ( rap->matricula <= aux->info.matricula )	{		
						novo->proximo = aux;			
						noh = novo;
					}else {
						//aux posicao [i+1] noh posicao[i] novo = conteudo adicionaremos
						int ajuda = 0;
						//percorre a lista ate encontrar um conteudo maior, senao encontrar vai percorrer ate o ultimo elemento
						while ( noh != NULL ) {			
							
							//adiciona o elemento na lista, quando o rap.matricula é maior que noh->info.matricula, mas menor que aux->info.matricula 
							if ( novo->info.matricula > noh->info.matricula && novo->info.matricula < aux->info.matricula )	{		
								noh->proximo = novo;	
								novo->proximo = aux;
								break;
							}
							aux = aux->proximo;
							noh = noh->proximo;

							if ( aux == NULL )	ajuda = 1;
						}
						//caso noh percorra toda a lista e nao tenha ninguem menor que a matricula que deseja adicionar
						if ( ajuda )	{
							noh->proximo = novo;
							novo->proximo = NULL;
						}
					}
				} 								
			}
		}
	}
}

//Remove elemento por Indice 		*REFAZER
void removeElementoPorIndice ( tRaiz* referenciaRaiz, int indice )
{	
	if ( listaEncadeadaVazia ( referenciaRaiz ) == 0 )	{			//verifica se a lista for vazia! se for F não é vazia
		if ( indice > tamanhoListaEncadeada ( referenciaRaiz ) || indice < 0 )	puts ( "ERRO - Não existe esse elemento nessa Lista Encadeada! \n" );
		else {
			if ( referenciaRaiz == NULL || *referenciaRaiz == NULL )	puts ( "ERRO - Raiz Invalida! \n" );
			else {
				printf ("\nRemovido o elemento %d com sucesso!\n",indice);	
				tElementoDaListaEncadeada *noh;
				noh = ( tElementoDaListaEncadeada* ) malloc ( sizeof ( tElementoDaListaEncadeada ) ); 
				noh = *referenciaRaiz;				
				int i = 0;
				tElementoDaListaEncadeada *aux;
				aux = ( tElementoDaListaEncadeada* ) malloc ( sizeof ( tElementoDaListaEncadeada ) );
				aux = *referenciaRaiz;
				aux = aux->proximo;
				while ( indice < i )	{
					noh = noh->proximo;	
					aux = aux->proximo;				
					i++;	
				}
				noh->proximo = aux->proximo;				//o campo do endereço proximo de aux vai ser o proximo de noh
				//free ( aux );			//-> estava apagando a lista toda!
			}	
		}
	}
}

//Remove elemento por conteudo 		*REFAZER
void removeElementoPorConteudo	( tRaiz* referenciaRaiz, taluno* rap )
{
	if ( listaEncadeadaVazia ( referenciaRaiz ) != 1 )	{	//verifica se a lista é vazia, se for retornará 1
		tElementoDaListaEncadeada *noh;
		noh = ( tElementoDaListaEncadeada* ) malloc ( sizeof ( tElementoDaListaEncadeada ) );
		int tem = -1;
		tElementoDaListaEncadeada *aux;
		aux = ( tElementoDaListaEncadeada* ) malloc ( sizeof ( tElementoDaListaEncadeada ) );
		noh = *referenciaRaiz;
		aux = *referenciaRaiz;
		aux = aux->proximo;
		if ( referenciaRaiz == NULL || *referenciaRaiz == NULL )	puts ( "ERRO - Raiz Invalida! \n" );
		else {
			while ( rap->matricula != noh->info.matricula || noh != NULL) {
				if ( rap->matricula == aux->info.matricula ){
					tem = 1;					
					break;
				}
				aux = aux->proximo;
				noh = noh->proximo;
			}
			if ( tem == -1 )	puts ( "ERRO - Não possui um elemento com essa matricula na Lista!	\n" );
			else {
				noh->proximo = aux->proximo;
				free( aux );		// vai apagar a lista toda;
				printf ("\nRemovido o conteudo %d com sucesso!\n",rap->matricula);
			}
		}
	}else puts ( "ERRO - Lista Vazia! \n" );
}


//Busca elemento por Indice
void buscaPorIndice	( tRaiz* referenciaRaiz, int indice ) 
{
	if ( indice < 0 || indice > tamanhoListaEncadeada ( referenciaRaiz ) ) 	puts ( "ERRO - Lista nao possui esse elemento! \n" );
	else {
		tElementoDaListaEncadeada *noh;
		noh = ( tElementoDaListaEncadeada* ) malloc ( sizeof ( tElementoDaListaEncadeada ) );
		noh = *referenciaRaiz;
		if ( referenciaRaiz == NULL || *referenciaRaiz == 
			NULL )	puts ( "ERRO - Algum Elemento Invalido! \n" );
		else {
			int i = 1;
			while	( i != indice )	{
				noh = noh->proximo;
				i++;
			}
			noh = noh->proximo;
			printf ( "BUSCA: Indice: [ %d ] - Conteudo: [ %d ]  \n", i, noh->info.matricula );
		}
	}
}

//Busca elemento por Conteudo (nesse caso um inteiro de matricula)
void buscaPorConteudo ( tRaiz* referenciaRaiz, taluno* rap  )
{
	int i = 0;
	int existe = -1;
	tElementoDaListaEncadeada *noh;
	noh = ( tElementoDaListaEncadeada* ) malloc ( sizeof ( tElementoDaListaEncadeada ) );
	noh = *referenciaRaiz;
	if ( referenciaRaiz == NULL || *referenciaRaiz == NULL )	puts ( "ERRO - Raiz Invalida!! \n" );
	else {
		while	( noh != NULL )	{	
			if ( noh->info.matricula == rap->matricula )	{
				printf ( "BUSCA: Indice: [ %d ] - Conteudo: [ %d ] \n", i, noh->info.matricula );
				existe = 1;
			}
			i++;
			noh = noh->proximo;
		}
		if ( existe == -1 )	{
			puts ( "ERRO - Não existe elemento com esse conteudo! \n" );
		}
	}

}

//Printa a Lista
void printaListaEncadeada	( tRaiz* referenciaRaiz )
{
	int indice = 0;
	tElementoDaListaEncadeada *noh;
	noh = ( tElementoDaListaEncadeada* ) malloc ( sizeof ( tElementoDaListaEncadeada ) );
	noh = *referenciaRaiz;
	while	( noh != NULL ){
		printf ( " Indice: [%d] \tEndereco: [ %p ] - Conteudo ( Matricula ): [ %d ] --> Aponta [ %p ] \n", indice, noh, noh->info.matricula, noh->proximo );
		indice++;
		noh = noh->proximo;
	}

	printf ("_____________________________________________________________________________________________________ \n" );

}
