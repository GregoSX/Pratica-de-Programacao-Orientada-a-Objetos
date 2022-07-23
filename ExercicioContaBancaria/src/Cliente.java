public class Cliente {
    private String nome;
    private String cpf;

    public Cliente(String umNome, String umCpf) {
        nome = umNome;
        cpf = umCpf;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

}
