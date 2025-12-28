package torre.factory;

import java.io.PrintWriter;

import game.manipulator.ManipuladorMorteiro;
import game.manipulator.ManipuladorOcto;
import game.manipulator.ManipuladorTorre;
import torre.Torre;

public class TorreOctogonalFactory extends TorreDefaultFactory {
    @Override
    public ManipuladorTorre criarManipulador(Torre t) {
        return new ManipuladorOcto(t);
    }

    @Override
    public void gravarInfoAdicional(Torre t, PrintWriter out) {
        out.print("octo\t");
        out.println(t.getComponente().getAngulo());
    }
}
