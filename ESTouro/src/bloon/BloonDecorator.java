package bloon;

import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;

import mundo.Caminho;
import mundo.Mundo;
import prof.jogos2D.image.ComponenteVisual;

public class BloonDecorator implements Bloon {
    private Bloon decorado;

    public BloonDecorator(Bloon b) {
        decorado = b;
    }

    @Override
    public void desenhar(Graphics2D g) {
        decorado.desenhar(g);
    }

    @Override
    public void mover() {
        decorado.mover();
    }

    @Override
    public ComponenteVisual getComponente() {
        return decorado.getComponente();
    }

    @Override
    public ComponenteVisual getPopComponente() {
        return decorado.getPopComponente();
    }

    @Override
    public void setCaminho(Caminho rua) {
        decorado.setCaminho(rua);
    }

    @Override
    public Caminho getCaminho() {
        return decorado.getCaminho();
    }

    @Override
    public int getPosicaoNoCaminho() {
        return decorado.getPosicaoNoCaminho();
    }

    @Override
    public void setPosicaoNoCaminho(int pos) {
        decorado.setPosicaoNoCaminho(pos);
    }

    @Override
    public void setVelocidade(float veloc) {
        decorado.setVelocidade(veloc);
    }

    @Override
    public float getVelocidade() {
        return decorado.getVelocidade();
    }

    @Override
    public void setMundo(Mundo w) {
        decorado.setMundo(w);
    }

    @Override
    public Mundo getMundo() {
        return decorado.getMundo();
    }

    @Override
    public void setPosicao(Point p) {
        decorado.setPosicao(p);
    }

    @Override
    public Rectangle getBounds() {
       return decorado.getBounds();
    }

    @Override
    public int pop(int estrago) {
        return decorado.pop(estrago);
    }

    @Override
    public void explode(int estrago) {
        decorado.explode(estrago);
    }

    @Override
    public int getResistencia() {
        return decorado.getResistencia();
    }

    @Override
    public int getValor() {
        return decorado.getValor();
    }

    @Override
    public void setValor(int val) {
       decorado.setValor(val);
    }

    @Override
    public void addBloonObserver(BloonObserver bo) {
        decorado.addBloonObserver(bo);
    }

    @Override
    public void removeBloonObserver(BloonObserver bo) {
        decorado.removeBloonObserver(bo);
    }
}
