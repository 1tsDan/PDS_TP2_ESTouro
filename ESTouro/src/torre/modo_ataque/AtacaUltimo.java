package torre.modo_ataque;

import java.awt.Point;
import java.util.List;

import bloon.Bloon;

public class AtacaUltimo implements EstrategiaModoAtaque {

	@Override
	public Point escolherAlvo(List<Bloon> bloons, Point centro) {
		return bloons.stream().min((b1, b2) -> b1.getPosicaoNoCaminho() - b2.getPosicaoNoCaminho()).get().getComponente().getPosicaoCentro();
	}
}
