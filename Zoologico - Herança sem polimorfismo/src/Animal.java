public class Animal {
    // Nome do animal
    private String nome;
    // Especie do animal
    private String especie;
    // Quantidade de patas do animal
    private int qtdePatas;
    // Som caracteristico da especie
    private String somCaracteristico;

    /* 
     * Construtor da classe
     */
    public Animal(String nome, String especie, int qtdePatas, String somCaracteristico) {
        this.nome = nome;
        this.especie = especie;
        this.qtdePatas = qtdePatas;
        this.somCaracteristico = somCaracteristico;
    }

    /*
     * Método que retorna o nome do animal
     */
    public String getNome() {
        return nome;
    }
    /*
     * Método que retorna a especie do animal
     */
    public String getEspecie() {
        return especie;
    }
    /*
     * Método que retorna a quantidade de patas do animal
     */
    public int getQtdePatas() {
        return qtdePatas;
    }
    /*
     * Método que retorna o som caracteristico do animal
     */
    public String getSomCaracteristico() {
        return somCaracteristico;
    }
    /*
     * Método que retorna a descricao do animal
     */
    public String getDescricao() {
        String texto;
        texto = nome + " é um " + especie;
        return texto;
    }
    /*
     * Método que retorna a descricao mais detalhada do animal
     */
    public String getDescricaoLonga() {
        String texto;
        texto = getDescricao() + " que faz " + somCaracteristico + " e ";
        return texto;
    }
}