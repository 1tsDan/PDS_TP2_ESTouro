package torre;

import torre.Torre;

public interface VisitanteTorre {
    public void visitaTorreCanhao(Torre t);
    public void visitaTorreBalista(Torre t);
    public void visitaTorreSniper(Torre t);
    public void visitaTorreMacaco(Torre t);
    public void visitaTorreMorteiro(Torre t);
    public void visitaTorreOctogonal(Torre t);
    public void visitaTorreNinja(Torre t);
}
