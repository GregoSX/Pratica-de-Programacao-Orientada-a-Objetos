import java.util.*;
public class Zoologico {
    // Colecao de animais do zoologico
    private ArrayList<Animal> animais;

    // Construtor da classe
    public Zoologico() {
        animais = new ArrayList<>();
    }

    // Método que adiciona um lobo no zoologico
    public void adicionarLobo(String nome, String corPelo) {
        Lobo lobo = new Lobo(nome, corPelo);
        animais.add(lobo);
    }

    // Método que adiciona um gato no zoologico
    public void adicionarGato(String nome, String corPelo) {
        Gato gato = new Gato(nome, corPelo);
        animais.add(gato);
    }

    // Método que adiciona uma galinha no zoologico
    public void adicionarGalinha(String nome) {
        Galinha galinha = new Galinha(nome);
        animais.add(galinha);
    }

    // Método que adiciona uma aguia no zoologico
    public void adicionarAguia(String nome) {
        Aguia aguia = new Aguia(nome);
        animais.add(aguia);
    }

    // Método que retorna a descrição detalhada de um animal dado o seu nome
    public String descricaoLongaUnica(String nome){
        Animal animal = buscarAnimal(nome);
        if(animal == null) {
            return nome + " não encontrado no zoologico!";
        }
        return animal.getDescricaoLonga();        
    }

    // Método que retorna um animal dado seu nome
    private Animal buscarAnimal(String nome) {
        for(Animal animal : animais) {
            if(animal.getNome().equals(nome)) {
                return animal;
            }
        }
        return null;
    }

    // Método que retorna a descricao curta de todos os animais do zoologico
    public String descricaoTodos() {
        return pegarDescricao(1);
    }

    //Método que retorna a descricao longa de todos os animais do zoologico
    public String descricaoLongaTodos() {
       return pegarDescricao(2);
    }

    //Método para auxiliar na descrição dos animais
    private String pegarDescricao(int opcao) {
        if(animais.size() == 0) {
            return "Não há animais no zoologico!";
        }
        String texto = "";
        if (opcao == 1) {
            for(Animal animal : animais) {
                texto += animal.getDescricao() + "\n";
            }
        } else {
            for(Animal animal : animais) {
                texto += animal.getDescricaoLonga() + "\n";
            }
        }
        return texto;
    }
}
