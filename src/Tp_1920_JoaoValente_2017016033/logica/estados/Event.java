package Tp_1920_JoaoValente_2017016033.logica.estados;

import Tp_1920_JoaoValente_2017016033.logica.dados.JogoDados;

public class Event extends EstadoAdapter{

    public Event(JogoDados jogo) {
        super(jogo);
    }


    @Override
    public IEstado saiDoEvento() {
        jogo.caiEvento();
        jogo.setPlanet(null);
        jogo.setAlien(null);
        return new SpaceTravel(jogo);
    }

    @Override
    public IEstado saiDoEvento(int id) {
        jogo.caiEvento(id);
        jogo.setPlanet(null);
        jogo.setAlien(null);
        return new SpaceTravel(jogo);
    }
}
