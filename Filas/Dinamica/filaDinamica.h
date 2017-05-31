/*
	Lista Dinamica
Descrição:	Implementação e declaração das funções utilizadas em filaDinamica.c

*/

//Estrutura Aluno 	(irei implementar apenas com matricula)
struct tAluno
{
	int matricula;
	// char nome[50];
	// float notas[3];

}	taluno;

struct tElemento
{
	struct tElemento *proximo;
	taluno dado;
}

typedef struct tElemento *tRaiz;

tRaiz* criaFila ()
{
	tRaiz *novo;
	novo = ( tRaiz* ) malloc ( sizeof ( tRaiz ) );
	if ( novo == NULL )	printf ("ERRO - Raiz Invalida, nao criada com sucesso! \n"); 

	return novo;
}

//tamanho da Fila
int tamanhoFila ( tRaiz* rfp )
{
	if ( rfp == NULL )	printf ("ERRO - Fila Invalida! \n");
	else {
		tElemento *no;
		no = ( tElemento* ) malloc ( sizeof ( tElemento ) );
		if ( no == NULL )	printf ("ERRO - No nao criado com sucesso! ");
		else {
			no = *rfp;
			int indice = 0;
			while ( no->proximo != NULL ) {
				indice++;
				no = no->proximo;
			}
		}
	}
	return indice;
}

//fila Vazia
int filaVazia ( tRaiz* rfp )
{
	if ( rfp == NULL )	return 1;
	if ( *rfp == NULL )	return 1;
	else {
		return 0;
	}
}

//fila Cheia (Não faz sentido ter, porque é alocado sempre um elemento novo ao ser adicionado)

//Libera Fila
void liberaFila ( tRaiz* rfp )
{

}

//Adiciona Elemento
void adicionaElemento ( tRaiz* rfp, taluno* rap )
{
	
}

//Remove Elemento
void removeElemento ( tRaiz* rfp, taluno* rap )
{

}

//Printa Fila
void printaFila ( tRaiz* rfp )
{
	
}