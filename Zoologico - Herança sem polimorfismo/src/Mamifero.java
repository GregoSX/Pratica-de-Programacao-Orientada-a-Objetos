public class Mamifero extends Animal{
    // Cor do pelo do animal
    private String corPelo;

    /* 
     * Construtor da classe
     */
    public Mamifero(String nome, String especie, String somCaracteristico, String corPelo) {
        super(nome, especie, 4, somCaracteristico);
        this.corPelo = corPelo;
    }

    /* 
     * Método que retorna a cor do pelo do animal
     */
    public String getCorPelo() {
        return corPelo;
    }

    /*
     * Método que retorna a descricao mais detalhada do mamifero
     */
    @Override
    public String getDescricaoLonga() {
        String texto = super.getDescricaoLonga();
        texto += "tem pelo " + corPelo;
        return texto;
    }
}
