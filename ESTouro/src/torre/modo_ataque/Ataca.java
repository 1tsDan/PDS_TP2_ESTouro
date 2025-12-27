package torre.modo_ataque;

import java.awt.Point;
import java.util.List;

import bloon.Bloon;

public class Ataca implements EstrategiaModoAtaque {

	@Override
	public Point escolherAlvo(List<Bloon> bloons, Point centro) {
		return bloons.stream().map(b -> b.getComponente().getPosicaoCentro())
						.min((p1, p2) -> Double.compare(p1.distance(centro), p2.distance(centro)))
						.get();
	}

    // private Point centro;

    // public AtacaPerto(Point centro) {
    //     this.centro = Objects.requireNonNull(centro);
    // }

	// @Override
	// public Point escolherAlvo(List<Bloon> bloons) {
	// 	return bloons.stream().map(b -> b.getComponente().getPosicaoCentro())
	// 					.min((p1, p2) -> Double.compare(p1.distance(centro), p2.distance(centro)))
	// 					.get();
	// }
}
