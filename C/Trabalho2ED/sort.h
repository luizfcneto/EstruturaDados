/*
Descrição: 	Arquivo de implementação das funções de Merge Sort e Quick Sort utilizadas no arquivo principal


Nome: Luiz Fernando (luizfcneto)
Email: luizfcneto123@gmail.com
*/


void printaVetor ( int* vetor, int finalPosi)
{
	int indice = 0;
	for ( indice = 0 ; indice < finalPosi ; indice++ ) {
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

void merge ( int* vetor, int inicioPosi, int meio, int finalPosi )
{
	int *vetorAux, particao1, fimpart1 = 0, particao2, fimpart2 = 0, tamanho, indice2, indice3 = inicioPosi; 
	tamanho = finalPosi-inicioPosi+1;
	particao1 = inicioPosi;
	particao2 = meio+1;
	vetorAux = ( int* ) malloc ( tamanho * sizeof ( int ) );
	if ( vetorAux == NULL )	printf ("ERRO - Vetor auxiliar nao criado com sucesso! \n");
	else {
		for ( int indice1 = 0; indice1 < tamanho; indice1++ ) {
			
			if ( !fimpart1  && !fimpart2 ) {
			
				if ( vetor[particao1] < vetor[particao2] )	vetorAux[indice1] = vetor[particao1++];
				else {
					vetorAux[indice1] = vetor[particao2++];
				}	
			
				if ( particao1 > meio )	fimpart1 = 1;
				if ( particao2 > finalPosi )	fimpart2 = 1;

			}
			
			else {
			
				if ( !fimpart1 )	{
					vetorAux[indice1] = vetor[particao1++];
			
				} else	{
					vetorAux[indice1] = vetor[particao2++];
				}
			}
		}

		for ( indice2 = 0 ; indice2 < tamanho; indice2++, indice3++ )	{
			vetor[indice3] = vetorAux[indice2];
		}
		free ( vetorAux );
	}



}

//Merge Sort
void mergeSort ( int* vetor, int inicioPosi, int finalPosi )
{
	int meio;
	if ( inicioPosi < finalPosi )	{
		meio = floor ( ( inicioPosi+finalPosi )/2 );
		mergeSort ( vetor, inicioPosi, meio );
		// printf("C");
		mergeSort ( vetor, meio+1, finalPosi );
		// printf("A");
		merge ( vetor, inicioPosi, meio, finalPosi );
		// printf ("FUDEU!\n");
	}

}



