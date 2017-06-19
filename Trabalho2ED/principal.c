/*
		Trabalho 2
Descrição:	Implementar Quick Sort e Merge Sort. Irei implementar as funções no arquivo "sort.h" e utilizarei elas nesse arquivo principal



Nome: Luiz Fernando (luizfcneto)
Email: luizfcneto123@gmail.com
*/
#include <stdio.h>
#include <stdlib.h>
#include <math.h>
#include "sort.h"


int main ()
{
	int vetor[9], inicio, final;
	inicio = 0;
	final = 9;
	vetor[0] = 3;
	vetor[1] = 4;
	vetor[2] = 2;
	vetor[3] = 17;
	vetor[4] = 15;
	vetor[5] = 19;
	vetor[6] = 21;
	vetor[7] = 8;
	vetor[8] = 12;
	
	printf ("Vetor incial: \n");
	printaVetor (vetor, final);

	// quickSort ( vetor, inicio, final );
	mergeSort ( vetor, inicio, final );
	printf("\nConclusao: \n");
	printaVetor (vetor, final);

	return 0;
}