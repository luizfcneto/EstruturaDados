/*
Descrição: Implementação das funcoes em lista1.c
Tamanho da lista -> Cheia ou vazia?
Cheia -> se estiver cheia nao posso inserir mais elementos(dados)
Vazia -> se estiver vazia nao posso remover elementos(dados)


Notação	:	rlip 	-> referencialistaponteiro.
		:	rap 	-> referenciaAlunoponteiro.
*/
#define MAX 200


//Estrutura de Aluno <DADO da LISTA>
typedef struct tAluno{
	int matricula;
	char nome[50];
	float nota1, nota2, nota3;
	float media;
	bool aprovado = false; //Aprovado = true quando media > 5
}taluno;

//Estrutura de Lista 
typedef struct  tLista{
	int quantidade;		//Lista possui quantidade(inteiro)
	Aluno dados[MAX];	//Lista possui vetor de Outra Estrutura Aluno[]

}tlista;

//Criar Lista		-> fopen() de arquivo
tlista* criaLista(){
	tlista *lip;
	lip = (tlista)*malloc(sizeof(tlista));
	if(lip != NULL){	//Verifica se lista foi criada
		(*lip).qtd = 0; //inicia quantidade de Lista = 0
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
inr listaVazia(tlista* rlip){
	if(rlip == NULL){
		return -1;
	}else{
		return ((*rlip).quantidade == 0);
	}

}

//adicionar na lista 	Existem 3 tipos de insercao na lista
void adicionaLista(tlista* rlip, taluno* rap){
	if(rlip == NULL){
		return 0;				
	}
	
	//Adicionando no final da lista:
	if( (*rlip).tamanho < MAX){ 	//Se o tamanho da lista for menor que o Maximo de alunos faça:
		
		(*rlip).dados[tamanho] = rap;
		(*rlip).tamanho++;
		puts("Aluno adicionado com sucesso!");
			
	}else{
		puts("Lista Cheia");
	}

	//Adiciona no inicio da lista:
	if( (*rlip).tamanho < MAX ){
		//percorrer a lista do ultimo elemento ate o primeiro, coipando eles em uma posicao acima pra gerar espaço no inicio da lista
		for(int i = (*rlip).tamanho ; i <= 0 ; i--){
			(*rlip).dados[i+1] = (*rlip).dados[i];

		}
		//adicionar o elemento na primeira posiçao
		(*rlip).dados[0] = rap;
		(*rlip).tamanho++;
	}else{
		puts("Lista Cheia");
	}
	
	//
}


//remover da lista, só é possivel caso ela nao seja vazia. Somente o primeiro, o ultimo e o termo do meio devem ser apagados
void removeDaLista(tlista* rlip, int matriculaV){
	int tamanhoAux;
	if(rlip == NULL){
		puts("Erro");
	}
	//Problema: Quando mais de um elemento da lista possuir a mesma matriculaV
	for(int i = 0; i < (*rlip).tamanho; i++){
		
		if((*rlip).dados[i].matricula == matriculaV){
			
			(*rlip).dados[i] = (*rlip).dados[i+1];
			tamanhoAux = i; //armazena a posicao do elemento que foi removido
		}
	}

	//conserta todos os elementos acima da posicao do que foi removido para copiar-los pra posicao anterior
	for(int j = 0; j < (*rlip).tamanho; j++){
		if(j > tamanhoAux){
			(*rlip).dados[i] = (*rlip).dados[i+1];
		}
	}
}