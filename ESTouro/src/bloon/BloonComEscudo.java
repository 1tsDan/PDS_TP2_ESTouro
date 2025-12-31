package bloon;

import java.awt.Graphics2D;
import prof.jogos2D.image.ComponenteVisual;

public class BloonComEscudo extends BloonDecorator {
    private ComponenteVisual escudoImg;
    private int durabilidade;

    public BloonComEscudo(Bloon b, int durabilidade, ComponenteVisual escudoImg) {
        super(b);
        this.escudoImg = escudoImg;
        if (durabilidade <= 0)
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

   @Override
	public void desenhar(Graphics2D g) {
		super.desenhar(g);
        escudoImg.desenhar(g);
	}

    @Override
    public Bloon clone() {
        BloonComEscudo copia = (BloonComEscudo) super.clone();
        copia.escudoImg = escudoImg.clone();
        return copia;
    }
}
