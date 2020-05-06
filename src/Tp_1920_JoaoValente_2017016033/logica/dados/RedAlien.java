package Tp_1920_JoaoValente_2017016033.logica.dados;

import Tp_1920_JoaoValente_2017016033.logica.dados.Alien;
import Tp_1920_JoaoValente_2017016033.logica.dados.Constantes;

public class RedAlien extends Alien implements Constantes {

    public RedAlien(int x, int y) {
        super(x, y);
    }

    @Override
    public int atack(int dado) {
        if(dado >= 5)
            return ATAQUE_SUCESSO;
        else
            return ATAQUE_FALHADO;
    }

    @Override
    public int defense(int dado) {
        if(dado <= 2)
            return MORTE;
        else
            return ATAQUE_FALHADO;
    }
}
