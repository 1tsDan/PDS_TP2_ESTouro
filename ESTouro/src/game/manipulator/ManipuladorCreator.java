package game.manipulator;

import torre.*;
import torre.VisitanteTorre;

/**
 * Classe responsável por criar todos os manipuladores. Esta classe existe para
 * que qualquer alteração nos manipuladores seja feita aqui, de modo a
 * permitir que apenas esta classe seja alterada em todo o sistema
 */
public class ManipuladorCreator implements VisitanteTorre{
    private ManipuladorTorre manipulador;

	/**
	 * cria um manipulador para a torre indicada
	 *
	 * @param t a torre para a qual se pretende um manipulador
	 * @return o manipulador adequado à torre
	 */
	public static ManipuladorTorre criarManipulador(Torre t) {
		// TODO DONE remover estes instanceof
        ManipuladorCreator visitante = new ManipuladorCreator();
        t.aceita(visitante);
        return visitante.manipulador;
	}

    @Override
    public void visitaTorreCanhao(Torre t) {
        manipulador = new ManipuladorVazio(t);
    }

    @Override
    public void visitaTorreBalista(Torre t) {
        manipulador = new ManipuladorBalista(t);
    }

    @Override
    public void visitaTorreSniper(Torre t) {
        manipulador = new ManipuladorSniper(t);
    }

    @Override
    public void visitaTorreMacaco(Torre t) {
        manipulador = new ManipuladorVazio(t);
    }

    @Override
    public void visitaTorreMorteiro(Torre t) {
        manipulador = new ManipuladorMorteiro(t);
    }

    @Override
    public void visitaTorreOctogonal(Torre t) {
        manipulador = new ManipuladorOcto(t);
    }

    @Override
    public void visitaTorreNinja(Torre t) {
        manipulador = new ManipuladorVazio(t);
    }
}
