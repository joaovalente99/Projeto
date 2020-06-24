package Tp_1920_JoaoValente_2017016033.logica.estados;

import Tp_1920_JoaoValente_2017016033.logica.InteracaoEsperada;
import Tp_1920_JoaoValente_2017016033.logica.dados.JogoDados;

public class Event extends EstadoAdapter{

    public Event(JogoDados jogo) {
        super(jogo);
    }


    @Override
    public IEstado saiDoEvento() {
        if(jogo.caiEvento() == 0) {
            if(!jogo.lastChance())
                return new GameOver(jogo);
            else
                return new LastChance(jogo);
        }
        jogo.setPlanet(null);
        jogo.setAlien(null);
        return new SpaceTravel(jogo);
    }

    @Override
    public IEstado saiDoEvento(int id) {
        if(jogo.caiEvento(id) == 0) {
            if(!jogo.lastChance())
                return new GameOver(jogo);
            else
                return new LastChance(jogo);
        }
        jogo.setPlanet(null);
        jogo.setAlien(null);
        return new SpaceTravel(jogo);
    }

    @Override
    public InteracaoEsperada getInteracaoEsperada() {
        return InteracaoEsperada.EVENT;
    }
}
