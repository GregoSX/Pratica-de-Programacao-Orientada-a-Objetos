package fabricaautomoveis.fabricas;

import fabricaautomoveis.carros.*;

public abstract class FabricaCarro {
    private Marca marca;

    public FabricaCarro(Marca marca) {
        this.marca = marca;
    }

    public Marca getMarca() {
        return marca;
    }

    public abstract Carro criarCarro(Categoria categoria, String cor);
}
