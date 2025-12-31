package torre.modo_ataque;

import java.awt.Point;
import java.util.List;

import bloon.Bloon;

public class AtacaPerto implements EstrategiaModoAtaque {
    private static final AtacaPerto INSTANCIA = new AtacaPerto();

    private AtacaPerto() {
    }

    public static EstrategiaModoAtaque getInstancia() {
        return INSTANCIA;
    }

	@Override
	public Point escolherAlvo(List<Bloon> bloons, Point centro) {
		return bloons.stream().map(b -> b.getComponente().getPosicaoCentro())
						.min((p1, p2) -> Double.compare(p1.distance(centro), p2.distance(centro)))
						.get();
	}
}
