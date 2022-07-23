import java.util.*;
public class Zoologico {
    // Colecao de lobos do zoologico
    private ArrayList<Lobo> lobos;
    // Colecao de gatos do zoologico
    private ArrayList<Gato> gatos;
    // Colecao de galinhas do zoologico
    private ArrayList<Galinha> galinhas;
    // Colecao de aguis do zoologico
    private ArrayList<Aguia> aguias;

    /* 
     * Construtor da classe
     */
    public Zoologico() {
        lobos = new ArrayList<>();
        gatos = new ArrayList<>();
        galinhas = new ArrayList<>();
        aguias = new ArrayList<>();
    }

    // Método que adiciona um lobo no zoologico
    public void adicionarLobo(String nome, String corPelo) {
        Lobo lobo = new Lobo(nome, corPelo);
        lobos.add(lobo);
    }
    // Método que adiciona um gato no zoologico
    public void adicionarGato(String nome, String corPelo) {
        Gato gato = new Gato(nome, corPelo);
        gatos.add(gato);
    }
    // Método que adiciona uma galinha no zoologico
    public void adicionarGalinha(String nome) {
        Galinha galinha = new Galinha(nome);
        galinhas.add(galinha);
    }
    // Método que adiciona uma aguia no zoologico
    public void adicionarAguia(String nome) {
        Aguia aguia = new Aguia(nome);
        aguias.add(aguia);
    }
    // Método que retorna a descrição detalhada de um animal dado o seu nome
    public String descricaoLongaUnica(String nome){
        String texto = nome + " não encontrado no zoologico!";
        for(Lobo animal : lobos) {
            if(animal.getNome().equals(nome)) {
                return animal.getDescricaoLonga();
            }
        }
        for(Gato animal : gatos) {
            if(animal.getNome().equals(nome)) {
                return animal.getDescricaoLonga();
            }
        }
        for(Galinha animal : galinhas) {
            if(animal.getNome().equals(nome)) {
                return animal.getDescricaoLonga();
            }
        }
        for(Aguia animal : aguias) {
            if(animal.getNome().equals(nome)) {
                return animal.getDescricaoLonga();
            }
        }
        return texto;
    }
    // Método que retorna a descricao curta de todos os animais do zoologico
    public String descricaoTodos() {
        String texto = "";
        for(Lobo animal : lobos) {
            texto += animal.getDescricao() + "\n";
        }
        for(Gato animal : gatos) {
            texto += animal.getDescricao() + "\n";
        }
        for(Galinha animal : galinhas) {
            texto += animal.getDescricao() + "\n";
        }
        for(Aguia animal : aguias) {
            texto += animal.getDescricao() + "\n";
        }
        if(texto.length() == 0) {
            texto = "Não há animais no zoologico!";
        }
        return texto;
    }
    //Método que retorna a descricao longa de todos os animais do zoologico
    public String descricaoLongaTodos() {
        String texto = "";
        for(Lobo animal : lobos) {
            texto += animal.getDescricaoLonga() + "\n";
        }
        for(Gato animal : gatos) {
            texto += animal.getDescricaoLonga() + "\n";
        }
        for(Galinha animal : galinhas) {
            texto += animal.getDescricaoLonga() + "\n";
        }
        for(Aguia animal : aguias) {
            texto += animal.getDescricaoLonga() + "\n";
        }
        if(texto.length() == 0) {
            texto = "Não há animais no zoologico!";
        }
        return texto;
    }
}
