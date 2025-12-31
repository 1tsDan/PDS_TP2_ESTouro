package io;

import java.awt.Point;
import java.io.*;
import java.util.List;

import torre.*;
import torre.visitor.VisitanteTorre;
import mundo.Mundo;

/**
 * Classe responsável pela gravação dos ficheiros de jogo
 */
public class GameWriter implements VisitanteTorre {

	/**
	 * grava o jogo no seu estado atual
	 *
	 * @param nomeFicheiro ficheiro onde guardar o jogo
	 * @param round        nível a que diz respeito o jogo gravado
	 * @param dinheiro     quanto dinheiro se tem
	 * @param vidas        as vidas que existiam
	 * @param m            o mundo tal como estava
	 * @throws IOException quando acontece algum erro de gravação
	 */
	public static void gravarJogo(String nomeFicheiro, int pista, int round, int dinheiro, int vidas, Mundo m)
			throws IOException {
		try (PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(nomeFicheiro)))) {
			out.println(pista);
			out.println(round);
			out.println(dinheiro);
			out.println(vidas);

			List<Torre> torres = m.getTorres();
			out.println(torres.size());
			// TODO DONE remover estes instanceof
			for (Torre t : torres) {
				Point p = t.getComponente().getPosicaoCentro();
				// escrever a posição e o tipo de torre
				out.print(p.x + "\t" + p.y + "\t");
				t.getFactory().gravarInfoAdicional(t, out);
				t.aceita(this);
			}
		}
	}

	@Override
	public void visitaTorreCanhao() {
		out.println("canhao");
	}

	@Override
	public void visitaTorreBalista() {
		out.print("balista\t");
		out.println(t.getComponente().getAngulo());
	}

	@Override
	public void visitaTorreSniper() {
		out.print("sniper\t");
		out.println(t.getComponente().getAngulo());
	}

	@Override
	public void visitaTorreMacaco() {
		out.println("macaco");
	}

	@Override
	public void visitaTorreMorteiro() {
		out.print("morteiro\t");
		Point ataque = ((TorreMorteiro) t).getAreaAlvo();
		out.println(ataque.x + "\t" + ataque.y);
	}

	@Override
	public void visitaTorreOctogonal() {
		out.print("octo\t");
		out.println(t.getComponente().getAngulo());
	}

	@Override
	public void visitaTorreNinja() {
		out.println("ninja");
	}

}
