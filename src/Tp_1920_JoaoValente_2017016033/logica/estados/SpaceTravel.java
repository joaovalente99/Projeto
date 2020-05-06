package Tp_1920_JoaoValente_2017016033.logica.estados;

import Tp_1920_JoaoValente_2017016033.logica.dados.Constantes;
import Tp_1920_JoaoValente_2017016033.logica.dados.JogoDados;

public class SpaceTravel extends EstadoAdapter implements Constantes {

    public SpaceTravel(JogoDados jogo) {
        super(jogo);
    }

    @Override
    public IEstado continuarExplorar() {
        int ind = jogo.exploracao();
        if(ind == COMBUSTIVEL_ESGOTADO) {
            if(jogo.lastChance() == false)
                return new GameOver(jogo);
            else
                return new LastChance(jogo);
        }
        if(ind == CREW_FINISH)
            return new GameOver(jogo);
        else if(ind == CAI_EVENTO)
            return new Event(jogo);
        jogo.setPlanet(null);
        jogo.setAlien(null);
        return new SpaceTravel(jogo);
    }

    @Override
    public IEstado decideConverterRecursos() {
        return new ConvertResources(jogo);
    }

    @Override
    public IEstado aterraPlaneta() {
        if(jogo.getShip().getFuel() == 0)
            return new LastChance(jogo);
        jogo.getShip().gastaCombustivel();
        int msg = jogo.aterraPlaneta();
        if(msg == 0)
            return new SpaceTravel(jogo);
        return new LandOnThePlanet(jogo);
    }


    @Override
    public IEstado aterraSpaceStation() {
        jogo.getShip().gastaCombustivel();
        return new SpaceStation(jogo);
    }

}
