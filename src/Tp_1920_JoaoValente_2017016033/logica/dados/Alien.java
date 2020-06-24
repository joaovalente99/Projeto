package Tp_1920_JoaoValente_2017016033.logica.dados;

import java.io.Serializable;

public abstract class Alien implements Serializable {
    private int x, y; //coordenadas do alien

    public Alien(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void avancaX() {
        x++;
    }

    public void avancaY() {
        y++;
    }

    public void recuaX() {
        x--;
    }

    public void recuaY() {
        y--;
    }

    public abstract int atack(int dado);
    public abstract int defense(int dado);


}
