# ♟Sobre o projeto

O algoritmo Minimax é um algoritmo de busca utilizado em jogos de decisão, como xadrez, damas, entre outros, onde dois jogadores competem, alternando suas jogadas. O objetivo do algoritmo Minimax é determinar a melhor jogada para um jogador, assumindo que o adversário também está jogando de forma ótima.

A ideia central do algoritmo Minimax é construir uma árvore de jogadas possíveis, onde os nós representam estados do jogo e as arestas representam as jogadas possíveis a partir desses estados. Em seguida, é feita uma busca recursiva na árvore, alternando entre os jogadores, para determinar o valor de cada nó da árvore.

Este repositório possui uma implementação desse algoritmo, aplicado ao jogo de xadrez, utilizando Java.

## 🎩Principais etapas do algoritmo Minimax:

**Construção da Árvore de Jogadas**: A árvore é construída começando pelo estado atual do jogo e gerando todos os estados possíveis que podem ser alcançados a partir desse estado, de acordo com as regras do jogo. Isso é feito até que uma condição de parada seja alcançada, como atingir um estado final do jogo ou uma profundidade máxima da árvore.

**Avaliação dos Estados Terminais**: Nos estados finais da árvore (ou em uma profundidade máxima pré-definida), é feita uma avaliação do estado do jogo para determinar o valor desse estado para o jogador. Em jogos de dois jogadores, isso geralmente é feito usando uma função de avaliação que atribui um valor numérico a cada estado.

**Busca Recursiva**: A partir dos estados terminais, a busca recursiva retrocede na árvore, alternando entre os jogadores. Para cada nó, o algoritmo tenta maximizar ou minimizar o valor dos estados, dependendo de qual jogador está jogando. Um jogador tenta maximizar seu valor (visto como positivo), enquanto o adversário tenta minimizá-lo (visto como negativo).

**Retorno dos Valores**: À medida que a busca recursiva avança e retrocede na árvore, os valores dos nós são propagados de volta para os pais. Em um nó de maximização, o valor do nó é o máximo dos valores de seus filhos; em um nó de minimização, o valor do nó é o mínimo dos valores de seus filhos.

**Tomada de Decisão**: Finalmente, após a busca recursiva ter percorrido toda a árvore, a melhor jogada é escolhida com base nos valores dos nós raiz da árvore. Se o jogador atual é o maximizador, ele escolhe a jogada que maximiza o valor do nó raiz; se o jogador atual é o minimizador, ele escolhe a jogada que minimiza o valor do nó raiz.

---

## 📄Classes do repo

**App**: Classe principal com método main, utilizado para iniciar o jogo utilizando a classe GameManager

**GameManeger**: Classe responsável por instanciar as Classes Board, Player e AI. Inicia o jogo, apresenta o jogo, controla a jogo atual e permite realizar novas tentativas.

**Board**: Responsável por apresentar o tabuleiro do nosso jogo, verifica as jogadas possíveis e retorna se determinado jogador ganhou ou se ouve impate na partida. Possui também internamente a classe **Move** que gerencia o eixo X e Y de movimentação dos jogadores.

**Player**: Representação do jogador, dado um Board possui um método que recebe a próxima jogada do mesmo.

**AI**: Classe que possui a implementação do algoritmo minimax, recebe o Board atual e calcula qual a próxima melhor jogada. Possui a classe **Classification** que auxilia na atribuição de um peso para o nó, salvando o movimento.
