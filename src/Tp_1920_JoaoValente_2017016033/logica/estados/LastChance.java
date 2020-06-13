package Tp_1920_JoaoValente_2017016033.logica.estados;

import Tp_1920_JoaoValente_2017016033.logica.InteracaoEsperada;
import Tp_1920_JoaoValente_2017016033.logica.dados.JogoDados;

public class LastChance extends EstadoAdapter{

    public LastChance(JogoDados jogo) {
        super(jogo);
    }

    @Override
    public IEstado trocaMilagrosa(int value) {
        jogo.trocaMilagrosa(value);
        //jogo.setPlanet(null);
        jogo.setAlien(null);
        return new SpaceTravel(jogo);
    }

    @Override
    public IEstado desiste() {
        return new GameOver(jogo);
    }

    @Override
    public InteracaoEsperada getInteracaoEsperada() {
        return InteracaoEsperada.LAST_CHANCE;
    }
}
