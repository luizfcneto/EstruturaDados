/*
Implementação da Fila Estática

*/
#define MAX 10

//Estrutura Aluno
typedef struct tAluno
{
	int matricula;
	// char nome[50];
	// float nota;

} taluno;

// Estrutura Fila
typedef struct tFila
{
	int inicio, final, quantidade;
	taluno dado[MAX];

} tfila;


//Cria Fila
tfila* criaFila ( ) 
{
	tfila *filaEstatica;
	filaEstatica = ( tfila* ) malloc ( sizeof ( tfila ) );
	if (filaEstatica == NULL )	printf ("ERRO - Fila Invalida! \n");
	else {
		filaEstatica->inicio = 0;
		filaEstatica->final = 0;
		filaEstatica->quantidade = 0;
	}

}

//Tamanho da Fila
int tamanhoFila (tfila* rfp)
{
	return rfp->quantidade;
}


//Libera Fila
void liberaFila (tfila* rfp) 
{
	free (rfp);
}

//Insere na Fila

//Printa Fila
void printaFila ( ) 
{

}