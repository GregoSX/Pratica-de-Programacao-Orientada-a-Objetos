public class Ave extends Animal {
    // Booleano que indice se a ave voa bem(true) ou mal(false)
    private Boolean voaBem;

    /* 
     * Construtor da classe
     */
    public Ave(String nome, String especie, String somCaracteristico, boolean voaBem) {
        super(nome, especie, 2, somCaracteristico);
        this.voaBem = voaBem;
    }

    /*
     * Retorna se a ave voa bem ou mal
     */
    public Boolean getVoaBem() {
        return voaBem;
    }

    /*
     * Método que retorna a descricao mais detalhada da ave
     */
    @Override
    public String getDescricaoLonga() {
        String texto = super.getDescricaoLonga();
        if(voaBem) {    
            texto += "voa bem";
        } else {
            texto += "voa mal";
        }
        return texto;
    }
}
