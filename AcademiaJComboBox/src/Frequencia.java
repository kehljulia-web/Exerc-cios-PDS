
public enum Frequencia {

    DUAS_VEZES("2x", 1.0),
    TRES_VEZES("3x", 1.2),
    CINCO_VEZES("5x", 1.5);

    private String descricao;
    private double acrescimo;

    Frequencia(String descricao, double acrescimo) {
        this.descricao = descricao;
        this.acrescimo = acrescimo;
    }

    public double getAcrescimo() {
        return acrescimo;
    }

    @Override
    public String toString() {
        return descricao;
    }
}