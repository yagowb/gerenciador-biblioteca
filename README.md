O projeto consiste em uma implementação de um gerenciador de biblioteca virtual utilizando uma árvore B+. A biblioteca permite a inserção, remoção e busca de livros com base no título. A estrutura de dados escolhida, a árvore B+, é adequada para lidar com um grande número de registros, proporcionando busca eficiente e suportando operações de inserção e remoção de forma balanceada.


Problema:
O problema é gerenciar uma coleção de livros em uma biblioteca virtual, permitindo a busca rápida de livros por título, além da inserção e remoção eficientes. O objetivo é lidar com um grande número de livros de forma organizada e com bom desempenho.


Solução:
A solução adotada é a utilização de uma árvore B+, uma estrutura de dados em forma de árvore que mantém os registros ordenados e permite uma busca eficiente. A árvore B + é composta por nós internos e nós folhas. Os nós folhas contêm os livros e funcionam como uma lista ligada, permitindo uma busca rápida. Os nós internos são responsáveis por direcionar a busca para o local correto na árvore.


=====================================================================================================

A classe Livro representa um livro, contendo informações como título, autor e ano de publicação.

A classe BibliotecaManager é responsável por gerenciar a biblioteca e utiliza a classe ArvoreBPlus para armazenar e buscar os livros. Ela oferece métodos para inserir, remover e buscar livros na árvore B+. Esses métodos delegam as operações para a árvore B+.

A classe ArvoreBPlus implementa a árvore B+. Ela possui uma referência para a raiz da árvore e um parâmetro de ordem que define a capacidade máxima de chaves em cada nó. A classe ArvoreBPlus possui as classes internas No (abstrata), NoFolha e NoInterno, que representam os nós da árvore: 

A classe abstrata No possui uma lista de chaves. Cada chave é composta por um valor (nesse caso, o título do livro) e uma referência para o objeto correspondente (nesse caso, o livro). Essa lista de chaves é ordenada.
A classe NoFolha representa um nó folha da árvore. Além da lista de chaves, ela possui uma referência para o próximo nó folha na sequência. Isso permite percorrer todos os nós folhas de forma sequencial durante uma busca.
A classe NoInterno representa um nó interno da árvore. Além da lista de chaves, ela possui uma lista de filhos. Esses filhos podem ser nós folhas (para os casos em que o nó interno é uma folha) ou nós internos (para os casos em que o nó interno tem filhos intermediários).
