package fabricaautomoveis.fabricas;

import fabricaautomoveis.carros.*;

public class FabricaVW extends FabricaCarro{

    public FabricaVW( ) {
        super(Marca.VW);
    }

    @Override
    public Carro criarCarro(Categoria categoria, String cor) {
        Carro carro =  null;
        if (categoria == Categoria.POPULAR) {
            carro = new Gol(cor);
        } 
        else if (categoria == Categoria.PICKUP) {
            carro = new Saveiro(cor);
        } 
        else if (categoria == Categoria.LUXO) {
            carro = new Jetta(cor);
        }

        return carro;
    }
}
