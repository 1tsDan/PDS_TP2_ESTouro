package bloon;

public class BloonImuneExplosivos extends BloonDecorator {
    public BloonImuneExplosivos(Bloon b) {
        super(b);
    }

    @Override
    public void explode(int estrago) {
        return;
    }

    @Override
    public Bloon clone() {
        return new BloonImuneExplosivos(super.clone());
    }
}
