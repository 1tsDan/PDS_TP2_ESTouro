package bloon;

public class BloonComEscudo extends BloonDecorator {
    private int durabilidade;

    public BloonComEscudo(Bloon b, int durabilidade) {
        super(b);

        if(durabilidade <= 0)
            throw new IllegalArgumentException("Durabilidade deve ser maior que zero.");
        this.durabilidade = durabilidade;
    }

    @Override
    public void explode(int estrago) {
        durabilidade--;
        if (durabilidade <= 0) {
            super.explode(estrago);
        }
    }
}
