package Tp_1920_JoaoValente_2017016033.logica.estados;

import Tp_1920_JoaoValente_2017016033.logica.InteracaoEsperada;
import Tp_1920_JoaoValente_2017016033.logica.dados.Constantes;
import Tp_1920_JoaoValente_2017016033.logica.dados.JogoDados;

public class LandOnThePlanet extends EstadoAdapter implements Constantes {

    public LandOnThePlanet(JogoDados jogo) {
        super(jogo);
    }

    @Override
    public IEstado trocaTurno() {
        int msg = jogo.trocaTurno();
        if(msg == SUCESSO_SAQUE) {
            int msg2 = jogo.recompensaDada();
            if(msg2 == 1)
                return new GameOver(jogo);
            return new SpaceTravel(jogo);
        }
        else if(msg == VITORIA_ALIEN)
            return new SpaceTravel(jogo);
        else
            return new LandOnThePlanet(jogo);
    }

    @Override
    public InteracaoEsperada getInteracaoEsperada() {
        return InteracaoEsperada.LAND_ON_THE_PLANET;
    }
}
