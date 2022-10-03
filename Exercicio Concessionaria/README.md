[![Open in Visual Studio Code](https://classroom.github.com/assets/open-in-vscode-c66648af7eb3fe8bc4f294546bfd86ef473780cde1dea487d3c4ff354943c9ae.svg)](https://classroom.github.com/online_ide?assignment_repo_id=8286451&assignment_repo_type=AssignmentRepo)
# Concessionária Multimarcas

Este projeto é utilizado em exercícios sobre Padrões de Projeto em disciplinas de Programação Orientada a Objetos.


## Passo 1

Execute o programa implementado neste projeto teste todas as suas opções.

Estude o projeto e veja que ele possui uma classe base `Carro` e classes específicas para cada modelo de carro.
Ele também possui uma classe `Concessionaria` que permite que o usuário compre um carro.

Em seguida, mude a marca da franquia da `Concessionaria` (alterando a chamada do seu construtor) e teste o programa novamente.

## Passo 2

No exercício anterior vimos que a classe `Concessionaria` não tem os carros de todas as categorias para a Marca VW.

Faça as alterações necessárias para que a classe `Concessionaria` consiga entregar modelos de Saveiro (Pickup da VW).
Por enquanto não trate os carros de luxo.

O que você achou das mudanças no código?

> As mudanças foram extensas, pois foi necessário criar uma nova classe e ainda alterar uma classe que já estava pronta e testada. Isso aumenta o risco de erros ao implementar as novas funcionalidades.

O que aconteceria se o carro popular da VW passasse a ser o UP!
Que partes do código precisariam ser alteradas?

> Teríamos que alterar o construtor da classe Gol e retirar sua categoria popular e criar a classe UP. Além disso, seria necessário alterar as condições do método comprarCarro da classe Concessionaria.

O que aconteceria se quiséssemos agora comprar carros da Chevrolet?
Que partes do código precisariam ser alteradas?

> Em primeiro plano, precisariamos alterar a classe Marca adicionando um novo tipo. Depois disso, seria necessário mudar a franquia da Concessionaria e criar classes de carros que são Chevrolet. Por fim, teriamos que adicionar novas condições no método comprarCarro da classe Concessionaria.

## Passo 3

Veja que no passo anterior, nós acabamos mudando o código da classe `Concessionaria` para produzir carros diferentes.
Isso está acontecendo porque nossa classe está dependendo de classes concretas (ou seja, depende da criação de objetos de tipos específicos).

Seguindo os princípios de design que aprendemos, o ideal é que nossas classes sejam abertas para extensão e fechadas para modificação.
Se nós quiséssemos tratar uma nova marca (Chevrolet, por exemplo) teríamos que fazer ainda mais modificações na classe `Concessionaria`.

Na aula teórica vimos que o Padrão de Projeto **Abstract Factory** é muito útil nessas situações.
Com ele, nós poderemos criar carros de tipos diferentes (inclusive de marcas diferentes) sem precisarmos ficar alterando o código da classe `Concessionaria` a cada novo modelo de carro.

Faça então a modelagem UML das alterações necessárias para implementar o Abstract Factory, considerando duas fábricas concretas: VW e Fiat.
Exporte a modelagem para o formato `png`e coloque o arquivo em uma pasta `doc` dentro da pasta principal do projeto, 

Dica: use o software DIA para fazer a modelagem (preocupe-se apenas com uma visão geral das classes e dos métodos principais necessários)

## Passo 4

Faça a implementação de acordo com a modelagem do exercício anterior.
Crie as classes necessárias para tratar as marcas VW e Fiat.
Teste suas alterações.

O que aconteceria agora se o carro popular da VW passasse a ser o UP! 
A classe Concessionaria precisaria ser alterada?

> Não, pois a implementação da classe Concessionaria não é mais para classes concretas, ou seja, removemos o código que se modifica do método criarCarroConcessionaria() e criamos a classe FabricasCarro só para cuidar da criação dos carros

O que aconteceria agora se quiséssemos agora comprar carros da Chevrolet?
Que  partes do código precisariam ser alteradas?

> Seria necessário mudar a franquia da Concessionaria e mudar apenas a classe FabricasCarro para tratar dos carros chevrolet. Além disso, é claro que, devemos criar as classes de cada carro da marca chevrolet.

## Passo 5

Faça agora as alterações necessárias para que nossa concessionária possa vender carros da Chevrolet.

Quais mudanças foram necessárias na classe Concessionaria?

> Não foram necessárias mudanças na classe Concessionaria.

## Passo 6

Veja que com a utilização do Padrão Abstract Factory nós ganhamos a possibilidade de até mudarmos a marca da franquia em tempo de execução, caso necessário.

Crie então na classe `Concessionaria` a opção de mudar a marca da franquia e faça os tratamentos necessários.

Adicione uma opção de menu _Mudar Franquia_ que permite ao usuário mudar a franquia da concessionária.
Teste seu programa comprando carros de uma franquia, e depois mude a franquia e compre novos carros.

O que achou das alterações?

> As alterações foram simples, pois a alta coesão facilitou a implementação da opção Mudar Franquia.
