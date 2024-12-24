# Data structure with Java

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Este repositório tem como objetivo registrar meu desenvolvimento em **estrutura de dados**.
Uma vez que estou focado em revisar os fundamentos e adquirir o hábito de resolver problemas deste tipo, pretendo subir minhas mudanças por aqui na medida que for avançando neste tema. 

Para avançar no estudo de estrutura de dados estou seguindo o curso [Java Data Structures and Algorithms + LEETCODE exercises](https://www.udemy.com/course/data-structures-and-algorithms-java/?couponCode=24T7MT123024) na plataforma udemy. Escolhi este curso em específico, pois o assunto estrutura de dados não é algo trivial, além disso a minha maior dificuldade é tentar imaginar como funciona cada passo do algoritmo. Neste curso o passo a passo ocorre de forma muito didática inclusive com a apresentação visual de cada etapa o que facilita bastante, por isso a escolha do curso.

## Big O

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Dois algoritmos desenvolvidos para alcançar o mesmo resultado podem ser medidos de várias formas, como por exemplo pela sua legibilidade. Característica essa que facilita o entendimento do código. Também podemos avaliar pela coesão, qualidade interessante que permite a separação clara de responsibilidades como no exemplo dos métodos e etc; 

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Porém, **Big O** é uma forma de comparar dois algoritmos quanto a eficiência de execução representada de forma matemática. Em entrevistas que a análise de algoritmos é cobrada, com certeza vão questionar sobre Big O, e neste cenário é importante entender os conceitos de _time complexity_ e _space complexity_. A ideia de time complexity é medir o algoritmo quanto ao tempo de execução, e space complexity é o quanto aquele algoritmo, em tempo de execução, utiliza a memória ram. Logo, uma pergunta do tipo, imagine que agora a prioridade é o consumo de memória, neste cenário qual algoritmo seria mais indicado?!

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Ao analisar a complexidade de tempo e espaço de um algoritmo há 3 letras gregas que representam os cenários: no melhor caso, na média e no pior caso. Para identificar cada cenário, utilizamos as letras Ômega, Teta e Omicron respectivamente, onde tecnicamente Big O é representada pela letra Omicron, logo indica a análise do algoritmo no **pior caso**. Não é raro encontrar pessoas pedindo para analisar o algoritmo na média dos casos e chamar essa análise de Big O, porém tecnicamente isto não está correto. 

### O(n) - Proporcional

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;O(n) se caracteriza por representar algoritmos de complexidade proporcional, ou seja, dada uma entrada a complexidade aumenta proporcionalmente. Como segue exemplo abaixo:

```java
    public void printNumbers(int n) {
        for(int i = 1; i <= n; i++) {
            System.out.println("Number: " + i);
        }
    }
```

No exemplo descrito acima, em um loop **for** onde a quantidade de iterações é representada por uma dado N, e neste loop imprimimos o valor corrente oriundo de N, na medida que aumentamos ou diminuímos o valor N temos uma diferença proporcional de instruções executadas. Neste cenário denominamos complexidade Big O de **O(n)**.

### Simplificação - Drop Constants

Em Big O existem alguns caminhos para **simplificação** e um deles é o de **remoção** de constantes. A seguir vamos avaliar essa estratégia. Usando o exemplo anterior vamos adicionar mais um loop ao código, vejamos:

```java
    public void printNumbers(int n) {
        for(int i = 1; i <= n; i++) {
            System.out.println("Number: " + i);
        }

        for(int j = 1; j <= n; j++) {
            System.out.println("Number: " + j);
        }
    }
```

Neste caso temos N operações mais N, ou seja N + N = 2n, sendo representado por O(2n). Porém simplificamos a representação removendo a constante 2, ficando apenas O(n). Em termos de Big O pouco importa se estamos realizando a mesma operação na ordem de 2, 10 ou 1000. Para efeito de comparação nós representamos O(2n), O(10n) ou O(1000n) como **O(n)**. 

### O(n^2)

No exemplo anterior se ao invés de termos loops em paralelos tivéssemos loops aninhados as operações se dariam por N * N. Segue código abaixo:

```java
    public void printNumbers(int n) {
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= n; j++) {
                System.out.println("Number: " + i + " " + j);
            }   
        }
    }
```
Neste cenário temos **complexidade quadrática** O(n^2), o que significa que a complexidade de tempo aumenta rapidamente na medida que o N aumenta. Este tipo de algorítmo é menos eficiente que algorítmos de complexidade proporcional como O(n). Sempre que for possível escolher entre algorítmos de complexidade O(n) e O(n^2), é extramamente indicado o uso do algoritmo de complexidade O(n). 

### Simplificação - Drop Non-Dominants

Vamos agora avaliar uma situação onde há complexidades diferentes envolvidas num código de exemplo, que na avaliação da complexidade a **dominante** é a que prevalece. No código abaixo, vamos fazer uma espécie de mescla dos exemplos passados, segue exemplo:

```java
    public void printNumbers(int n) {
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= n; j++) {
                System.out.println("Number: " + i + " " + j);  // O(n^2)
            }   
        }                                                      // +

        for(int z = 1; z <= n; z++) {
            System.out.println("Number: " + z);                // O(n)
        }
    }
```

No exemplo acima, para o N de entrada, temos complexidade O(n^2) devido aos loops aninhados como já haviamos analisado, e logo abaixo O(n) devido ao loop padrão. Logo, teríamos complexidade **O(n^2 + n)**. Porém, ao analisar por exemplo, para N = 100, percebemos que teremos 10.000 execuções no primeiro trecho de código e apenas 100 no segundo, ou seja, a **primeira parte do código**, na medida que N aumenta, interfere substancialmente no número de instruções executadas, enquanto que na segunda parte do código, no loop padrão, a complexidade não aumenta na mesma proporção, podendo, para efeito da determinação da complexidade algorítmica do método, o mesmo ser desprezado. Logo, neste caso desprezaremos O(n) e representaremos o Big O por **O(n^2)**.

### O(1) - Constante

No exemplo a seguir temos apenas uma operação independente de N, vejamos:

```java

    public int addItems(int N) {
        return N + N;
    }

```

No exemplo acima se o N for igual a 10 ou 1 bilhão temos apenas uma operação de soma, logo o Big O desse algoritmo é O(1). Agora vejamos o seguinte exemplo:

```java

    public int addItems(int N) {
        return N + N + N;
    }

```

Se ao invés de uma operação passamos a ter duas operações de soma podendo ter seu Big O representado por O(2), mas podemos simplificar para O(1). Na prática, não estamos muito interessados em representar o número de operações, mas sim se a tendência é termos um número fixo de operações independente do valor de N, logo neste caso a complexidade é representada por **O(1)**. **Complexidade constante** representa o nível mais eficiente das classes de algoritmos.

### O(log n) - Dividir para conquistar

A complexidade logarítmica é muito eficiente pois é representada por uma curva flat e tem um comportamento muito próximo do gráfico de uma função constante, logo é a segunda em eficiência e é muito comum em algorítmos que tem como objetivo dividir para conquistar, como no exemplo, de encontrar um valor em um array já ordenado utilizando o algoritmo binarySearch. Mesmo em arrays muito grandes uma vez ordenado, com poucas iterações é possível encontrar qualquer número neste array. Logo, para essas classes de algorítmos se convencionou representar a complexidade por **O(log n)**.

### Different terms for inputs

Vamos observar um dos exemplos anteriores e realizarmos alguma considerações referente a Big O. 

```java
    public void printNumbers(int a, int b) {
        for(int i = 1; i <= a; i++) {
            System.out.println("Number: " + i);
        }

        for(int j = 1; j <= b; j++) {
            System.out.println("Number: " + j);
        }
    }
```
Anteriomente fizemos a análise desse código partindo do princípio que tinhamos apenas uma entrada N e dois loops executando sequencialmente, ou seja, tínhamos O(n) + O(n) resultando em O(2n) que na prática torna-se O(n). Porém no exemplo acima temos termos diferentes, ou seja, ao invés de apenas N temos agora os termos a e b e loops executando levando tendo como referência a e b. Logo, podemos afirmar que podemos representar a complexidade como O(a) + O(b) ou O(a + b) e essa é a única simplificação que conseguimos fazer, logo, é importante ficar atento para este cenário, avaliar complexidade para termos diferentes pode ser uma pergunta lançada durante uma entrevista.


