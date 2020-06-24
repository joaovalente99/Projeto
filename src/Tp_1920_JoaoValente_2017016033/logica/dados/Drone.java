package Tp_1920_JoaoValente_2017016033.logica.dados;

import java.io.Serializable;

public class Drone implements Serializable {
    private int armor; //quantidade de armor que tem
    private int x, y; //coordenadas do drone

    public Drone() {
        armor = 6;
    }

    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }

    public int getArmor() {
        return armor;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setArmor(int armor) {
        this.armor = armor;
    }

    @Override
    public String toString() {
        return "Drone{" +
                "armor=" + armor +
                '}';
    }

    public void avancaX() {
        if(x < 6)
            x++;
    }

    public void avancaY() {
        if(y < 6)
            y++;
    }

    public void recuaX() {
        if(x > 1)
            x--;
    }

    public void recuaY() {
        if(y > 1)
            y--;
    }

    public void recebeDano() {
        armor--;
    }
}

