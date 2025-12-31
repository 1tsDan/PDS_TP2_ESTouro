package torre.modo_ataque;

import java.util.List;
import java.awt.Point;

import bloon.Bloon;

public class AtacaLonge implements EstrategiaModoAtaque {
    private static final AtacaLonge INSTANCIA = new AtacaLonge();

    private AtacaLonge() {
    }
    
    public static EstrategiaModoAtaque getInstancia() {
        return INSTANCIA;
    }

	@Override
	public Point escolherAlvo(List<Bloon> bloons, Point centro) {
		return bloons.stream().map(b -> b.getComponente().getPosicaoCentro())
						.max((p1, p2) -> Double.compare(p1.distance(centro), p2.distance(centro)))
						.get();
	}
}
