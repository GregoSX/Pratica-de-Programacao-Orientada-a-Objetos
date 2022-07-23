import java.util.Scanner;
import java.text.NumberFormat;

public class Banco {
    private Conta uConta1;
    private Conta uConta2;

    Scanner entrada = new Scanner(System.in);

    public void criarConta() {
        String nome;
        String cpf;
        int op;
        double limite;
        double valor;

        for (int i = 0; i < 2; i++) {
            System.out.print("\nDados da conta " + (i+1) + "\n");

            System.out.print("\nDigite o nome do titular da conta: ");
            nome = entrada.nextLine();

            System.out.print("\nDigite o cpf: ");
            cpf = entrada.nextLine();

            Cliente umCliente = new Cliente(nome, cpf);

            System.out.print("\nDigite o valor do limite inicial: ");
            limite = Double.parseDouble(entrada.nextLine());

            System.out.println("\nGostaria de depositar um valor agora ? \n 1) Sim \n 2) Não \n");
            op = Integer.parseInt(entrada.nextLine());

            if(op == 1) {
                System.out.print("\nDigite o valor: ");
                valor = Double.parseDouble(entrada.nextLine());
                if (i == 0) {
                    uConta1 = new Conta(umCliente, limite, valor);
                } else {
                    uConta2 = new Conta(umCliente, limite, valor);
                }
            } else {
                if (i == 0) {
                    uConta1 = new Conta(umCliente, limite);
                } else {
                    uConta2 = new Conta(umCliente, limite);
                }
            }

            if (i == 0) {
                System.out.println("\nConta de número " + uConta1.getNumeroConta() +" criada com sucesso! \n ");
            } else {
                System.out.println("\nConta de número " + uConta2.getNumeroConta() +" criada com sucesso! \n ");
            }
        }
    }

    public void menu() {
        int opcao;
        int num;
        int origem;
        int destino;

        do {
            System.out.println(" \n 1) Criar Conta \n 2) Consultar Saldo \n 3) Depositar \n 4) Sacar \n 5) Transferência \n 6) Render Conta \n 7) Sair \n");

            opcao = Integer.parseInt(entrada.nextLine());

            switch (opcao) {
                case 1:
                    criarConta();
                break;
                case 2:
                    System.out.print("\nDigite o número da conta que deseja consultar o saldo: ");
                    num = Integer.parseInt(entrada.nextLine());
                    if (num == uConta1.getNumeroConta()) {
                        consultarSaldo(uConta1);
                    } else if (num == uConta2.getNumeroConta()) {
                        consultarSaldo(uConta2);
                    } else {
                        System.out.println("\nNúmero de conta inexistente!");
                    }
                break;
                case 3:
                    System.out.print("\nDigite o número da conta que deseja depositar: ");
                    num = Integer.parseInt(entrada.nextLine());
                    if (num == uConta1.getNumeroConta()) {
                        depositar(uConta1);
                    } else if (num == uConta2.getNumeroConta()) {
                        depositar(uConta2);
                    } else {
                        System.out.println("\nNúmero de conta inexistente!");
                    }
                break;
                case 4:
                    System.out.print("\nDigite o número da conta que deseja sacar: ");
                    num = Integer.parseInt(entrada.nextLine());
                    if (num == uConta1.getNumeroConta()) {
                        sacar(uConta1);
                    } else if (num == uConta2.getNumeroConta()) {
                        sacar(uConta2);
                    } else {
                        System.out.println("\nNúmero de conta inexistente!");
                    }
                break;
                case 5:
                    System.out.print("\nDigite o número da conta origem: ");
                    origem = Integer.parseInt(entrada.nextLine());
                    System.out.print("\nDigite o número da conta destino: ");
                    destino = Integer.parseInt(entrada.nextLine());
                    if (origem == uConta1.getNumeroConta() && destino == uConta2.getNumeroConta()) {
                        transferencia(uConta1, uConta2);
                    } else if (origem == uConta2.getNumeroConta() && destino == uConta1.getNumeroConta()) {
                        transferencia(uConta2, uConta1);
                    } else {
                        System.out.println("\nNúmero de conta inexistente!");
                    }
                break;
                case 6:
                    System.out.print("\nDigite o número da conta que deseja render: ");
                    num = Integer.parseInt(entrada.nextLine());
                    if (num == uConta1.getNumeroConta()) {
                        conferirRendimento(uConta1);
                    } else if (num == uConta2.getNumeroConta()) {
                        conferirRendimento(uConta2);
                    } else {
                        System.out.println("\nNúmero de conta inexistente!");
                    }
                break;
                case 7:
                break;
                default:
                    System.out.println("\nOpção inválida!");
                break;
            }
        } while(opcao != 7);
    }

    public void consultarSaldo(Conta conta) {
        if(conta != null) {
            System.out.println("\n" + conta.getNomeCliente() + ", seu saldo é: " + NumberFormat.getCurrencyInstance().format(conta.getSaldo()));
        } else {
            System.out.println("\nCrie uma conta antes de realizar qualquer ação!");
        }
    }

    public void depositar(Conta conta) {
        if(conta != null) {
            System.out.print("\nDigite o valor para depósito: ");
            double valor = Double.parseDouble(entrada.nextLine());
            conta.deposito(valor);
            System.out.println("\nDepósito concluído! \n ");
        } else {
            System.out.println("\nCrie uma conta antes de realizar qualquer ação!");
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
            System.out.println("\nCrie uma conta antes de realizar qualquer ação!");
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
            System.out.println("\nCrie uma conta antes de realizar qualquer ação!");
        }
    }

    public void conferirRendimento(Conta conta) {
        if(conta != null) {
            if(conta.render()) {
                System.out.println("\nCom uma taxa de 15.7 % de rendimento, o saldo agora é de: " + NumberFormat.getCurrencyInstance().format(conta.getSaldo()));
            } else {
                System.out.println("Impossível rendar com saldo negativo!");
            }
        } else {
            System.out.println("\nCrie uma conta antes de realizar qualquer ação!");
        }
    }
}
