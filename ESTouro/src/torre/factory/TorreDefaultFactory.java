package torre.factory;

import java.io.PrintWriter;

import game.manipulator.ManipuladorTorre;
import game.manipulator.ManipuladorVazio;
import torre.Torre;

public abstract class TorreDefaultFactory implements TorreFactory {
    @Override
    public ManipuladorTorre criarManipulador(Torre t) {
        return new ManipuladorVazio(t);
    }

    @Override
    public void gravarInfoAdicional(Torre t, PrintWriter out) {
    }
}
