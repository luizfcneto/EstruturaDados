/*
Descrição: Exemplo de funcionamento de lista estatica
lista1.c possui apenas o algoritmo principal do codigo
a implementação das funcoes utilizadas aqui estao localizadas
em lista1.h

*/

#include <stdio.h>
#include <stdlib.h>
#include "lista1.h"


int main(void){
	puts("\t\t\t	~Lista 01- Estatica~	\t\t\t");
	tlista *lip;
	taluno *ap;
	ap = (taluno*)malloc(sizeof(taluno));
	
	lip = criaLista();
	printaLista(lip);
	//______________________________________________

	//testa inserção de aluno no final da lista
	(*ap).matricula = 111111;
	adicionaFinalLista(lip,ap);
	(*ap).matricula = 111112;
	adicionaFinalLista(lip,ap);
	(*ap).matricula = 111113;
	adicionaFinalLista(lip,ap);
	(*ap).matricula = 111114;
	adicionaFinalLista(lip,ap);
	(*ap).matricula = 111115;
	adicionaFinalLista(lip,ap);
	(*ap).matricula = 111116;
	adicionaFinalLista(lip,ap);
	(*ap).matricula = 111117;
	adicionaFinalLista(lip,ap);
	(*ap).matricula = 111118;
	adicionaFinalLista(lip,ap);

	printaLista(lip);
	//______________________________________________

	//testa inserção do aluno no inicio da lista
	(*ap).matricula = 111110;
	adicionaInicioLista(lip,ap);
	printaLista(lip);
	//______________________________________________

	//testa remoção de alunos na lista:
	removeDaLista(lip, 111111);
	printaLista(lip);
	//______________________________________________

	removeDaLista(lip, 111115);
	removeDaLista(lip, 111118);
	removeDaLista(lip, 111114);
	removeDaLista(lip, 111112);
	removeDaLista(lip, 111117);
	removeDaLista(lip, 111113);

	printaLista(lip);
	//_______________________________________________OK
	
	//Forçar erro ao apagar da lista uma matricula inexistente
	removeDaLista(lip, 111111); // ja tinha sido apagado
	removeDaLista(lip, 111120); //nunca existiu


	//adicionar mais 8 elementos para fazer a lista ficar cheia
	(*ap).matricula = 111111;
	adicionaFinalLista(lip,ap);
	(*ap).matricula = 111112;
	adicionaFinalLista(lip,ap);
	(*ap).matricula = 111113;
	adicionaFinalLista(lip,ap);
	(*ap).matricula = 111114;
	adicionaFinalLista(lip,ap);
	(*ap).matricula = 111115;
	adicionaFinalLista(lip,ap);
	(*ap).matricula = 111119;
	adicionaFinalLista(lip,ap);
	(*ap).matricula = 111117;
	adicionaFinalLista(lip,ap);
	(*ap).matricula = 111118;
	adicionaFinalLista(lip,ap);

	printaLista(lip);
	//_______________________________________________

	//estoura a lista
	(*ap).matricula = 000001;
	adicionaFinalLista(lip,ap);

	printaLista(lip);
	//_______________________________________________

	return 0;
}
