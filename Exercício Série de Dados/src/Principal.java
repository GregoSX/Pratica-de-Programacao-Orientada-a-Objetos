import java.util.*;

import pagamentos.Controle;
import series.SerieDados;
import series.VisualizadorSeries;

public class Principal {
    public void executar() {
        Controle serie = new Controle();
        serie.adicionarDados();

        List<SerieDados> dados = new ArrayList<>();
        dados = serie.obterSeriesDados();

        VisualizadorSeries visualizador = new VisualizadorSeries(dados);
        visualizador.exibir();

        int diaInicial;
        int diaFinal;

        System.out.println("\n");
        for(SerieDados x : dados) {
            System.out.println("Dados da serie " + x.obterIdentificacaoSerie());

            diaInicial =x.obterDiaInicial();
            diaFinal = x.obterDiaFinal();
            executarLoop(diaInicial, diaFinal, x);

            System.out.println("...");
        }
    }

    private void executarLoop(int diaInicial, int diaFinal, SerieDados x) {
        for(int i = diaInicial; i <= diaFinal; i++) {
            System.out.println("Dia " + i + ": " + x.obterDado(i));
        }
    }
}
