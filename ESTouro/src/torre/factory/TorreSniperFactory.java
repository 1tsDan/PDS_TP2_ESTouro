package torre.factory;

import java.io.PrintWriter;

import game.manipulator.ManipuladorSniper;
import game.manipulator.ManipuladorTorre;
import torre.Torre;

public class TorreSniperFactory extends TorreDefaultFactory {
    @Override
    public ManipuladorTorre criarManipulador(Torre t) {
        return new ManipuladorSniper(t);
    }

    @Override
    public void gravarInfoAdicional(Torre t, PrintWriter out) {
        out.print("sniper\t");
					out.println(t.getComponente().getAngulo());
    }
}
