package torre;

import java.awt.AlphaComposite;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Composite;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.geom.Line2D;
import java.awt.image.BufferedImage;
import java.util.List;

import bloon.Bloon;
import prof.jogos2D.image.*;
import prof.jogos2D.util.ImageLoader;
import torre.factory.TorreBalistaFactory;
import torre.factory.TorreFactory;
import torre.factory.TorreSniperFactory;
import torre.projetil.BombaImpacto;
import torre.projetil.Dardo;
import torre.projetil.Projetil;
import torre.visitor.VisitanteTorre;

/**
 * Classe que representa a torre balista. Esta torre dispara 1 dardo enorme e
 * potente na direção especificada pelo jogador.
 */
public class TorreSniper extends TorreDefault {

    private static final TorreFactory FACTORY = new TorreSniperFactory();

    private static final int ALCANCE = Integer.MAX_VALUE;

	private Point mira;
    private Point pontoDisparoInicial;

	public TorreSniper(BufferedImage img) {
		super(new ComponenteMultiAnimado(new Point(), img, 2, 4, 2),
				30, 0, new Point(20, -3), ALCANCE);
		setAnguloDisparo(0);
        setFactory(FACTORY);
	}

	public void setAnguloDisparo(float angulo) {
		getComponente().setAngulo(angulo);
		definirMira(angulo);
	}

	private void definirMira(double angulo) {
		double cos = Math.cos(angulo);
		double sin = Math.sin(angulo);
		Point centro = getComponente().getPosicaoCentro();
		mira = new Point((int) (centro.x + getRaioAcao() * cos), (int) (centro.y + getRaioAcao() * sin));
	}

	public Point getMira() {
		return mira;
	}

    @Override
    public Torre clone() {
        TorreSniper copia = (TorreSniper) super.clone();
        copia.mira = new Point(mira);
        return copia;
    }

	@Override
	public void setPosicao(Point p) {
		super.setPosicao(p);
		definirMira(getComponente().getAngulo());
	}

	@Override
	public void desenhaRaioAcao(Graphics2D g) {
		Point centro = getComponente().getPosicaoCentro();
		Point mira = getMira();
		Composite oldComp = g.getComposite();
		g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.5f));
		g.setColor(Color.BLUE);
		Line2D.Float l = new Line2D.Float(centro, mira);
		g.setStroke(new BasicStroke(20));
		g.draw(l);
		g.setColor(Color.WHITE);
		g.setStroke(new BasicStroke(18));
		g.draw(l);
		g.setComposite(oldComp);
	}

    @Override
    public List<Bloon> getAlvosPossiveis(List<Bloon> bloons) {
        return getBloonsInLine(bloons, getComponente().getPosicaoCentro(), mira);
    }

    @Override
    public Point escolherAlvo(List<Bloon> alvosPossiveis, Point centro){
        Point alvo = super.escolherAlvo(alvosPossiveis, centro);
        pontoDisparoInicial = alvo;
        return alvo;
    }

    @Override
    public double escolherAngulo(ComponenteMultiAnimado anim, Point posAlvo){
        return anim.getAngulo();
    }

    @Override
    public Projetil[] criarProjetil(Point shoot, double angle){
        Projetil p[] = new Projetil[1];

		ComponenteVisual img = new ComponenteSimples(ImageLoader.getLoader().getImage("data/torres/dardo.gif"));
		p[0] = new Dardo(img, angle, 10, 5);
		p[0].setPosicao(pontoDisparoInicial);
		p[0].setAlcance(getRaioAcao());
		return p;
    }

    @Override
    public void aceita(VisitanteTorre v) {
        v.visitaTorreSniper();
    }
}
