package pagamentos;

import java.util.ArrayList;
import java.util.List;

import series.ControladorSeries;
import series.SerieDados;

public class Controle implements ControladorSeries {
    private List<SerieDados> lista;

    public Controle() {
        lista = new ArrayList<>(); 
    }

    public void adicionarDados() {
        PagamentosPIX pix = new PagamentosPIX(3, 6, "techNike");
        PagamentosCredito credito = new PagamentosCredito(3, 6, "techNike");

        pix.inserirDado(3, 102);
        pix.inserirDado(4, 91);
        pix.inserirDado(5, 64);
        pix.inserirDado(6, 120);

        credito.inserirDado(3, 30);
        credito.inserirDado(4, 18);
        credito.inserirDado(5, 58);
        credito.inserirDado(6, 42);

        lista.add(pix);
        lista.add(credito);
    }

    public List<SerieDados> obterSeriesDados() {
        List<SerieDados> temp = lista;
        return temp;
    }

}
