package fabricaautomoveis.fabricas;

import fabricaautomoveis.carros.*;

public class FabricaChevrolet extends FabricaCarro{

    public FabricaChevrolet() {
        super(Marca.CHEVROLET);
    }

    @Override
    public Carro criarCarro(Categoria categoria, String cor) {
        Carro carro = null;
        if (categoria == Categoria.POPULAR) {
            carro = new Monza(cor);
        }
        else if (categoria == Categoria.PICKUP) {
            carro = new Spin(cor);
        }
        else if (categoria == Categoria.LUXO) {
            carro = new Camaro(cor);
        }

        return carro;
    }
}
