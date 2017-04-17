/*
1-	Inicia-se uma lista encadeada com um ponteiro da lista apontando pra um elemento com conteudo nulo.	
2-	Quando um ponteiro de um elemento aponta para nulo, quer dizer que esse elemento é o ultimo.
		

*/

//Para fazer algo simples e demonstrativo irei deixar a estrutura aluno apenas com matricula
typedef struct tAluno{
	int matricula;
	//char nome[50];
	//int idade;
	//float nota1, nota2, nota3, media;
}taluno;

typedef struct tElementoListaEncadeada{
	tlelemento proximo*;	//é um ponteiro para o mesmo tipo de variavel
	taluno info; 	//(*taluno).info.matricula
}telemento;

//Cria a lista Encadeada
telemento* criaLista(telemento* relep){
	telemento listaEncadeada;
	listaEncadeada = (telemento*)malloc(sizeof(relep));
	if(listaEncadeada != NULL){
		listaEncadeada* = NULL;	//*Tenho que devolver o primeiro ponteiro com conteudo de onde aponta pra Nulo;
	}
	
	return listaEncadeada;
}

//Libera o espaço utilizado pela lista
void liberaListaEncadeada(telemento* relep){
	if(relep != NULL){	//Se o ponteiro estiver apontando pra alguem
		telemento noh*;		//noh é auxiliar
		while( (*relep) != NULL){	//Enquanto eu tenho conteudo na lista
			noh = (*relep);
			(*relep) = (*relep).proximo;
			free(noh);
		}
		free(rlep);
	}	
}

//Adiciona elemento novo no final da lista encadeada
void adicionaElementoFinal(telemento* relep, taluno* rap){
	//Caso não tenha ponteiro apontando para o primeiro ponteiro
	if( relep == NULL ){
		puts("ERRO - Lista Invalida! \n");
	}
	telemento noh* = (telemento*)malloc(sizeof(telemento));	//crio um ponteiro para um novo elemento

	//Verifica se um novo elemento(noh) foi criado
	if( noh == NULL){
		puts("ERRO - Lista Invalida! \n");
	}
	(*noh).info = (*rap).matricula;
	(*noh).proximo = NULL;
	
	//Verifica se o inicio é vazio
	if( (*relep) == NULL ){
		(*relep) = noh;		//caso seja, vai apontar pro primeiro elemento(que eu adicionei)
	}

	//caso ja exista ponteiro apontando para elementos:
	telemento aux* = (telemento*)malloc(sizeof(telemento));	//crio um outro ponteiro de elemento para me auxiliar
	aux = (*relep);	// aponta para o primeiro elemento
	while(	(*aux).proximo != NULL	){
		aux = (*aux).proximo;
	}
	(*aux).proximo = noh;
}

//Adiciono um elemento novo no inicio
void adicionaElementoInicio(telemento* relep, taluno* rap){
	//Caso não tenha ponteiro apontando para o primeiro ponteiro
	if( relep == NULL){
		puts("ERRO - Lista Invalida! \n");
	}
	telemento noh*;
	noh = (telemento*)malloc(sizeof(telemento)); 	//Cria nó novo
	
	//Verifica se um novo elemento(noh) foi criado
	if( noh = NULL){
		puts("ERRO - Lista Invalida! \n");
	}
	//Funciona tanto para como o primeiro elemento a ser criado, como para caso ja exista elemento nessa lista
	(*noh).info = (*rap).matricula;
	(*noh).proximo = (*relep);	//nó novo aponta pro endereço que apontava pro primeiro(que agora sera o segundo)
	(*relep) = noh;	//endereço do inicio aponta pro novo primeiro noh
}

//adiciono um elemento novo em qualquer lugar
void adicionaElementoPosicao(){

}

//Remove elemento novo
void removeElemento(tle* rlep, int elemento){


}

//Busca elemento
void buscaElemento(tle* rlep, int elemento){


}


//Tamanho da lista
int tamanhoListaEncadeada(telemento* relep){
	if( relep == NULL){	//Verifica se a Lista é valida!
		return 0;
	}
	int contador = 0;
	telemento noh*;
	noh = *relep;	//Que conteudo de relep? proximo ou info? R: o conteudo desse ponteiro é um outro ponteiro.
	while( noh != NULL ){
		contador++;
		noh = (*noh).proximo;
	}
	return contador;
}

//Lista cheia não faz sentido ter em listas dinamicas porque o limite é a própria memória


//Lista Vazia
int listaEncadeadaVazia(telemento* relep){
	if(relep == NULL){	//se o ponteiro não esta apontando pra nenhum outro endereço lista está vazia(true)
		return 1;
	}
	if((*relep) == NULL){
		return 1;		//se o ponteiro não esta apontando pra nenhum conteudo lista está vazia(true) 
	}
	return 0;
}


//Printa a Lista
void printaListaEncadeada(tle* rlep){

}