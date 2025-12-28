package torre.factory;

import java.io.PrintWriter;

import game.manipulator.ManipuladorTorre;
import game.manipulator.ManipuladorVazio;
import torre.Torre;

public class TorreCanhaoFactory extends TorreDefaultFactory {
    @Override
    public ManipuladorTorre criarManipulador(Torre t) {
        return new ManipuladorVazio(t);
    }

    @Override
    public void gravarInfoAdicional(Torre t, PrintWriter out) {
        out.println("canhao");
    }
}
