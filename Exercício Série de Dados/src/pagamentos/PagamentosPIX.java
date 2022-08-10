package pagamentos;

public class PagamentosPIX extends SerieDadosPagamento {
    public PagamentosPIX(int diaInicial, int diaFinal, String nomeLoja) {
        super(diaInicial, diaFinal, nomeLoja);
    }

    @Override
    public String obterIdentificacaoSerie() {
        return "Pagamentos recebidos por pix na loja " + getNomeLoja();
    }

}
