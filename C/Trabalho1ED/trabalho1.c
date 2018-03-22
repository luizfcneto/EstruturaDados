/*
Descrição do Trabalho:
  Criar uma estrutura de dados para resolver o problema:

    Entrada: Ler uma lista de blocos CIDR, informações associadas a cada bloco e guarda-los.

    Após a lista de blocos serão dados uns ips, que devem sem consultados.

    Saida: Imprimir a [informação mais especifica sobre o bloco]

Comentário: o arquivo trabalho1.c só terá o algoritmo principal do programa. Irá usar as funções que serão
implementadas em trabalho1.h

Nome: Luiz Fernando (luizfcneto)
Email: luizfcneto123@gmail.com
*/

#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "trabalho1.h"

int main()
{
	tRaiz *raiz;
	raiz = criaLista ();
	int quantidade;

	// puts ("Informe a quantidade de ips que serão lidos: ");
	scanf ("%d" ,&quantidade);
		
	tcdir *cidrs[quantidade];	//Como inicializo um vetor de ponteiros de estruturas?


	//Entrada dos Blocos CIDR
	for ( int i = 0; i < quantidade; i++ ) {
		scanf ("%d.%d.%d.%d/%d",cidrs[i]->blocoIP[0], cidrs[i]->blocoIP[1], cidrs[i]->blocoIP[2], cidrs[i]->blocoIP[3], cidrs[i]->chaveBloco );
		gets (cidrs[i]->info);
		scanf(" ");				//Ajeitar o Buffer, primeira leitura foi inteiro, depois foi "string"
	}

	//Entrada dos Blocos que quero descobrir a informação 


	return 0;
}
