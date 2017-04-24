/*
1-	Inicia-se uma lista encadeada com um ponteiro da lista apontando pra um elemento com conteudo nulo.
2-	Quando um ponteiro de um elemento aponta para nulo, quer dizer que esse elemento é o ultimo.

Notação: tRaiz = ponteiro do ponteiro tElementoDaListaEncadeada; tRaiz vai armazenar o endereço do endereço do primeiro elemento  
*tRaiz = conteudo do ponteiro tRaiz que vai ser o endereço do primeiro elemento
‘->’ = '(*variavel).'
*/


//Para fazer algo simples e demonstrativo irei deixar a estrutura aluno apenas com matricula
typedef struct tAluno{
	int matricula;
	//char nome[50];
	//int idade;
	//float nota1, nota2, nota3, media;
}taluno;

typedef struct tElementoDaListaEncadeada{
	tElementoDaListaEncadeada *proximo;	//é um ponteiro para o mesmo tipo de variavel
	taluno info; 	//(*taluno).info.matricula
}tElementoDaListaEncadeada;
typedef struct tElementoDaListaEncadeada *tRaiz;	//primeiro elemento, raiz é um ponteiro de ponteiro (**) defini outra variavel, a tRaiz para faciliar compilação

//Cria a lista Encadeada
tRaiz* criaLista(){
	tRaiz *listaEncadeada;
	listaEncadeada = (tRaiz*)malloc(sizeof(tRaiz));
	if(listaEncadeada != NULL){
		*listaEncadeada = NULL;		//Tenho que devolver o primeiro ponteiro com conteudo que aponte pra Nulo;
	}	
	return listaEncadeada;
}

//Libera o espaço utilizado pela lista 
void liberaListaEncadeada(tRaiz* referenciaRaiz){
	if(referenciaRaiz != NULL){								//Se o ponteiro estiver apontando pra algum endereço existente
		tElementoDaListaEncadeada *noh;						//noh é auxiliar, note que é de outro tipo(tElementoDaListaEncadeada) então possui campo proximo(tElementoDaListaEncadeada) e matricula(tAluno)
		while( *referenciaRaiz != NULL){					//Enquanto o conteudo do ponteiro da raiz não for nulo
			noh = *referenciaRaiz;
			*referenciaRaiz = (*referenciaRaiz)->proximo;	//Aqui não tem problema eu usar a referencia pra percorrer a lista pois estarei eliminando toda a lista.
			free(noh);
		}
		free(referenciaRaiz);
	}
}

//Adiciona elemento novo no final da lista encadeada
void adicionaElementoFinal(tRaiz* referenciaRaiz, taluno* rap){
	//Caso não tenha endereco apontando para o primeiro ponteiro
	if( referenciaRaiz == NULL ){
		puts("ERRO - Raiz Invalida! \n");
	}else{
		tElementoDaListaEncadeada *noh;
		noh = (tElementoDaListaEncadeada*)malloc(sizeof(tElementoDaListaEncadeada));

		//Verifica se um novo elemento(noh) foi criado
		if( noh == NULL){
			puts("ERRO - Lista Invalida! \n");
		}else{
			noh->info = rap->matricula;
			noh->proximo = NULL;

			//Verifica se o inicio é vazio
			if( *referenciaRaiz == NULL ){
				*referenciaRaiz = noh;		//caso seja, vai apontar pro primeiro elemento(que eu criei: noh)
			}else{

				//caso ja exista ponteiro apontando para elementos:
				tElementoDaListaEncadeada *aux;
				aux = *referenciaRaiz;	// aponta para o primeiro elemento

				while( aux->proximo != NULL ){
					aux = aux->proximo;	//
				}
				aux->proximo = noh;	
			}

		}
	}
}

//Adiciono um elemento novo no inicio
void adicionaElementoInicio(tRaiz* referenciaRaiz, taluno* rap){
	//Caso não tenha ponteiro apontando para o primeiro ponteiro
	if( referenciaRaiz == NULL){
		puts("ERRO - Raiz Invalida! \n");
	}
	tElementoDaListaEncadeada *noh;
	noh = (tElementoDaListaEncadeada*)malloc(sizeof(tElementoDaListaEncadeada)); 	//Cria noh novo
	
	//Verifica se um novo elemento(noh) foi criado
	if( noh = NULL){
		puts("ERRO - Noh Invalido! \n");
	}

	//Funciona tanto para como o primeiro elemento a ser criado, como para caso ja exista elemento nessa lista
	noh->info = rap->matricula;
	noh->proximo = *referenciaRaiz;				//nó novo aponta pro endereço que apontava pro primeiro(que agora sera o segundo)
	*referenciaElementoDaListaEncadeada = noh;	//endereço do inicio aponta pro novo primeiro noh	
}

//adiciono um elemento novo em qualquer lugar
void adicionaElementoPosicao(tRaiz* referenciaRaiz, taluno* rap ,int posicao){
	if( tamanhoListaEncadeada(referenciaRaiz) > posicao || tamanhoListaEncadeada(referenciaRaiz) < 0 ){
		puts("ERRO - Não existe essa posicao!\n");
	}
	if( referenciaRaiz == NULL ){
		puts("ERRO - Raiz Invaldia!\n");
	}
	int i = 0;
	tElementoDaListaEncadeada *noh;					//para percorrer a lista
	noh = *referenciaRaiz;
	noh->info = rap->matricula;
	tElementoDaListaEncadeada *aux;					//saber qual elemento vai apontar para o noh inserido
	aux = *referenciaRaiz;								
	while( i != posicao){							//faço ele percorrer a lista até encontrar posicao [final i = posicao]
		noh = noh->proximo;							//noh recebe o primeiro elemento da lista encadeada posicao[quando i = 0]
		if( posicao - i > 0){						//quando (i == posicao) = 0 pararei de passar para o proximo
			aux = aux->proximo;						//[final] elemento vai ser o antecessor ao noh	
		}
		i++;
	}
	aux->proximo = noh;
	noh = noh->proximo;
}

//Remove elemento por indice
void removeElementoPorIndice(tRaiz* referenciaRaiz, int indice){
	if( listaEncadeadaVazia(referenciaRaiz)	== 0 ){			//verifica se a lista for vazia! se for F não é vazia
		if(indice > tamanhoListaEncadeada(referenciaRaiz) || indice < 0){
			puts("ERRO - Não existe esse elemento nessa Lista Encadeada! \n");
		}else{
			if(referenciaRaiz == NULL || *referenciaRaiz == NULL){
				puts("ERRO - Raiz Invalida! \n");
			}else{
				tElementoDaListaEncadeada *noh;
				noh = *referenciaRaiz;				
				int i = 0;
				tElementoDaListaEncadeada *aux;
				aux = *referenciaElementoDaListaEncadeada;
				while( indice != i ){
					noh = noh->proximo;					
					if( i == indice-1){
						aux = aux->proximo; 				//final aux = i-1 e noh = i -> aux é anterior a noh
					}
					i++;	
				}
				aux->proximo = noh->proximo;				//o campo do endereço proximo de aux vai ser o que era o proximo de noh
				liberaListaEncadeada(noh);	
			}	
		}
	}
}

//Remove elemento por conteudo
void removeElementoPorConteudo(tRaiz referenciaRaiz, taluno rap){
	if( !listaEncadeadaVazia(referenciaRaiz) ){
		tElementoDaListaEncadeada *noh;
		int tem = -1;
		tElementoDaListaEncadeada *aux;
		noh = *referenciaElementoDaListaEncadeada;
		aux = *referenciaElementoDaListaEncadeada;
		if( referenciaRaiz == NULL || *referenciaRaiz == NULL ){
			puts("ERRO - Raiz Invalida! \n");
		}else{
			while( noh->proximo == NULL ){
				noh = noh->proximo;
				if( noh->info == rap->matricula ){
					tem = 1;
					aux = noh->proximo;	//aux vai ser antecessor a noh , pois só será apontado para o proximo 
				}
				if(tem != 1){
					aux = aux->proximo;
				}
			}
			if(tem == -1){
					puts("ERRO - Não possui um elemento com essa matricula na Lista!	\n");
			}

		}
	}else{
		puts("ERRO - Lista Vazia! \n");
	}
}


//Busca elemento por Indice
void buscaPorElemento(tRaiz* referenciaRaiz, int indice){
	if(indice < 0 || indice > tamanhoListaEncadeada(referenciaElementoDaListaEncadeada)){
		puts("ERRO - Lista nao possui esse elemento! \n");
	}else{
		tElementoDaListaEncadeada *noh;
		noh = *referenciaRaiz;
		if( referenciaRaiz == NULL || *referenciaRaiz == NULL){
			puts("ERRO - Algum Elemento Invalido! \n");
		}else{
			int i = 0;
			while( i != indice ){
				noh = (*noh)->proximo;
				i++;
			}
			noh = (*noh)->proximo;
			printf("	[%d] - [ %d ]  \n",i, (*noh)->info);
		}
	}
}

//Busca elemento por Conteudo (nesse caso um inteiro de matricula)
void buscaPorConteudo(tRaiz* referenciaRaiz, int matriculaV){
	int i = 0;
	int existe = -1;
	tElementoDaListaEncadeada *noh;
	noh = *referenciaRaiz
	if( referenciaRaiz == NULL || *referenciaRaiz == NULL ){
		puts("ERRO - Raiz Invalida!! \n");
	}else{
		while( (*noh)->proximo != NULL ){	
			if( (*noh)->info == matriculaV ){
				printf(" [%d] - [ %d ] \n", i, (*noh)->info);
				existe = 1;
			}
			i++;
		}
		if( existe == -1 ){
			puts("ERRO - Não existe elemento com esse conteudo! \n");
		}
	}

}

//Tamanho da list
int tamanhoListaEncadeada(tRaiz* referenciaRaiz){
	if( referenciaRaiz == NULL){	//Verifica se Raiz aponta pra algum endereço com conteudo(não nulo)
		return 0;
	}
	int contador = 0;
	tElementoDaListaEncadeada *noh;
	noh = *referenciaRaiz;		//noh vai receber o endereço do primeiro elemento, que é o conteudo do ponteiro raiz
	while( noh != NULL ){
		contador++;
		noh = (*noh)->proximo;	//foi utilizado (*noh)->proximo, pois noh recebe o endereço do conteudo da variavel "proximo" (do proximo elemento)
	}
	return contador;
}

//Lista cheia não faz sentido ter em listas dinamicas porque o limite é a própria memória


//Lista Vazia
int listaEncadeadaVazia(tRaiz* referenciaRaiz){
	if(referenciaRaiz == NULL){		//se o endereço de Raiz não esta apontando pra nenhum outro endereço lista está vazia(true)
		return 1;
	}
	if( *referenciaRaiz == NULL){
		return 1;					//se o conteudo não esta apontando pra nenhum endereço lista está vazia(true)
	}
	return 0;
}


//Printa a Lista
void printaListaEncadeada(tRaiz* referenciaRaiz){
	int indice = 0;
	tElementoDaListaEncadeada *noh;
	noh = *referenciaRaiz;
	while( (*noh)->proximo != NULL){
		printf("Indice:	[%d] Ponteiro: [ %p ] --> [ %d ] (Conteudo)  \n",indice, noh, (*noh)->info );
		indice++;
	}

	printf("_____________________________________________________________________________________________________");

}
