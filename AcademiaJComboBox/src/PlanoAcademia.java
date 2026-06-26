public class PlanoAcademia {

    public static double calcularValor(Plano plano,
                                       Duracao duracao,
                                       Frequencia frequencia) {

        double valor = plano.getValor();

        valor *= frequencia.getAcrescimo();

        valor *= duracao.getDesconto();

        return valor;
    }
}