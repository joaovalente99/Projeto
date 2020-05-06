package Tp_1920_JoaoValente_2017016033.logica.dados;

public class BlueAlien extends Alien implements Constantes {

    public BlueAlien(int x, int y) {
        super(x, y);
    }

    @Override
    public int atack(int dado) {
        if(dado >= 3 && dado <= 5)
            return ATAQUE_SUCESSO;
        else
            return ATAQUE_FALHADO;
    }

    @Override
    public int defense(int dado) {
        if(dado >= 3 && dado <= 5)
            return MORTE;
        else
            return ATAQUE_FALHADO;
    }
}
