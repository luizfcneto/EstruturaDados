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
	//printaListaEncadeada ( listaEncadeada );

	dados->matricula = 111111;
	adicionaElementoFinal ( listaEncadeada, dados );
	dados->matricula = 111112;
	adicionaElementoFinal ( listaEncadeada, dados );
	dados->matricula = 111113;
	adicionaElementoFinal ( listaEncadeada, dados );
	dados->matricula = 111114;
	adicionaElementoFinal ( listaEncadeada, dados );
	dados->matricula = 111115;
	adicionaElementoFinal ( listaEncadeada, dados );
	dados->matricula = 111116;
	adicionaElementoFinal ( listaEncadeada, dados );
	dados->matricula = 111117;
	adicionaElementoFinal ( listaEncadeada, dados );
	dados->matricula = 111118;
	adicionaElementoFinal ( listaEncadeada, dados );
	dados->matricula = 111119;
	adicionaElementoFinal ( listaEncadeada, dados );
	dados->matricula = 111120;
	adicionaElementoFinal ( listaEncadeada, dados );
	dados->matricula = 111121;
	adicionaElementoFinal ( listaEncadeada, dados );
	dados->matricula = 111122;
	adicionaElementoFinal ( listaEncadeada, dados );

	printaListaEncadeada ( listaEncadeada );

	dados->matricula = 111110;
	adicionaElementoInicio ( listaEncadeada, dados );
	printaListaEncadeada ( listaEncadeada );

	/*
	dados->matricula = 111115;
	adicionaElementoPosicaoOrdenada( listaEncadeada, dados );
	printaListaEncadeada ( listaEncadeada );
	*/

	//testa remover que funcione!
	removeElementoPorIndice	( listaEncadeada , 1 );		//indide na lista começa no 0
	printaListaEncadeada ( listaEncadeada );

	dados->matricula = 111113;
	removeElementoPorConteudo ( listaEncadeada , dados );
	//printaListaEncadeada ( listaEncadeada );


	//teste remover que não funcione!
	//removeElementoPorIndice ( listaEncadeada, 15 );
	//dados->matricula = 3;
	//removeElementoPorConteudo ( listaEncadeada , dados );
	printaListaEncadeada ( listaEncadeada );	

	//teste Busca que funcione:
	buscaPorIndice ( listaEncadeada, 4);
	dados->matricula = 111115;
	buscaPorConteudo ( listaEncadeada, dados );


	//teste busca que nao funcione:
	//buscaPorIndice ( listaEncadeada, 100 );
	//dados->matricula = 3;
	//buscaPorConteudo ( listaEncadeada , dados);



	liberaListaEncadeada	( listaEncadeada );
	return 0;
}