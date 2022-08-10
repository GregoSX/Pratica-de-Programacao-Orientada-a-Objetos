package pagamentos;

public class PagamentosCredito extends SerieDadosPagamento{
    public PagamentosCredito(int diaInicial, int diaFinal, String nomeLoja) {
        super(diaInicial, diaFinal, nomeLoja);
    }

    @Override
    public String obterIdentificacaoSerie() {
        return "Pagamentos recebidos por cartão de crédito na loja " + getNomeLoja();
    }
}
