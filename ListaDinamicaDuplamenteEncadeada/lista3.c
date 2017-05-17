/*
Descrição: Exemplo de funcionamento e implementações 
da estrutura: lista dinamica duplamente encadeada

Nome: Luiz Fernando (luizfcneto)
*/

#include <stdio.h>
#include <stdlib.h>
#include "lista3.h"

int main(void){
	
	tRaiz *listaDuplamenteEncadeada;
	taluno *dados;

	dados = ( taluno* ) malloc ( sizeof ( taluno ) );

	listaDuplamenteEncadeada = criaLista ();
	// printf ("Criou a lista");
	

	//teste adicionando final
	dados->matricula = 111118;
	adicionaFinalLista ( listaDuplamenteEncadeada, dados );
	dados->matricula = 111119;
	adicionaFinalLista ( listaDuplamenteEncadeada, dados );
	dados->matricula = 111120;
	adicionaFinalLista ( listaDuplamenteEncadeada, dados );
	dados->matricula = 111121;
	adicionaFinalLista ( listaDuplamenteEncadeada, dados );

	printaListaDuplamenteEncadeada ( listaDuplamenteEncadeada );

	//teste adicionando inicio
	dados->matricula = 111113;
	adicionaInicioLista ( listaDuplamenteEncadeada, dados );
	dados->matricula = 111112;
	adicionaInicioLista ( listaDuplamenteEncadeada, dados );
	dados->matricula = 111111;
	adicionaInicioLista ( listaDuplamenteEncadeada, dados );
	dados->matricula = 111110;
	adicionaInicioLista ( listaDuplamenteEncadeada, dados );

	printaListaDuplamenteEncadeada ( listaDuplamenteEncadeada );

	//teste Adicionando ordenado!
	dados->matricula = 111115;
	adicionaOrdenadoLista ( listaDuplamenteEncadeada, dados );
	dados->matricula = 111114;
	adicionaOrdenadoLista ( listaDuplamenteEncadeada, dados );
	dados->matricula = 111117;
	adicionaOrdenadoLista ( listaDuplamenteEncadeada, dados );
	dados->matricula = 111116;
	adicionaOrdenadoLista ( listaDuplamenteEncadeada, dados );

	printaListaDuplamenteEncadeada ( listaDuplamenteEncadeada );


	// //remover escolhido da lista 	FUNCIONE!
	// removerPosicaoLista ( listaDuplamenteEncadeada, 3 );
	// removerPosicaoLista ( listaDuplamenteEncadeada, 5 );

	// //remover escolhido da lista 	NAO FUNCIONE!
	// removerPosicaoLista ( listaDuplamenteEncadeada, -3 );
	// removerPosicaoLista ( listaDuplamenteEncadeada, 20 );

	// //remover por conteudo 	FUNCIONE!
	// dados->matricula = 1111117;
	// removerConteudoLista ( listaDuplamenteEncadeada, dados );
	// dados->matricula = 1111119;
	// removerConteudoLista ( listaDuplamenteEncadeada, dados );

	// //remover conteudo NAO FUNCIONE!
	// dados->matricula = 123;
	// removerConteudoLista ( listaDuplamenteEncadeada, dados );
	// dados->matricula = 321;
	// removerConteudoLista ( listaDuplamenteEncadeada, dados );

	// // Busca por indice FUNCIONA!
	// buscaPosicaoLista ( listaDuplamenteEncadeada, 4 );

	// //Busca por indice NAO FUNCIONA!  
	// buscaPosicaoLista ( listaDuplamenteEncadeada, 8 );

	// //Busca por Conteudo FUNCIONA!
	// dados->matricula = 111111;
	// buscaConteudoLista ( listaDuplamenteEncadeada, dados );

	// //Busca por Conteudo NAO FUNCIONA!
	// dados->matricula = 111118;
	// buscaConteudoLista ( listaDuplamenteEncadeada, dados );
	

	// //liberaLista ( listaDuplamenteEncadeada );


	return 0;
}
