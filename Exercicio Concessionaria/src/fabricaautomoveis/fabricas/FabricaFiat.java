package fabricaautomoveis.fabricas;

import fabricaautomoveis.carros.*;

public class FabricaFiat extends FabricaCarro{

    public FabricaFiat( ) {
        super(Marca.FIAT);
    }

    @Override
    public Carro criarCarro(Categoria categoria, String cor) {
        Carro carro = null;
        if (categoria == Categoria.POPULAR) {
            carro = new Uno(cor);
        }
        else if (categoria == Categoria.PICKUP) {
            carro = new Strada(cor);
        }
        else if (categoria == Categoria.LUXO) {
            carro = new Freemont(cor);
        }

        return carro;
    }
}
