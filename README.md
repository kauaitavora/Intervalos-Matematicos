# Intervalos-Matematicos

### Português

Segundo projeto da disciplina de Paradigmas de Programação. Este projeto implementa uma classe para modelar intervalos de números inteiros na reta numérica, conforme definido na Matemática.

### Funcionalidades:
  1. Verifica se um número está contido no intervalo
  2. Verifica se um intervalo intercepta outro intervalo
  3. Calcula a média dos valores de um intervalo
  4. Computa o produto entre dois intervalos
  5. Computa a união entre dois intervalos
  6. Computa a diferença entre dois intervalos
  7. Computa o produto cartesiano entre dois intervalos
  8. Gera uma imagem com um Diagrama de Venn

### Como utilizar

Intervalos podem ser definidos como \[10,14\], onde os limites são inclusivos, ou também (10,14), onde os limites são exclusivos. 

    ```scala
    val intervalo1 = new Intervalo("(6, 12]")
    val intervalo2 = new Intervalo("(14, 12]")
    
    // funções básicas:
    intervalo1.contem(11)
    intervalo1.intercepta(intervalo2) ou intervalo1.interseccao(intervalo2)
    intervalo1.media()
    intervalo1.produto(intervalo2) 
    intervalo1.uniao(intervalo2) 
    intervalo1.diferenca(intervalo2) 
    intervalo1.produtoCartesiano(intervalo2)

    // utizando a função de gerar o diagrama:
    val diferenca_ab = intervalo1.diferenca(intervalo2)
    val diferenca_ba = intervalo2.diferenca(intervalo1)
    val interseccao = intervalo1.interseccao(intervalo2)

    val diagrama = new DiagramaVenn(490, 360, 300, 790, 360, 300)
    diagrama.desenhaDiagrama(diferenca_ab, diferenca_ba, interseccao)
    ```

### Estrutura do diretório
    
    ├── .bsp
    ├── .scala-build
    ├── project
    ├── src
    │   ├── main
    │   │   ├── scala
    |   |   |   ├── com  
    |   |   |   |   ├── example
    |   |   |   |   |   └── DesenhaImagem.scala
    |   |   |   |   |   └── DiagramaVenn.scala
    |   |   |   |   |   └── Intervalo.scala
    │   │   │   └── App.scala


### English

Second assignement for the Programming Paradigms course. This project implements a class to model intervals of integers on the number line, as defined in Mathematics.

### Features:
  1. Checks if a number is contained within an interval.
  2. Checks if one interval intersects another.
  3. Calculates the average of the values in an interval.
  4. Computes the product of two intervals.
  5. Computes the union of two intervals.
  6. Computes the difference between two intervals.
  7. Computes the Cartesian product of two intervals.
  8. Generates an image with a Venn Diagram.

### How to use

Intervals can be defined as \[10,14\], where the boundaries are inclusive, or (10, 14), where the boundaries are exclusive.

    ```scala
    val intervalo1 = new Intervalo("(6, 12]")
    val intervalo2 = new Intervalo("(14, 12]")
    
    // basic functionalities (following the features list order):
    intervalo1.contem(11)
    intervalo1.intercepta(intervalo2) or intervalo1.interseccao(intervalo2)
    intervalo1.media()
    intervalo1.produto(intervalo2) 
    intervalo1.uniao(intervalo2) 
    intervalo1.diferenca(intervalo2) 
    intervalo1.produtoCartesiano(intervalo2)

    // Using the Venn Diagram
    val diferenca_ab = intervalo1.diferenca(intervalo2)
    val diferenca_ba = intervalo2.diferenca(intervalo1)
    val interseccao = intervalo1.interseccao(intervalo2)

    val diagrama = new DiagramaVenn(490, 360, 300, 790, 360, 300)
    diagrama.desenhaDiagrama(diferenca_ab, diferenca_ba, interseccao)
    ```

### Directory structure

    ├── .bsp
    ├── .scala-build
    ├── project
    ├── src
    │   ├── main
    │   │   ├── scala
    |   |   |   ├── com  
    |   |   |   |   ├── example
    |   |   |   |   |   └── DesenhaImagem.scala
    |   |   |   |   |   └── DiagramaVenn.scala
    |   |   |   |   |   └── Intervalo.scala
    │   │   │   └── App.scala
