package bloon;

import java.awt.Graphics2D;

import prof.jogos2D.image.ComponenteVisual;

public class BloonComArmadura extends BloonDecorator {
    private ComponenteVisual armaduraImg;
    private int durabilidade;

    public BloonComArmadura(Bloon b, int durabilidade, ComponenteVisual armaduraImg) {
        super(b);
        this.armaduraImg = armaduraImg;
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

    @Override
	public void desenhar(Graphics2D g) {
		super.desenhar(g);
        armaduraImg.desenhar(g);
	}

    @Override
    public Bloon clone() {
        BloonComArmadura copia = (BloonComArmadura) super.clone();
        copia.armaduraImg = armaduraImg.clone();
        return copia;
    }
}
