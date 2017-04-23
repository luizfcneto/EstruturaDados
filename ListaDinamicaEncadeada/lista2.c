/*
Descrição: Exemplo de funcionamento de implementação
da estrutura de dados: Lista Dinamica Encadeada.

Nome: Luiz Fernando

*/

#include <stdio.h>
#include <stdlib.h>
#include "lista2.h"

int main(void) {
	tElementoDaListaEncadeada *lista;
	taluno *dados;
	int posicao = 5;

	criaLista(lista);
	printaListaEncadeada(lista);

	dados->matricula = 111111;
	adicionaElementoFinal(lista, dados);
	dados->matricula = 111112;
	adicionaElementoFinal(lista, dados);
	dados->matricula = 111113;
	adicionaElementoFinal(lista, dados);
	dados->matricula = 111114;
	adicionaElementoFinal(lista, dados);
	dados->matricula = 111116;
	adicionaElementoFinal(lista, dados);
	dados->matricula = 111117;
	adicionaElementoFinal(lista, dados);
	dados->matricula = 111118;
	adicionaElementoFinal(lista, dados);
	dados->matricula = 111119;
	adicionaElementoFinal(lista, dados);

	printaListaEncadeada(lista);

	dados->matricula = 111110;
	adicionaElementoInicio(lista, dados);
	printaListaEncadeada(lista);

	adicionaElementoPosicao(lista, dados, posicao);
	printaListaEncadeada(lista);


	return 0;
}