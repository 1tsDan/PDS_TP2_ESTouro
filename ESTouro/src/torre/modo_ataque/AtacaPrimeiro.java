package torre.modo_ataque;

import java.util.List;

import bloon.Bloon;

import java.awt.Point;

public class AtacaPrimeiro implements EstrategiaModoAtaque {
	@Override
	public Point escolherAlvo(List<Bloon> bloons, Point centro) {
		return bloons.stream().max((b1, b2) -> b1.getPosicaoNoCaminho() - b2.getPosicaoNoCaminho()).get().getComponente().getPosicaoCentro();
	}
}
