package torre.modo_ataque;

import java.awt.Point;
import java.util.List;

import bloon.Bloon;

public class AtacaForte implements EstrategiaModoAtaque {
	@Override
	public Point escolherAlvo(List<Bloon> bloons, Point centro) {
		return bloons.stream()
            .max((b1, b2) -> Integer.compare(
                b1.getValor(),
                b2.getValor()
            ))
            .get()
            .getComponente()
            .getPosicaoCentro();
	}
}
