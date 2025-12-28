package torre.factory;

import java.io.PrintWriter;

import torre.Torre;

public class TorreMacacoFactory extends TorreDefaultFactory {
    @Override
    public void gravarInfoAdicional(Torre t, PrintWriter out) {
        out.println("macaco");
    }
}
