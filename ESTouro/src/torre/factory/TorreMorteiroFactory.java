package torre.factory;

import java.awt.Point;
import java.io.PrintWriter;

import game.manipulator.ManipuladorBalista;
import game.manipulator.ManipuladorMorteiro;
import game.manipulator.ManipuladorTorre;
import torre.Torre;
import torre.TorreMorteiro;

public class TorreMorteiroFactory extends TorreDefaultFactory {
    @Override
    public ManipuladorTorre criarManipulador(Torre t) {
        return new ManipuladorMorteiro(t);
    }

    @Override
    public void gravarInfoAdicional(Torre t, PrintWriter out) {
        out.print("morteiro\t");
        Point ataque = ((TorreMorteiro) t).getAreaAlvo();
        out.println(ataque.x + "\t" + ataque.y);
    }
}
