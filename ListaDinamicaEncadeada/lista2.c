/*
Descrição: Exemplo de funcionamento de implementação
da estrutura de dados: Lista Dinamica Encadeada.

Nome: Luiz Fernando

*/

#include <stdio.h>
#include <stdlib.h>
#include "lista2.h"

int main ( void )
{
	tRaiz *listaEncadeada;
	taluno *dados;

	dados = ( taluno* ) malloc ( sizeof ( taluno ) );
	// int posicao = 5;

	listaEncadeada = criaLista ();
	printaListaEncadeada ( listaEncadeada );

	dados->matricula = 111111;
	adicionaElementoFinal ( listaEncadeada, dados );
	dados->matricula = 111112;
	adicionaElementoFinal ( listaEncadeada, dados );
	dados->matricula = 111113;
	adicionaElementoFinal ( listaEncadeada, dados );
	dados->matricula = 111114;
	adicionaElementoFinal ( listaEncadeada, dados );
	dados->matricula = 111116;
	adicionaElementoFinal ( listaEncadeada, dados );
	dados->matricula = 111117;
	adicionaElementoFinal ( listaEncadeada, dados );
	dados->matricula = 111118;
	adicionaElementoFinal ( listaEncadeada, dados );
	dados->matricula = 111119;
	adicionaElementoFinal ( listaEncadeada, dados );

	printaListaEncadeada ( listaEncadeada );

	dados->matricula = 111110;
	adicionaElementoInicio ( listaEncadeada, dados );
	printaListaEncadeada ( listaEncadeada );

	dados->matricula = 111115;
	adicionaElementoPosicaoOrdenado ( listaEncadeada, dados );
	printaListaEncadeada ( listaEncadeada );

	return 0;
}