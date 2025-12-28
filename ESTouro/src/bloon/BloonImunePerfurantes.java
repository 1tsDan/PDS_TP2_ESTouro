package bloon;

public class BloonImunePerfurantes extends BloonDecorator {
    public BloonImunePerfurantes(Bloon b) {
        super(b);
    }

    @Override
    public int pop(int estrago) {
        return 0;
    }
}
