/*
Descrição: Implementação das funcoes em lista1.c
Tamanho da lista -> Cheia ou vazia?
Cheia -> se estiver cheia nao posso inserir mais elementos(dados)
Vazia -> se estiver vazia nao posso remover elementos(dados)


Notação	:	rlip 	-> referencialistaponteiro.
		:	rap 	-> referenciaAlunoponteiro.
*/
#define MAX 10


//Estrutura de Aluno <DADO da LISTA>
typedef struct tAluno{
	int matricula; 	//Só iremos implementar as funcoes deste arquivo usando essa variavel
	char nome[50];
	float nota1, nota2, nota3;
	float media;
}taluno;

//Estrutura de Lista 
typedef struct  tLista{
	int quantidade;		//Lista possui quantidade(inteiro)
	taluno dados[MAX];	//Lista possui vetor de Outra Estrutura Aluno[]

}tlista;

//Criar Lista		-> fopen() de arquivo
tlista* criaLista(){
	tlista *lip;
	lip = (tlista*)malloc(sizeof(tlista));
	if(lip != NULL){	//Verifica se lista foi criada
		(*lip).quantidade = 0; //inicia quantidade de Lista = 0
	}
	return lip;
}

//Liberar Lista 	-> fclose() de arquivo
void liberaLista(tlista* rlip){
	free(rlip);
}

//Retorna tamanho da lista
int tamanhoLista(tlista* rlip){
	if(rlip == NULL){
		return -1;
	}else{
		return (*rlip).quantidade;
	}
}

//Verifica se a lista esta cheia
int listaCheia(tlista* rlip){
	if(rlip == NULL){
		return -1;
	}else{
		return ((*rlip).quantidade == MAX);
	}
}

//Verifica se a lista esta vazia
int listaVazia(tlista* rlip){
	if(rlip == NULL){
		return -1;
	}else{
		return ((*rlip).quantidade == 0);
	}

}

//adicionar no inicio da  lista 
void adicionaInicioLista(tlista* rlip, taluno* rap){
	if(rlip == NULL){
		puts("ERRO - Lista Invalida");				
	}

	//Adiciona no inicio da lista:
	if( (*rlip).quantidade < MAX ){
		//percorrer a lista do ultimo elemento ate o primeiro, coipando eles em uma posicao acima pra gerar espaço no inicio da lista
		for(int i = (*rlip).quantidade-1 ; i >= 0 ; i--){
			(*rlip).dados[i+1].matricula = (*rlip).dados[i].matricula;	
		}
		//adicionar o elemento na primeira posiçao
		(*rlip).dados[0].matricula = (*rap).matricula;
		(*rlip).quantidade++;
		puts("Aluno adicionado no inicio da lista com sucesso! ");
	}else{
		puts("ERRO - Lista Cheia \n");
	}
	
}


//Adiciona no final da lista
void adicionaFinalLista(tlista* rlip, taluno* rap){
	if(rlip == NULL){
		puts("ERRO - Lista Invalida");				
	}
		
	if( (*rlip).quantidade < MAX){ 	//Se o tamanho da lista for menor que o Maximo de alunos faça:
		
		(*rlip).dados[(*rlip).quantidade].matricula = (*rap).matricula;
		(*rlip).quantidade++;
		puts("Aluno adicionado no final da lista com sucesso!");
			
	}else{
		puts("ERRO - Lista Cheia! \n");
	}
}

//Adiciona em alguma posição especifica
void adicionaPosicaoLista(tlista* rlip, taluno* rap, int posicao){
	if(rlip == NULL){
		puts("ERRO - Lista Invalida");
	}
	if((*rlip).quantidade < MAX){
		for(int i = (*rlip).quantidade-1; i > posicao; i++){
				(*rlip).dados[i+1].matricula = (*rlip).dados[i].matricula;
		}

		(*rlip).dados[posicao].matricula = (*rap).matricula;
		(*rlip).quantidade++;
		printf("Elemento [ %d ] adicionado com sucesso na posicao: [ %d ]!\n", (*rlip).dados[posicao].matricula, posicao);
	}else{
		puts("ERRO - Lista Cheia! \n");
	}
}

//remover da lista, só é possivel caso ela nao seja vazia. Somente o primeiro, o ultimo e o termo do meio devem ser apagados
void removeDaLista(tlista* rlip, int matriculaV){
	int tamanhoAux = -1;
	if( rlip == NULL ){
		puts("ERRO - lista Invalida");
	}
	//Problema: Quando mais de um elemento da lista possuir a mesma matriculaV
	for(int i = 0; i < (*rlip).quantidade; i++){
		
		if((*rlip).dados[i].matricula == matriculaV){
			
			(*rlip).dados[i].matricula = (*rlip).dados[i+1].matricula;
			(*rlip).quantidade--;
			tamanhoAux = i; //armazena a posicao do elemento que foi removido
			printf("Elemento: %d removido com sucesso \n",i);
		}
	}

	//conserta todos os elementos acima da posicao do que foi removido para copiar-los pra posicao anterior
	if( tamanhoAux != -1){
		for(int j = tamanhoAux; j < (*rlip).quantidade; j++){
			(*rlip).dados[j].matricula = (*rlip).dados[j+1].matricula;
		}
	}

	if(tamanhoAux == -1){
		puts("ERRO - Elemento inexistente na lista \n");
	}
}

//Colocarei para printar apenas a matricula do aluno 
void printaLista(tlista* rlip){
	if(rlip == NULL){
		puts("Erro ao criar Lista");
	}
	printf("Numero de elementos nessa lista: %d \n",(*rlip).quantidade);
	for (int i = 0; i < (*rlip).quantidade; i++){
		printf("	[%d] - [ %d ]  \n",i, (*rlip).dados[i].matricula);
	}
	printf("_____________________________________________________________\n");
	
}

//Busca na lista, pode ser busca por indice ou por conteudo[DADOS]
void buscaPorIndice(tlista* rlip, int posicao){
	if(rlip == NULL){
		puts("ERRO - Lista Invalida! \n");
	}else if(posicao >= (*rlip).quantidade || posicao <=0 ){
		puts("ERRO - Elemento não pertence a essa lista!\n");
	}else{
		printf("	[%d] - [ %d ]  \n",posicao, (*rlip).dados[posicao].matricula);
	}
}

//Busca por um conteudo [DADOS], especificamente matricula
void buscaPorConteudo(tlista* rlip, int matriculaV){
	int aux = -1;
	if(rlip == NULL){
		puts("ERRO - Lista Invalida! \n");
	}else{	
		for(int i = 0; i < (*rlip).quantidade ; i++){
			if((*rlip).dados[i].matricula == matriculaV){
				printf("	[%d] - [ %d ]  \n",i, (*rlip).dados[i].matricula);
				aux = i;
			}
		}
		if(aux == -1){
			puts("ERRO - Elemento não pertence a essa lista! \n");
		}
	}


}