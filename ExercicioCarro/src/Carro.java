/* 
 * Classe que representa um carro
 */
public class Carro {
    // nome do carro
    private String nome;
    // velocidade atual do carro
    private int velocidadeAtual;

    /*
     * Construtor da classe.
     * 
     * O carro é construtído com o nome passado e começa com velocidade zero
     */ 
    public Carro(String nome) {
        this.nome = nome;
        this.velocidadeAtual = 0;
    }

    /* 
     * Retorna o nome do carro
     */
    public String getNome() {
        return this.nome;
    }

    /*
     * Retorna a velocidade atual do carro
     */
    public int getVelocidadeAtual() {
        return this.velocidadeAtual;
    }

    /*
     * Acelera o carro, aumentando a sua velocidade em 10 unidades
     */
    public void acelerar() {
        this.velocidadeAtual += 10;
    }

    /*
     * Reduz a velocidade do carro em 10 unidades.
     * A velocidade não pode se tornar negativa, retorna false se a velocidade não foi reduzida por causa disso
     */
    public boolean reduzir() {        
        if (this.velocidadeAtual - 10 >= 0) {
            this.velocidadeAtual -= 10;
            return true;
        }
        else {
            return false;
        }
    }
}
