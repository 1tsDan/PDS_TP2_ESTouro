package torre.modo_ataque;

import java.util.List;
import java.awt.Point;

import bloon.Bloon;

public interface ModoAtaque {
    public Point escolherAlvo(List<Bloon> bloons);
}
