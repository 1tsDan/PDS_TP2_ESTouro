package bloon;

public class BloonComArmadura extends BloonDecorator {
    private int durabilidade;

    public BloonComArmadura(Bloon b, int durabilidade) {
        super(b);
        
        if(durabilidade <= 0)
            throw new IllegalArgumentException("Durabilidade deve ser maior que zero.");
        this.durabilidade = durabilidade;
    }

    @Override
    public int pop(int estrago) {
        durabilidade--;
        if (durabilidade <= 0) {
            return super.pop(estrago);
        }

        return 0;
    }
}
