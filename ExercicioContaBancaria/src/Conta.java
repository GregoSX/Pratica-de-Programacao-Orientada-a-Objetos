public class Conta {
    private double saldo;
    private double limite;
    private Cliente cliente;
    private static int nConta = 1000; 
    private int numeroConta;
    private static double taxa = 0.157;
    
    public Conta(Cliente umCliente, double umLimite) {
        this(umCliente, umLimite, 0);
    }

    public Conta(Cliente umCliente, double umLimite, double umSaldo) {
        saldo = umSaldo;
        limite = -(umLimite);
        cliente = umCliente;
        numeroConta = nConta;
        nConta++;
    }

    public double getSaldo() {
        return saldo;
    }

    public boolean saque (double valor) {
        if ((saldo - valor) > limite) {
            saldo = saldo - valor;
            return true;
        } else {
            return false;
        }
    }

    public void deposito(double valor) {
        saldo = saldo + valor;
    }

    public String getNomeCliente() {
        return cliente.getNome();
    }

    public int getNumeroConta() {
        return numeroConta;
    }

    public Boolean transferencia(double valor, Conta conta) {
        if (saque(valor)) {
            conta.deposito(valor);
            return true;
        } else {
            return false;
        }
    }

    public Boolean render() {
        if (saldo > 0) {
            saldo += saldo * taxa;
            return true;
        } else {
            return false;
        }
    }
}
