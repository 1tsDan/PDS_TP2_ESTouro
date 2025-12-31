package torre;

import java.awt.Point;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

import bloon.Bloon;
import prof.jogos2D.image.*;
import prof.jogos2D.util.ImageLoader;
import torre.factory.TorreFactory;
import torre.factory.TorreOctogonalFactory;
import torre.modo_ataque.EstrategiaModoAtaque;
import torre.projetil.Dardo;
import torre.projetil.Projetil;
import torre.visitor.VisitanteTorre;

/**
 * Classe que representa a torre octogonal. Esta torre dispara 8 dardos, um em
 * cada direção dos seus lançadores. Só dispara quando tem bloons dentro do seu
 * raio de ação.
 */
public class TorreOctogonal extends TorreDefault {
	private static final TorreFactory FACTORY = new TorreOctogonalFactory();
	private double baseAngle = 0;

	public TorreOctogonal(BufferedImage img) {
		super(new ComponenteMultiAnimado(new Point(), img, 2, 4, 2),
				20, 6, new Point(0, 0), 100, new ArrayList<EstrategiaModoAtaque>());
        setFactory(FACTORY);
	}

    @Override
    public double escolherAngulo(ComponenteMultiAnimado anim, Point posAlvo){
        return 0;
    }

    @Override
    public Projetil[] criarProjetil(Point shoot, double angle){
        Projetil p[] = new Projetil[8];
		double angulo = baseAngle + Math.PI / 2;
		double incAng = Math.PI / 4;
		for (int i = 0; i < 8; i++) {
			ComponenteVisual img = new ComponenteAnimado(new Point(),
					(BufferedImage) ImageLoader.getLoader().getImage("data/torres/dardo.gif"), 2, 2);
			p[i] = new Dardo(img, angulo, 8, 1);
			p[i].setPosicao(shoot);
			p[i].setAlcance(getRaioAcao() + 15);
			angulo -= incAng;
		}
		return p;
    }

	/**
	 * Altera o ângulo da octo
	 *
	 * @param angle o novo ângulo
	 */
	public void setAngle(double angle) {
		getComponente().setAngulo(angle);
		baseAngle = angle;
	}

    @Override
    public void aceita(VisitanteTorre visitante) {
        visitante.visitaTorreOctogonal();
    }
}
