package Tp_1920_JoaoValente_2017016033.logica.estados;

import Tp_1920_JoaoValente_2017016033.logica.InteracaoEsperada;
import Tp_1920_JoaoValente_2017016033.logica.dados.JogoDados;

public class ConvertResources extends EstadoAdapter{

    public ConvertResources(JogoDados jogo) {
        super(jogo);
    }

    @Override
    public IEstado converteRecursos(int opcao) {
        jogo.converteRecursos(opcao);
        return new ConvertResources(jogo);
    }

    @Override
    public IEstado continuaViagem() {
        return new SpaceTravel(jogo);
    }

    @Override
    public InteracaoEsperada getInteracaoEsperada() {
        return InteracaoEsperada.CONVERT_RESOURCES;
    }
}
