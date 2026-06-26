
public enum Plano {

    BASICO("Básico", 80),
    INTERMEDIARIO("Intermediário", 120),
    PREMIUM("Premium", 180);

    private String descricao;
    private double valor;

    Plano(String descricao, double valor) {
        this.descricao = descricao;
        this.valor = valor;
    }

    public double getValor() {
        return valor;
    }

    @Override
    public String toString() {
        return descricao;
    }
}