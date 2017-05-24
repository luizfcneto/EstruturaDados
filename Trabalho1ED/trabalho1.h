/*
Descrição: Implementação das funções utilizadas no arquivo "trabalho1.c"


Nome: Luiz Fernando (luizfcneto)
Email: luizfcneto123@gmail.com
*/

//Estrutura CIDR
typedef struct tCIDR
{
  char blocoIP[4];   //Como armazenarei os Ips?
  char info[100];   //Informação do bloco
} tcidr;


//Estrutura Lista
struct tElemento
{
  tcidr cidr;
  struct tElemento *proximo;
}

//Ponteiro para o inicio da Lista
struct tlista tElemento *telemento;

//Criar Lista
telemento* criaLista ()
{

}

//Libera lista
void liberaLista ()
{

}

//Busca na lista
void buscaLista ()
{

}
