import java.util.Scanner;

/*
 * Classe que gera um programa que uso um objeto da classe Carro
 */
public class App {
    public static void main(String[] args) {
        // Cria o objeto scanner para obter dados do usuário
        Scanner entrada = new Scanner(System.in);
        
        // Pede ao usuário o nome do carro a ser criado
        System.out.print("Digite o nome do carro: ");
        String nome = entrada.nextLine();

        // Cria um objeto do tipo carro com o nome passado pelo usuário
        Carro carro = new Carro(nome);

        // Exibe as informações do carro na tela
        System.out.println("Carro " + carro.getNome() + " criado!");
        System.out.println("Velocidade inicial é: " + carro.getVelocidadeAtual());

        // Perguntar ao usuário quantas vezes ele quer acelerar o carro
        System.out.print("Quantas vezes você quer acelerar o carro? ");
        int aceleracoes = Integer.parseInt(entrada.nextLine());

        // linhas para acelerar o carro e depois exiba novamente as informações dele.
        System.out.println("Acelerando o carro...");
        for (int i = 0; i < aceleracoes; i++) {
            carro.acelerar();
        }
        System.out.println("Velocidade atual: " + carro.getVelocidadeAtual());

        // fecha o objeto Scanner para liberar os seus recursos
        // Sem isso, o VS Code fica exibindo um aviso: "Resource leak: 'entrada' is never closed"
        entrada.close();
    }    
}
