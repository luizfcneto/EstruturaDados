# EstruturaDados
Curso de Estrutura de dados, exemplificações e implementações de cada estrutura.

 1: Lista Estática
  
Vantagens:
   - Acesso Rápido e direto aos elementos (indice)
   - Tempo constante para acessar um elemento
   - Fácil de modificar um elemento
  
Desvantagens:
   - Definicição prévia do tamanho da lista, por ser estática(vetor)
   - Dificuldades para inserir e remover um elemento entre outros dois (é necessário deslocar os elementos)

Quando Utilizar?
  - Em Listas pequenas
  - Inserção e remoção apenas no final da lista
  - Tamanho Máximo bem definido
  - Operação mais frequente é a de BUSCA

2: Lista Dinamica

2.1: Encadeada
 Vantagens:
   - Melhor utilização dos recursos da memória (Se precisar de mais eu aloco durante o programa)
   - Não precisa movimentar os elementos na lista nas operações de inserção e remoção
   
   
Desvantagens:
   - Acesso Indireto aos elemento (Todo conteudo será lincado por uma variavel ponteiro
   - Necessidade de percorrer a lista para acessar a um elemento, conteudo.
   
Quando Utilizar?
   - Quando não posso garantir a quantidade minima de memória pra aplicação
   - Operações mais frequentes são Inserção e Remoção

2.2: DuplamenteEncadeada

Vantagens:
   - Melhor utilização dos recursos da memória (Se precisar de mais eu aloco durante o programa)
   - Não precisa movimentar os elementos na lista nas operações de inserção e remoção
   
   
Desvantagens:
   - Acesso Indireto aos elemento (Todo conteudo será lincado por uma variavel ponteiro
   - Necessidade de percorrer a lista para acessar a um elemento, conteudo.
   
Quando Utilizar?
   - Quando não posso garantir a quantidade minima de memória pra aplicação
   - Operações mais frequentes são Inserção(ordenada) e Remoção
