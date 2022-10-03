package Concessionaria;

import fabricaautomoveis.carros.Carro;
import fabricaautomoveis.carros.Categoria;
import fabricaautomoveis.carros.Marca;
import fabricaautomoveis.fabricas.FabricaCarro;

import java.util.ArrayList;
import java.util.List;

/**
 * Representa uma concessionária que vende carros de uma determinada Marca.
 */
public class Concessionaria {
    // Nome da concessionária
    private String nome;
    // Carros da concessionária
    private List<Carro> carros;
    private FabricaCarro fabrica;
    
    /**
     * Uma concessionária é construída com um nome e uma Marca da qual vende carros
     * @param nome O nome da concessionária.
     * @param marca A marca da qual a concessionária vende os carros
     */
    public Concessionaria(String nome, FabricaCarro fabrica) {
        this.nome = nome;        
        carros = new ArrayList<>();
        this.fabrica = fabrica;
    }
    
    /**
     * Retorna o nome da concessionária
     * 
     * @return O nome da concessionária
     */
    public String getNome() {
        return nome;
    }
    
    /**
     * Retorna a Marca da qual a concessionária vende os carros.
     * 
     * @return A marca dos carros
     */
    public Marca getMarcaFranquia() {
        return fabrica.getMarca();
    }
    
    /**
     * Realiza a compra de um carro de uma determinada categoria e com uma cor
     * @param categoria Categoria do carro a ser comprado.
     * @param cor Cor do carro a ser comprado
     * 
     * @return Verdadeiro se o carro pode ser comprado (modelo disponível)
     */
    public boolean criarCarrosConcessionaria(Categoria categoria, String cor) {
        Carro carro = null;

        carro = fabrica.criarCarro(categoria, cor);
        
        if (carro != null) {
            carro.produzir();
            carro.pintar();
            carro.liberarDocumentacao();
            carros.add(carro);
            return true;
        }
        else {
            return false;
        }
    }

    public void setFabrica(FabricaCarro fabrica) {
        this.fabrica = fabrica;
    }
}
