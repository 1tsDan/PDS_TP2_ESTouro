package bloon;

public class BloonImuneExplosivos extends BloonDecorator {
    public BloonImuneExplosivos(Bloon b) {
        super(b);
    }

    @Override
    public void explode(int estrago) {
        return;
    }
}
