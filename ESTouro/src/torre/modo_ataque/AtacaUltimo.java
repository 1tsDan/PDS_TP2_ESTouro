package torre.modo_ataque;

import java.awt.Point;
import java.util.List;

import bloon.Bloon;

public class AtacaUltimo implements EstrategiaModoAtaque {
	private static final AtacaUltimo INSTANCIA = new AtacaUltimo();

    private AtacaUltimo() {
    }

    public static EstrategiaModoAtaque getInstancia() {
        return INSTANCIA;
    }

	@Override
	public Point escolherAlvo(List<Bloon> bloons, Point centro) {
		return bloons.stream().min((b1, b2) -> b1.getPosicaoNoCaminho() - b2.getPosicaoNoCaminho()).get().getComponente().getPosicaoCentro();
	}
}
