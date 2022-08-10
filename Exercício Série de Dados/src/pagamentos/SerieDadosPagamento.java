package pagamentos;

import java.util.*;
import series.SerieDados;

public abstract class SerieDadosPagamento implements SerieDados {
    private int diaInicial;
    private int diaFinal;
    private String nomeLoja;
    private HashMap<Integer, Integer> dadosSerie;

    public SerieDadosPagamento(int diaInicial, int diaFinal, String nomeLoja) {
        this.diaInicial = diaInicial;
        this.diaFinal = diaFinal;
        this.nomeLoja = nomeLoja;
        dadosSerie = new HashMap<>();
    }

    public String getNomeLoja() {
        return nomeLoja;
    }

    @Override
    public int obterDiaInicial() {
        return diaInicial;
    }
    
    @Override
    public int obterDiaFinal() {
        return diaFinal;
    }

    @Override
    public int obterDado(int dia) {
        return dadosSerie.get(dia);
    }

    public Boolean inserirDado(int dia, int dado) {
        if(dia <= diaFinal && dia >= diaInicial) {
            dadosSerie.put(dia, dado);
            return true;
        }
        return false;
    }

}
