package torre.modo_ataque;

import java.awt.Point;
import java.util.List;

import bloon.Bloon;

public interface EstrategiaModoAtaque {
    Point escolherAlvo(List<Bloon> bloons, Point centro);
}

