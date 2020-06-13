package Tp_1920_JoaoValente_2017016033.logica.estados;

import Tp_1920_JoaoValente_2017016033.logica.InteracaoEsperada;

public interface IEstado {
    IEstado escolhaDaNave(int i);
    IEstado continuarExplorar();
    IEstado saiDoEvento();
    IEstado saiDoEvento(int id);
    IEstado aterraSpaceStation();
    IEstado realizaUpgrades(int num1, int num2, int num3);
    IEstado decideConverterRecursos();
    IEstado aterraPlaneta();
    IEstado trocaTurno();
    IEstado converteRecursos(int opcao);
    IEstado continuaViagem();
    IEstado recomecaJogo();
    IEstado trocaMilagrosa(int value);
    IEstado desiste();
    InteracaoEsperada getInteracaoEsperada();
}
