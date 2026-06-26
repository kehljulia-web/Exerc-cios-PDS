public enum Duracao {

    MENSAL("Mensal", 1.0),
    SEMESTRAL("Semestral", 0.9),
    ANUAL("Anual", 0.8);

    private String descricao;
    private double desconto;

    Duracao(String descricao, double desconto) {
        this.descricao = descricao;
        this.desconto = desconto;
    }

    public double getDesconto() {
        return desconto;
    }

    @Override
    public String toString() {
        return descricao;
    }
}