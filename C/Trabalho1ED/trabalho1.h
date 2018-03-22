/*
Descrição: Implementação das funções utilizadas no arquivo "trabalho1.c"


Nome: Luiz Fernando (luizfcneto)
Email: luizfcneto123@gmail.com
*/

//Estrutura CIDR
typedef struct tCIDR
{
  int blocoIP[4];   //Como armazenarei os Ips?
  char info[100];   //Informação do bloco
} tcidr;


//Estrutura Lista
struct tElemento
{
  tcidr cidr;
  struct tElemento *proximo, *anterior;
}

//Ponteiro para o inicio da Lista
struct tlista tElemento *tRaiz;

//Criar Lista
tRaiz* criaLista ()
{
	tRaiz *listaNova;
	listaNova = ( tRaiz* ) malloc ( sizeof ( tRaiz ) );
	if ( listaNova == NULL )	printf ("ERRO - Lista Invalida! \n");
	else	*listaNova == NULL;

	return listaNova; 
}

//Libera lista
void liberaLista ( tRaiz* referenciaRaiz )
{
	if ( referenciaRaiz == NULL )	printf ("ERRO - Lista Invalida! \n");
	else {
		tElemento *noh;
		noh = malloc ( tElemento* ) malloc ( sizeof ( tElemento ) );
		if ( noh == NULL )	printf ("ERRO - Noh nao criado com sucesso! \n");
		else {
			noh = *referenciaRaiz;
			while ( *referenciaRaiz != NULL ) {
				noh = *referenciaRaiz;
				*referenciaRaiz = *referenciaRaiz->proximo;
				free ( noh );
			}
			free ( referenciaRaiz );
		}
	}
}

// Criterio de Ordenação será o Bloco de IP
void adicionaListaOrdenado ( tRaiz* referenciaRaiz, tcidr* rcidr )
{
	if ( referenciaRaiz == NULL )	printf ("ERRO - Lista Invalida! \n");
	else {
		tElemento *novo, *noh;
		novo = ( tElemento* ) malloc ( sizeof ( tElemento ) );
		noh = ( tElemento* ) malloc ( sizeof ( tElemento ) );
		if ( novo == NULL || noh == NULL )	printf ("ERRO - Noh ou novo nao criados com sucesso! \n");
		else {
			bool ajuda = false;
			noh = *referenciaRaiz;
			while ( noh != NULL )	{

				//Criterio de Ordenãção...
				if () {

					ajuda = true;
				}

				noh = noh->proximo;
			}

			if (!ajuda) {
				novo->proximo = noh;
				novo->anterior = noh->anterior;
				noh->proximo = novo;
			}


		}
	}
}


//Busca na lista
void buscaListaConteudo ( tRaiz* referenciaRaiz, tcidr* rcidr )
{
	if ( referenciaRaiz == NULL )	printf ("ERRO - Lista Invalida! \n");
	else {
		tElemento *noh;
		noh = ( tElemento* ) malloc ( sizeof ( tElemento ) );
		if ( noh == NULL )	printf ("ERRO - Noh nao criado com sucesso! \n");
		else {
			bool existe = false;
			while ( noh != NULL ) {

				//Criteiro para verificar se o Ip dado pertence ao grupo que foi dado na entrada
				if ( ) {

					existe = true;
				}
				noh = noh->proximo;
			}

			if ( existe == false ) {
				
			}
			
		}
	}
}
