package torre.factory;

import java.io.PrintWriter;

import game.manipulator.ManipuladorBalista;
import game.manipulator.ManipuladorTorre;
import torre.Torre;

public class TorreBalistaFactory extends TorreDefaultFactory {
    @Override
    public ManipuladorTorre criarManipulador(Torre t) {
        return new ManipuladorBalista(t);
    }

    @Override
    public void gravarInfoAdicional(Torre t, PrintWriter out) {
        out.print("balista\t");
					out.println(t.getComponente().getAngulo());
    }
}
