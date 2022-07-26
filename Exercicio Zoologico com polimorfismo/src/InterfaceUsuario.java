import java.util.Scanner;

/*
 * Classe que trata a interface com o usuário (menu de opções)
 */
public class InterfaceUsuario {

    // Scanner para obter dados do usuário via terminal
    private Scanner entrada;

    // Objeto zoologico para manipular as informações sobre os animais
    private Zoologico zoologico;

    /* 
     * Construtor da classe
     */
    public InterfaceUsuario() {
        entrada = new Scanner(System.in);
        zoologico = new Zoologico();
    }

    /*
     * Método que trata o loop de exibição e tratamento do menu
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
        System.out.println("1 - Cadastrar animal");
        System.out.println("2 - Descrever animal");
        System.out.println("3 - Listar animais");        
        System.out.println("4 - Listar animais completo");
        System.out.println("5 - Sair");
    }

    /*
     * Método que trata uma opção de menu escolhida pelo usuário
     */
    private void tratarMenu(int opcao) {
        switch (opcao) {
            case 1:
                cadastrarAnimal();
                break;
            case 2:
                descreverAnimal();
                break;
            case 3:
                listarAnimais();
                break;
            case 4:
                listarAnimaisCompleto();
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
     * Método auxiliar que obtém uma String do usuário
     */
    private String pedirString(String instrucao) {
        System.out.print(instrucao + ": ");
        String informacao = entrada.nextLine();
        return informacao;
    }

    /*
     * Método que exibe as opções de animais para cadastro
     */
    public void exibirEspecieParaCadastro() {
        System.out.println("Selecione a espécie que deseja cadastrar: \n");
        System.out.println("1 - Cadastrar Lobo");
        System.out.println("2 - Cadastrar Gato");
        System.out.println("3 - Cadastrar Galinha");        
        System.out.println("4 - Cadastrar Aguia");
    }

    /*
     * Trata a opção de menu: Cadastrar Animal
     */
    private void cadastrarAnimal() {
        String nome;
        String corPelo;
        
        exibirEspecieParaCadastro();
        int opcao = Integer.parseInt(entrada.nextLine());

        if(opcao == 1 || opcao == 2) {
            nome = pedirString("Digite o nome do animal");
            corPelo = pedirString("Digite a cor do pelo do animal");
            if(opcao == 1) {
                zoologico.adicionarLobo(nome, corPelo);
            } 
            else {
                zoologico.adicionarGato(nome, corPelo);
            }
        } 
        else if(opcao == 3 || opcao == 4) {
            nome = pedirString("Digite o nome do animal");
            if(opcao == 3) {
                zoologico.adicionarGalinha(nome);
            }
            else {
                zoologico.adicionarAguia(nome);
            }
        } 
        else {
            System.out.println("Opção inválida!");
        }
    }

    /*
     * Trata a opção de menu: Descrever Animal
     */
    private void descreverAnimal() {
        String nome = pedirString("Digite o nome do animal");
        System.out.println(zoologico.descricaoLongaUnica(nome));
    }

    /*
     * Trata a opção de menu: Listar Animais
     */
    private void listarAnimais() {
        System.out.println(zoologico.descricaoTodos());
    }

    /*
     * Trata a opção de menu: Listar Animais Completos
     */
    private void listarAnimaisCompleto() {
        System.out.println(zoologico.descricaoLongaTodos());
    }
}