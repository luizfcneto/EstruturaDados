/*
Descrição: 	Arquivo de implementação das funções de Merge Sort e Quick Sort utilizadas no arquivo principal


Nome: Luiz Fernando (luizfcneto)
Email: luizfcneto123@gmail.com
*/


void printaVetor ( int* vetor, int finalPosi)
{
	int indice = 0;
	for ( indice = 0 ; indice <= finalPosi ; indice++ ) {
		printf (" [ %d ] ",vetor[indice]);
	}
}


int separa ( int* vetor, int inicioPosi, int finalPosi )
{
	int aux, direita, esquerda, pivot;	
	direita = finalPosi;
	esquerda = inicioPosi;
	pivot = vetor[inicioPosi];

	//printaVetor (vetor, finalPosi);

	while ( direita > esquerda ) {
		while ( vetor[esquerda] <= pivot ) 	esquerda++;
		while ( vetor[direita] > pivot )	direita--;

		if ( direita > esquerda )	{
			aux = vetor[esquerda];
			vetor[esquerda] = vetor[direita];
			vetor[direita] = aux;	
		}
	}
	vetor[inicioPosi] = vetor[direita];
	vetor[direita] = pivot;
	return direita;
}

//Quick Sort
void quickSort ( int* vetor, int inicioPosi, int finalPosi )
{
	int pivot;

	if ( inicioPosi < finalPosi )	{
		pivot = separa ( vetor, inicioPosi, finalPosi );
		quickSort ( vetor, inicioPosi, pivot-1 );
		quickSort ( vetor, pivot+1, finalPosi );
	}

}
