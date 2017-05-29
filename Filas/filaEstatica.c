/*				Fila Estatica 

Descrição:
	Fila é uma lista encadeada que só podemos inserir e excluir elementos nas extremidades apenas e por sua vez não podemos fazer busca.
	

Nome: Luiz Fernando (luizfcneto)
*/





#include <stdio.h>
#include <stdlib.h>
#include "filaEstatica.h"

int main()
{
	tfila *fila;
	fila = criaFila ();
	taluno *rap;
	rap = ( taluno* ) malloc ( sizeof ( taluno ) );

	//Adiciona na Fila
	rap->matricula = 1111110;
	insereFila (fila, rap);
	rap->matricula = 1111111;
	insereFila (fila, rap);
	rap->matricula = 1111112;
	insereFila (fila, rap);
	rap->matricula = 1111113;
	insereFila (fila, rap);
	rap->matricula = 1111114;
	insereFila (fila, rap);
	rap->matricula = 1111115;
	insereFila (fila, rap);
	rap->matricula = 1111116;
	insereFila (fila, rap);
	rap->matricula = 1111117;
	insereFila (fila, rap);
	rap->matricula = 1111118;
	insereFila (fila, rap);
	rap->matricula = 1111119;
	insereFila (fila, rap);
	rap->matricula = 1111120;
	insereFila (fila, rap);
		

	printaFila (fila);

	//Estoura a Fila
	removeFila (fila);
	removeFila (fila);
	removeFila (fila);
	removeFila (fila);
	removeFila (fila);
	removeFila (fila);
	removeFila (fila);
	removeFila (fila);
	removeFila (fila);
	removeFila (fila);

	printaFila (fila);

	//Adiciona novamente
	rap->matricula = 1111119;
	insereFila (fila, rap);
	rap->matricula = 1111120;
	insereFila (fila, rap);
	
	printaFila (fila);

	//Dando um Erro estranho de memoria
	//liberaFila (fila);

	return 0;
}
