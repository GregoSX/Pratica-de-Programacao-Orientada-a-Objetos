import java.util.Scanner;
import java.text.NumberFormat;
import java.util.ArrayList;

public class Banco {
    private ArrayList<Conta> contas;

    Scanner entrada = new Scanner(System.in);

    public Banco() {
        contas = new ArrayList<>();
    }

    public void menu() {
        int opcao;

        do {
            System.out.println("\nSeleciona uma das opções abaixo: \n");
            System.out.println("1) Criar Conta \n2) Consultar Saldo \n3) Depositar \n4) Sacar");
            System.out.println("5) Transferência \n6) Render Conta \n7) Listar Contas");
            System.out.println("8) Remover Conta \n9) Filtrar Contas \n0) Sair \n");

            opcao = Integer.parseInt(entrada.nextLine());

            switch (opcao) {
                case 1:
                    criarConta();
                break;
                case 2:
                    consultarSaldo(verificarConta(0));
                break;
                case 3:
                    depositar(verificarConta(0));
                break;
                case 4:
                    sacar(verificarConta(0));
                break;
                case 5:
                    transferencia(verificarConta(1), verificarConta(2));
                break;
                case 6:
                   conferirRendimento(verificarConta(0));
                break;
                case 7:
                    listarContas();
                break;
                case 8:
                    removerConta(verificarConta(0));
                break;
                case 9:
                    filtrarConta();
                break;
                case 0:
                break;
                default:
                    System.out.println("\nOpção inválida!");
                break;
            }
        } while(opcao != 0);
    }

    public void criarConta() {
        String nome, cpf;
        int op;
        double limite, valor;
        Conta conta;

        System.out.println("\nDados da conta");

        System.out.print("\nDigite o nome do titular da conta: ");
        nome = entrada.nextLine();

        System.out.print("\nDigite o cpf: ");
        cpf = entrada.nextLine();

        Cliente umCliente = new Cliente(nome, cpf);

        System.out.print("\nDigite o valor do limite inicial: ");
        limite = Double.parseDouble(entrada.nextLine());

        System.out.println("\nGostaria de depositar um valor agora ? \n \n1) Sim \n2) Não \n");
        op = Integer.parseInt(entrada.nextLine());

        if(op == 1) {
            System.out.print("\nDigite o valor: ");
            valor = Double.parseDouble(entrada.nextLine());
            conta = new Conta(umCliente, limite, valor);
        } else {
            conta = new Conta(umCliente, limite);
        }

        contas.add(conta);
        System.out.println("\nConta de número " + conta.getNumeroConta() +" criada com sucesso!");
    }

    private Conta verificarConta(int aux) {
        int num;
        if (aux == 0) {
            System.out.print("\nDigite o número da conta: ");
        } else if (aux == 1) {
            System.out.print("\nDigite o número da conta origem: ");
        } else {
            System.out.print("\nDigite o número da conta destino: ");
        }
        num = Integer.parseInt(entrada.nextLine());
        for (Conta conta : contas) {
            if (conta.getNumeroConta() == num) {
                return conta;
            }
        }
        return null;
    }

    public void contaNaoCriada() {
        System.out.println("\nConta inexistente!");
    }

    public void consultarSaldo(Conta conta) {
        if(conta != null) {
            System.out.println("\n" + conta.getNomeCliente() + ", seu saldo é: " + NumberFormat.getCurrencyInstance().format(conta.getSaldo()));
        } else {
            contaNaoCriada();
        }
    }

    public void depositar(Conta conta) {
        if(conta != null) {
            System.out.print("\nDigite o valor para depósito: ");
            double valor = Double.parseDouble(entrada.nextLine());
            conta.deposito(valor);
            System.out.println("\nDepósito concluído! \n ");
        } else {
            contaNaoCriada();
        }
    }

    public void sacar(Conta conta) {
        if(conta != null) {
            System.out.print("\nDigite o valor para saque: ");
            double valor = Double.parseDouble(entrada.nextLine());
            if(!conta.saque(valor)) {
                System.out.println("\nSaldo Insuficiente \n ");
            } else {
                System.out.println("\nSaque efetuado com sucesso! \n ");
            }
        } else {
            contaNaoCriada();
        }
    }

    public void transferencia(Conta origem, Conta destino) {
        if(origem != null && destino != null) {
            System.out.print("\nDigite o valor para transferência: ");
            double valor = Double.parseDouble(entrada.nextLine());
            if(origem.transferencia(valor, destino)) {
                System.out.println("\nTransferência efetuada com sucesso! \n ");
            } else {
                System.out.println("\nNão foi possível realizar a transferência! \n ");
            }
        } else {
            contaNaoCriada();
        }
    }

    public void conferirRendimento(Conta conta) {
        if(conta != null) {
            if(conta.render()) {
                System.out.println("\nCom uma taxa de 15.7 % de rendimento, o saldo agora é de: " + NumberFormat.getCurrencyInstance().format(conta.getSaldo()));
            } else {
                System.out.println("Impossível render com saldo negativo!");
            }
        } else {
            contaNaoCriada();
        }
    }

    public void listarContas() {
        if (contas.size() > 0) {
            System.out.print("\n");
            for (Conta conta: contas) {
                System.out.println(conta.getNumeroConta() + " - " + conta.getNomeCliente());
            }
        } else {
            System.out.println("\nNão há contas cadastradas!");
        }
    }

    public void removerConta(Conta conta){
        int nroConta;
        if(conta != null) {
            if(conta.getSaldo() == 0) {
                nroConta = conta.getNumeroConta() - 1000;
                contas.remove(nroConta);
                System.out.println("\nConta removida com sucesso!");
            } else if (conta.getSaldo() > 0) {
                System.out.println("\nNão é possível cancelar contas com saldo disponível!");
            } else {
                System.out.println("\nNão é possível cancelar contas em débito!");
            }
        } else {
            contaNaoCriada();
        }
    }

    public void filtrarConta() {
        System.out.print("\nDigite a palavra que deseja filtrar: ");
        String palavra = entrada.nextLine();
        Boolean bool = true;
        for(Conta conta : contas) {
            if(conta.getNomeCliente().contains(palavra)) {
                System.out.println("\n" + conta.getNumeroConta() + " - " + conta.getNomeCliente());
                bool = false;
            }
        }
        if(bool) {
            System.out.println("\nNenhum cliente encontrado!");
        }
    }
}
