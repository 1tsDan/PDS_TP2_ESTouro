package torre;

import java.awt.List;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import prof.jogos2D.image.*;
import prof.jogos2D.util.ImageLoader;
import torre.modo_ataque.AtacaForte;
import torre.modo_ataque.AtacaPrimeiro;
import torre.modo_ataque.EstrategiaModoAtaque;
import torre.projetil.Dardo;
import torre.projetil.Projetil;
import torre.VisitanteTorre;

/**
 * Classe que representa uma torre Macaco. Esta torre manda um dardo com dano de
 * 2. Só dispara quando tem bloons dentro do seu raio de ação e atira para o
 * bloon de acordo com o seu modo de ataque.
 */
public class TorreMacaco extends TorreDefault {

	/**
	 * Cria a torre macaco
	 *
	 * @param img a imagem da torre
	 */
	public TorreMacaco(BufferedImage img) {
		super(new ComponenteMultiAnimado(new Point(50, 50), img, 2, 4, 3), 30, 8, new Point(15, 15), 100);
	}

	@Override
	public Projetil[] criarProjetil(Point shoot, double angle) {
		Projetil p[] = new Projetil[1];
		ComponenteVisual img = new ComponenteAnimado(new Point(),
				(BufferedImage) ImageLoader.getLoader().getImage("data/torres/dardo.gif"), 2, 2);
		p[0] = new Dardo(img, angle, 10, 2);
		p[0].setPosicao(shoot);
		p[0].setAlcance(getRaioAcao() + 30);
		return p;
	}

	@Override
	public void aceita(VisitanteTorre v) {
		v.visitaTorreMacaco(this);
	}
}
