package Tp_1920_JoaoValente_2017016033.logica.estados;

import Tp_1920_JoaoValente_2017016033.logica.InteracaoEsperada;
import Tp_1920_JoaoValente_2017016033.logica.dados.JogoDados;

public class GameOver extends EstadoAdapter{

    public GameOver(JogoDados jogo) {
        super(jogo);
    }

    @Override
    public IEstado recomecaJogo() {
        return new WaitingShipSelection(jogo);
    }

    @Override
    public InteracaoEsperada getInteracaoEsperada() {
        return InteracaoEsperada.GAME_OVER;
    }
}
