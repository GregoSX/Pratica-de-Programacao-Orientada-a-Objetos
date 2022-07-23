import java.util.Scanner;

/*
 * Classe que faz a interação com o usuário
 */
public class Principal {

    // Vetor para guardar os carros
    private Carro[] carros;

    // Indica quantos carros já foram criados
    private int nroCarrosCriados;

    // Scanner para obter dados do usuário via terminal
    private Scanner entrada;

    /* 
     * Construtor da classe
     */
    public Principal() {
        carros = new Carro[5];
        nroCarrosCriados = 0;
        entrada = new Scanner(System.in);
    }

    /*
     * Método que trata o loop do menu
     */
    public void executar() {
        int opcao;
        do {
            exibirMenu();
            
            System.out.println("\nDigite sua opção: ");
            opcao = Integer.parseInt(entrada.nextLine());

            tratarMenu(opcao);

        } while (opcao != 5);

        // fecha o objeto Scanner para liberar os seus recursos
        entrada.close();
    }

    /*
     * Método que exibe as opções de menu
     */
    public void exibirMenu() {
        System.out.println("1 - Criar carro");
        System.out.println("2 - Acelerar carro");
        System.out.println("3 - Frear carro");        
        System.out.println("4 - Exibir carros");
        System.out.println("5 - Sair");
    }

    /*
     * Método que trata uma opção de menu escolhida pelo usuário
     */
    private void tratarMenu(int opcao) {
        switch (opcao) {
            case 1:
                criarCarro();
                break;
            case 2:
                acelerarCarro();
                break;
            case 3:
                frearCarro();
                break;
            case 4:
                exibirCarros();
                break;
            case 5:
                System.out.println("Saindo do programa...");
                break;
            default:
                System.out.println("Opção inválida!");
                break;
        }

        // se o usuário não estiver saindo do programa, pede para ele digitar ENTER antes de exibir o menu novamente
        if (opcao != 5) {
            System.out.println("\nDigite ENTER para continuar!");
            entrada.nextLine();
        }
    }

    /*
     * Pede ao usuário o nome de um carro
     */
    private String pedirNomeCarro() {
        System.out.print("Digite o nome do carro: ");
        String nome = entrada.nextLine();
        return nome;
    }

    /*
     * Cria um carro e o adiciona no vetor se ainda existir posição disponível
     */
    private void criarCarro() {
        // Se já foram criados carros para todas as posições do vetor, não é possível criar mais carros.
        if (nroCarrosCriados == carros.length) {
            System.out.println("Não é possível criar mais carros!");
        }
        else { // se ainda há posição disponível no vetor.
            // Pede ao usuário o nome do carro a ser criado
            String nome = pedirNomeCarro();

            // Cria um objeto do tipo carro com o nome passado pelo usuário e o adiciona no vetor.
            // Repare que se não foi criado ainda nenhum carro, o carro deve ser colocado na posição 0 do vetor.
            // Se já foi criado um carro, o segundo carro deve ser colocado na posição 1, e assim por diante.
            // Portanto, o atributo `nroCarrosCriados` pode ser usado para definir a posição a ser utilizada do vetor.
            carros[nroCarrosCriados] = new Carro(nome);

            // Incrementa o número de carros criados
            nroCarrosCriados++;

            System.out.println("Carro criado com sucesso!");
        }
    }

    /*
     * Encontra um carro a partir de um nome informado pelo usuário
     */
    private Carro encontrarCarro() {
        // Obtém o nome do carro do usuário
        String nome = pedirNomeCarro();

        // Percorre o vetor de carros
        for (Carro carro : carros) {
            // Se o objeto não é null, verifica se o nome do carro é igual ao passado
            if (carro != null) {
                if (carro.getNome().equals(nome)) {
                    // Carro encontrado. Ele é retornado.
                    return carro;
                }
            }
        }

        // Se chegou até aqui é porque não encontrou o carro com o nome passado
        return null;
    }

    /*
     * Trata a opção de menu Acelerar Carro
     */
    private void acelerarCarro() {        
        // Busca o carro no vetor             
        Carro carro = encontrarCarro();
        
        // Se o carro foi encontrado o acelera, senão avisa o usuário.
        if (carro != null) {
            System.out.println("Acelerando o carro...");
            carro.acelerar();
        }
        else {
            System.out.println("Carro não encontrado!");
        }
    }

    /*
     * Trata a opção de Frear Carro
     */
    private void frearCarro() {        
        // Busca o carro no vetor             
        Carro carro = encontrarCarro();
        
        // Se o carro foi encontrado o desacelera, senão avisa o usuário.
        if (carro != null) {            
            System.out.println("Freando o carro...");
            // O método reduzir retorna um boolean indicando se é possível reduzir a velocidade ou não,
            // pois ele evita que a velocidade do carro se torne negativa.
            // Dessa forma, precisamos tratar o retorno do método.
            if (carro.reduzir()) {
                System.out.println("Velocidade reduzida.");
            }
            else {
                System.out.println("Não foi possível reduzir a velocidade!");
            }
        }
        else {
            System.out.println("Carro não encontrado!");
        }
    }

    /*
     * Trata a opção de menu Exibir Carros
     */
    private void exibirCarros() {
        System.out.println("Exibindo informações dos carros...");

        // Percorre o vetor de carros
        for (Carro carro : carros) {
            // Se o objeto não é null, exibe suas informações
            if (carro != null) {                
                System.out.println("Carro " + carro.getNome() + " tem velocidade " + carro.getVelocidadeAtual());
            }
        }
    }
}
