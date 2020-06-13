package Tp_1920_JoaoValente_2017016033.logica.estados;

import Tp_1920_JoaoValente_2017016033.logica.InteracaoEsperada;
import Tp_1920_JoaoValente_2017016033.logica.dados.JogoDados;

public class WaitingShipSelection extends EstadoAdapter{

    public WaitingShipSelection(JogoDados jogo) {
        super(jogo);
    }

    @Override
    public IEstado escolhaDaNave(int i) {
        jogo.inicializa(i);
        return new SpaceTravel(jogo);
    }

    @Override
    public InteracaoEsperada getInteracaoEsperada() {
        return InteracaoEsperada.WAITING_SHIP_SELECTION;
    }
}
