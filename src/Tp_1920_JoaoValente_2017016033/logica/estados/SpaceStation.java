package Tp_1920_JoaoValente_2017016033.logica.estados;

import Tp_1920_JoaoValente_2017016033.logica.InteracaoEsperada;
import Tp_1920_JoaoValente_2017016033.logica.dados.JogoDados;

public class SpaceStation extends EstadoAdapter{

    public SpaceStation(JogoDados jogo) {
        super(jogo);
    }

    @Override
    public IEstado realizaUpgrades(int num1, int num2, int num3) {
        jogo.realizaUpgrades(num1, num2, num3);
        return new SpaceStation(jogo);
    }

    @Override
    public IEstado continuaViagem() {
        return new SpaceTravel(jogo);
    }

    @Override
    public InteracaoEsperada getInteracaoEsperada() {
        return InteracaoEsperada.SPACE_STATION;
    }
}
