# Carro 2.0

Implementação um programa simples, mas completo, em Java com uma classe para representar carros e outra com interação com o usuário.

Esse programa é uma possível solução para uma sequência de exercícios usada em disciplinas de Orientação a Objetos.

A sugestão é que você faça os exercícios listados abaixo sem olhar o código presente aqui e, depois de pronto, confira a resposta.

## Exercícios

### 1. Classe Carro

Suponha que você esteja começando a criar um jogo de corrida e, nele, precisará representar um carro.  No seu contexto, um carro é algo que tem nome e velocidade.

Vamos então definir uma classe `Carro`, com os atributos nome e velocidade. Sabemos que precisamos também definir um construtor e métodos de acesso a esses atributos.

Utilize o exemplo abaixo como referência.

Exemplo de código Java:

```java
public class NomeDaClasse {

	// Atributos
	private int atrituboInteiro;
	private String atributoString;

	// Construtor
	public NomeDaClasse() {
		...		
	}

	// Método
	public int getAtributoInteiro() {
		return atributoInteiro;
	}
}
```

### 2. Primeiro Programa

Crie uma classe que tem o método `main`. Dentro do método, crie um objeto do tipo `Carro` cujo nome seja *Fusca* e, em seguida, exiba seus dados na tela.

Obs.: a classe Carro não deve fazer nenhuma exibição de dados para o usuário.

Exemplo de código Java:

```java
public class Programa {

	public static void main(String[] args) {
		
		NomeDaClasse var = new NomeDaClasse();
		
		int a = var.getAtributoInteiro();
	
		...
	}	
}
```

### 3. Acelerando

Vamos melhorar nosso exemplo. Crie na classe `Carro` os métodos `acelerar` e `reduzir` que, respectivamente, aumenta e diminui a velocidade do carro em 10 unidades.

Altere a classe principal adicionando linhas para acelerar o carro e depois exiba novamente os dados dele.

### 4. Obtendo dados do usuário

Altere o programa do exercício anterior de forma a obter do usuário o nome do carro a ser criado e a quantidade de vezes que o carro será acelerado. Por fim, exiba os dados do carro criado.

- Veja nos slides anteriores (1.2 - Introdução Java) como usar um objeto da classe Scanner para obter dados do usuário. 
  - Obs.: por enquanto, ignore o aviso do VS Code (“Resource leak: 'entrada' is never closed"). Veremos mais detalhes sobre isso nas aulas de tratamentos de exceção.

### 5. Menu

Altere o programa do exercício anterior de forma que ele exiba o menu abaixo e execute as ações do menu. Deve ser criado um método separado para exibição do menu e outro para tratar a opção de menu escolhida pelo usuário.

Obs.: neste passo faz sentido que a classe principal passe a ter um atributo da classe Carro.

```
1. Criar o carro
2. Acelerar o carro
3. Reduzir a velocidade
4. Exibir os dados do carro
5. Sair
```

### 6. Evitando atributos e métodos estáticos

O fato do método `main` ser estático em Java, acaba levando a declarações de atributos e métodos estáticos dentro da mesma classe. Mas, conceitualmente, muitas vezes não faria muito sentido eles serem estáticos.

Por isso, uma boa prática é deixar a classe que tem o método `main` tendo apenas esse método, e dentro dele criar um objeto de uma classe que realmente é a classe principal do programa. Dessa forma, dentro da classe principal, os atributos e métodos não precisam ser declarados abstratos.

Portanto, nesse passo faça o seguinte:
- Crie uma classe chamada `Principal` e leve para ela os atributos e métodos que antes estavam na classe que tem o método `main`. 
  - Deixe o loop do menu em um método chamado `executar`.
  - Lembre-se que os atributos e métodos da classe `Principal` não devem ser estáticos!
- Altere o método `main` da outra classe para que ele tenha apenas os seguintes comandos:
  - Declare e crie um objeto da classe `Principal`.
  - Chame o método `executar` do objeto criado.

### 7. Trabalhando com vetores

Vamos agora alterar a classe `Principal` para que ela passe a trabalhar com um vetor de carros de 5 posições. Faça as alterações necessárias para tratar o vetor, dentre elas:
- Declare o atributo e crie-o no construtor.
- Na opção criar carro, um único carro deve ser criado e acrescentado ao vetor.
  - O usuário poderá acessar essa opção várias vezes, para criar vários carros.
  - Mas depois que o vetor estiver cheio, o usuário deve ser informado que não é possível criar mais carros.
- Altere as opções acelerar e reduzir do menu pedindo ao usuário qual carro ele quer tratar.
  - Para isso, peça o nome do carro ao usuário e o encontre no vetor.
- Altere a opção exibir do menu para que exiba as informações de todos os carros já criados.

```java
// Exemplo de sintaxe

// Declaração de vetor
Nave[] naves;
	
// Criação de um objeto vetor
naves = new Nave[10];

// Loop em um vetor por posição
for (int i = 0; i < naves.length; i++) {
	Nave n = naves[i];
	n.atirar();
}

// Loop em um vetor usando for-each
for (Nave n : naves) {
	n.atirar();
}
```