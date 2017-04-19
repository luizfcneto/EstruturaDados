/*
1-	Inicia-se uma lista encadeada com um ponteiro da lista apontando pra um elemento com conteudo nulo.
2-	Quando um ponteiro de um elemento aponta para nulo, quer dizer que esse elemento é o ultimo.

Notação: relep = ponteiro de um ponteiro <=> (*relep) Inicio do elemento <=> (*relep).proximo => segundo elemento(que é um ponteiro)
*/

//Para fazer algo simples e demonstrativo irei deixar a estrutura aluno apenas com matricula
typedef struct tAluno{
	int matricula;
	//char nome[50];
	//int idade;
	//float nota1, nota2, nota3, media;
}taluno;

typedef struct tElementoDaListaEncadeada{
	tElementoDaListaEncadeada proximo*;	//é um ponteiro para o mesmo tipo de variavel
	taluno info; 	//(*taluno).info.matricula
}*tElementoDaListaEncadeada;

//Cria a lista Encadeada
tElementoDaListaEncadeada* criaLista(tElementoDaListaEncadeada* referenciaElementoDaListaEncadeada){
	tElementoDaListaEncadeada listaEncadeada;
	listaEncadeada = (tElementoDaListaEncadeada*)malloc(sizeof(tElelementoDaListaEncadeada));
	if(listaEncadeada != NULL){
		listaEncadeada* = NULL;	//*Tenho que devolver o primeiro ponteiro com conteudo de onde aponta pra Nulo;
	}

	return listaEncadeada;
}

//Libera o espaço utilizado pela lista
void liberaListaEncadeada(tElelementoDaListaEncadeada* referenciaElementoDaListaEncadeada){
	if(referenciaElementoDaListaEncadeada != NULL){	//Se o ponteiro estiver apontando pra alguem
		tElementoDaListaEncadeada noh*;		//noh é auxiliar
		while( (*referenciaElementoDaListaEncadeada) != NULL){	//Enquanto eu tenho conteudo na lista
			noh = (*referenciaElementoDaListaEncadeada);
			(*referenciaElementoDaListaEncadeada) = (*referenciaElementoDaListaEncadeada).proximo;
			free(noh);
		}
		free(referenciaElementoDaListaEncadeada);
	}
}

//Adiciona elemento novo no final da lista encadeada
void adicionaElementoFinal(tElementoDaListaEncadeada* referenciaElementoDalistaEncadeada, taluno* rap){
	//Caso não tenha ponteiro apontando para o primeiro ponteiro
	if( referenciaElementoDaListaEncadeada == NULL ){
		puts("ERRO - Lista Invalida! \n");
	}
	tElementoDaListaEncadeada noh* = (tElementoDaListaEncadeada*)malloc(sizeof(tElementoDaListaEncadeada));	//crio um ponteiro para um novo elemento

	//Verifica se um novo elemento(noh) foi criado
	if( noh == NULL){
		puts("ERRO - Lista Invalida! \n");
	}
	(*noh).info = (*rap).matricula;
	(*noh).proximo = NULL;

	//Verifica se o inicio é vazio
	if( (*referenciaElementoDaListaEncadeada) == NULL ){
		(*referenciaElementoDaListaEncadeada) = noh;		//caso seja, vai apontar pro primeiro elemento(que eu adicionei)
	}

	//caso ja exista ponteiro apontando para elementos:
	tElementoDaListaEncadeada aux* = (tElementoDaListaEncadeada*)malloc(sizeof(tElementoDaListaEncadeada));	//crio um outro ponteiro de elemento para me auxiliar
	aux = (*referenciaElementoDaListaEncadeada);	// aponta para o primeiro elemento

	while( (*aux).proximo != NULL ){
		aux = (*aux).proximo;	//
	}
	(*aux).proximo = noh;
}

//Adiciono um elemento novo no inicio
void adicionaElementoInicio(tElementoDaListaEncadeada* referenciaElementoDaListaEncadeada, taluno* rap){
	//Caso não tenha ponteiro apontando para o primeiro ponteiro
	if( referenciaElementoDaListaEncadeada == NULL){
		puts("ERRO - Lista Invalida! \n");
	}
	tElementoDaListaEncadeada noh*;
	noh = (tElementoDaListaEncadeada*)malloc(sizeof(tElementoDaListaEncadeada)); 	//Cria nó novo

	//Verifica se um novo elemento(noh) foi criado
	if( noh = NULL){
		puts("ERRO - Lista Invalida! \n");
	}
	//Funciona tanto para como o primeiro elemento a ser criado, como para caso ja exista elemento nessa lista
	(*noh).info = (*rap).matricula;
	(*noh).proximo = (*referenciaElementoDaListaEncadeada);	//nó novo aponta pro endereço que apontava pro primeiro(que agora sera o segundo)
	(*referenciaElementoDaListaEncadeada) = noh;	//endereço do inicio aponta pro novo primeiro noh
}

//adiciono um elemento novo em qualquer lugar
		if(tamanhoListaEncadeada(referenciaElementoDaListaEncadeada) > posicao || tamanhoListaEncadeada(referenciaElementoDaListaEncadeada) < 0 )
		void adicionaElementoPosicao(tElementoDaListaEncadeada* referenciaElementoDaListaEncadeada, taluno rap ,int posicao){
		if(referenciaElementoDaListaEncadeada != NULL){
			puts("ERRO - Lista Invaldia!\n");
		}
		int i = 0;
		tElementoDaListaEncadeada *noh;
		noh = referenciaElementoDaListaEncadeada;
		while( (*noh) != NULL ){
				i++;
				if( i != posicao )
				if( i == posicao){
							(*noh).info = (*rap).matricula;
							(*noh).proximo =
				}
		}
}

//Remove elemento novo
void removeElemento(tle* rlep, int elemento){


}

//Busca elemento
void buscaElemento(tle* rlep, int elemento){


}


//Tamanho da lista
int tamanhoListaEncadeada(tElementoDaListaEncadeada* referenciaElementoDaListaEncadeada){
	if( referenciaElementoDaListaEncadeada == NULL){	//Verifica se a Lista é valida!
		return 0;
	}
	int contador = 0;
	tElementoDaListaEncadeada noh*;
	noh = *referenciaElementoDaListaEncadeada;	//Que conteudo de relep? proximo ou info? R: o conteudo desse ponteiro é um outro ponteiro.
	while( noh != NULL ){
		contador++;
		noh = (*noh).proximo;
	}
	return contador;
}

//Lista cheia não faz sentido ter em listas dinamicas porque o limite é a própria memória


//Lista Vazia
int listaEncadeadaVazia(tElementoDaListaEncadeada* referenciaElementoDaListaEncadeada){
	if(referenciaElementoDaListaEncadeada == NULL){	//se o ponteiro não esta apontando pra nenhum outro endereço lista está vazia(true)
		return 1;
	}
	if((*referenciaElementoDaListaEncadeada) == NULL){
		return 1;		//se o ponteiro não esta apontando pra nenhum conteudo lista está vazia(true)
	}
	return 0;
}


//Printa a Lista
void printaListaEncadeada(tElementoDaListaEncadeada* referenciaElementoDaListaEncadeada){

}
