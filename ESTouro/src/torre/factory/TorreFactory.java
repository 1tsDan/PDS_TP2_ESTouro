package torre.factory;

import java.io.PrintWriter;

import game.manipulator.ManipuladorTorre;
import torre.Torre;

public interface TorreFactory {
    public ManipuladorTorre criarManipulador(Torre t);
    public void gravarInfoAdicional(Torre t, PrintWriter out);
}
